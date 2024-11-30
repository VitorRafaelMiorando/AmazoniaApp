package com.example.amazoniaapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArvoreAdapter arvoreAdapter;
    private List<Arvore> listaArvores; // Lista principal
    private ArvoreDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // configuração do RecyclerView pra exibiçao das arvores
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        dbHelper = new ArvoreDatabaseHelper(this);

        // inicializa a lista principal
        listaArvores = new ArrayList<>();

        // configura a barra de pesquisa
        configurarBarraDePesquisa();

        // configura botão de atualizar dados
        Button btnAtualizarDados = findViewById(R.id.btnAtualizarDados);
        btnAtualizarDados.setOnClickListener(v -> atualizarDados());

        // verifica a conexao e carrega as árvores
        if (isConnectedToInternet()) {
            carregarArvores();
        } else {
            carregarArvoresDoBanco();
        }
    }

    private boolean isConnectedToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            // verifica a conexão com a internet
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                Network network = connectivityManager.getActiveNetwork();
                return network != null && connectivityManager.getNetworkCapabilities(network) != null;
            } else {
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
        }
        return false;
    }

    private void configurarBarraDePesquisa() {
        SearchView searchView = findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filtrarArvores(query); // filtra as arvores coforme a pesquisa
                return true;
            }

            @Override
            public boolean onQueryTextChange(String texto) {
                filtrarArvores(texto); // filtra enquanto o texto é digitado
                return true;
            }
        });
    }

    private void filtrarArvores(String texto) {
        if (listaArvores == null || listaArvores.isEmpty()) {
            Log.d("DEBUG", "Lista vazia ou não iniciada.");
            return; // retorna se a lista principal estiver vazia
        }

        List<Arvore> listaFiltrada = new ArrayList<>();
        for (Arvore arvore : listaArvores) {
            if (arvore.getNome().toLowerCase().contains(texto.toLowerCase())) {
                listaFiltrada.add(arvore);
            }
        }

        // atualiza a recyclerview com a lista filtrada
        if (arvoreAdapter != null) {
            arvoreAdapter.atualizarLista(listaFiltrada);
        }
    }

    // atualiza os dados quando o botão "atualizar dados" é clicado
    private void atualizarDados() {
        if (isConnectedToInternet()) {
            carregarArvores();
        } else {
            Toast.makeText(this, "Sem conexão com a internet.", Toast.LENGTH_SHORT).show();
            carregarArvoresDoBanco();
        }
    }

    // carrega as arvores da API
    private void carregarArvores() {
        new Thread(() -> {
            try {
                String urlBase = "http://sua/API/gellAllArvores";
                URL url = new URL(urlBase);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // processa a resposta JSON
                    List<Arvore> listaArvoresAPI = processarRespostaJSON(response.toString());
                    atualizarBancoDeDados(listaArvoresAPI);

                    // atualiza a lista principal e a recyclerview na thread principal
                    new Handler(Looper.getMainLooper()).post(() -> {
                        listaArvores = new ArrayList<>(listaArvoresAPI);
                        if (arvoreAdapter == null) {
                            arvoreAdapter = new ArvoreAdapter(listaArvores);
                            recyclerView.setAdapter(arvoreAdapter);
                        } else {
                            arvoreAdapter.atualizarLista(listaArvores);
                        }
                        Toast.makeText(MainActivity.this, "Árvores atualizadas.", Toast.LENGTH_SHORT).show();
                    });

                } else {
                    Log.e("API_ERROR", "Erro ao buscar dados: " + responseCode);
                    new Handler(Looper.getMainLooper()).post(() ->
                            Toast.makeText(MainActivity.this, "Erro ao buscar dados.", Toast.LENGTH_SHORT).show());
                }

                connection.disconnect();
            } catch (Exception e) {
                Log.e("API_ERROR", "Erro: " + e.getMessage(), e);
                new Handler(Looper.getMainLooper()).post(() ->
                        Toast.makeText(MainActivity.this, "Erro ao buscar dados.", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }

    // carrega as arvores do banco de dados local
    private void carregarArvoresDoBanco() {
        new Thread(() -> {
            List<Arvore> arvoresBanco = dbHelper.buscarTodasArvores();

            new Handler(Looper.getMainLooper()).post(() -> {
                listaArvores = new ArrayList<>(arvoresBanco);
                if (arvoreAdapter == null) {
                    arvoreAdapter = new ArvoreAdapter(listaArvores);
                    recyclerView.setAdapter(arvoreAdapter);
                } else {
                    arvoreAdapter.atualizarLista(listaArvores);
                }
                if (listaArvores.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nenhuma árvore encontrada no banco.", Toast.LENGTH_SHORT).show();
                }
            });
        }).start();
    }

    // processa a resposta JSON e retorna a lista de arvores
    private List<Arvore> processarRespostaJSON(String resposta) {
        List<Arvore> listaArvores = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(resposta);
            JSONArray jsonArray = jsonObject.getJSONArray("response");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject arvoreJSON = jsonArray.getJSONObject(i);

                Arvore arvore = new Arvore();
                arvore.setArvoreID(verificarValor(arvoreJSON.optString("arvoreID")));
                arvore.setNome(verificarValor(arvoreJSON.optString("nome")));
                arvore.setFrutificacao(verificarValor(arvoreJSON.optString("frutificacao")));
                arvore.setDescricaoBotanica(verificarValor(arvoreJSON.optString("descricaoBotanica")));
                arvore.setNomeCientifico(verificarValor(arvoreJSON.optString("nomeCientifico")));
                arvore.setSinonimos(verificarValor(arvoreJSON.optString("sinonimos")));
                arvore.setNomesVulgares(verificarValor(arvoreJSON.optString("nomesVulgares")));
                arvore.setEtimologia(verificarValor(arvoreJSON.optString("etimologia")));
                arvore.setFormaBiologica(verificarValor(arvoreJSON.optString("formaBiologica")));
                arvore.setTronco(verificarValor(arvoreJSON.optString("tronco")));
                arvore.setRamificacao(verificarValor(arvoreJSON.optString("ramificacao")));
                arvore.setCasca(verificarValor(arvoreJSON.optString("casca")));
                arvore.setFolhas(verificarValor(arvoreJSON.optString("folhas")));
                arvore.setInflorescencia(verificarValor(arvoreJSON.optString("inflorescencia")));
                arvore.setFlores(verificarValor(arvoreJSON.optString("flores")));
                arvore.setFrutos(verificarValor(arvoreJSON.optString("frutos")));
                arvore.setSementes(verificarValor(arvoreJSON.optString("sementes")));
                arvore.setBiologiaReprodutiva(verificarValor(arvoreJSON.optString("biologiaReprodutiva")));
                arvore.setFenologia(verificarValor(arvoreJSON.optString("fenologia")));
                arvore.setDispersao(verificarValor(arvoreJSON.optString("dispersao")));
                arvore.setOcorrenciaNatural(verificarValor(arvoreJSON.optString("ocorrenciaNatural")));
                arvore.setAspectosEcologicos(verificarValor(arvoreJSON.optString("aspectosEcologicos")));
                arvore.setRegeneracaoNatural(verificarValor(arvoreJSON.optString("regeneracaoNatural")));
                arvore.setAproveitamentoAlimentacao(verificarValor(arvoreJSON.optString("aproveitamentoAlimentacao")));
                arvore.setDadosNutricionais(verificarValor(arvoreJSON.optString("dadosNutricionais")));
                arvore.setFormasDeConsumo(verificarValor(arvoreJSON.optString("formasDeConsumo")));
                arvore.setAproveitamentoBiotecnologico(verificarValor(arvoreJSON.optString("aproveitamentoBiotecnologico")));
                arvore.setComposicao(verificarValor(arvoreJSON.optString("composicao")));
                arvore.setUsoMedicinal(verificarValor(arvoreJSON.optString("usoMedicinal")));
                arvore.setUsoPaisagistico(verificarValor(arvoreJSON.optString("usoPaisagistico")));
                arvore.setUsoMadeireiro(verificarValor(arvoreJSON.optString("usoMadeireiro")));
                arvore.setUsoApicola(verificarValor(arvoreJSON.optString("usoApicola")));
                arvore.setUsoIndustrial(verificarValor(arvoreJSON.optString("usoIndustrial")));
                arvore.setUsoEnergetico(verificarValor(arvoreJSON.optString("usoEnergetico")));
                arvore.setComposicaoQuimica(verificarValor(arvoreJSON.optString("composicaoQuimica")));
                arvore.setBioatividade(verificarValor(arvoreJSON.optString("bioatividade")));
                arvore.setPotenciaisBioprodutos(verificarValor(arvoreJSON.optString("potenciaisBioprodutos")));
                arvore.setTransplante(verificarValor(arvoreJSON.optString("transplante")));
                arvore.setCuidadosAgua(verificarValor(arvoreJSON.optString("cuidadosAgua")));
                arvore.setCuidadosSolo(verificarValor(arvoreJSON.optString("cuidadosSolo")));
                arvore.setPaisagismo(verificarValor(arvoreJSON.optString("paisagismo")));
                arvore.setColheitaBeneficiamentoSementes(verificarValor(arvoreJSON.optString("colheitaBeneficiamentoSementes")));
                arvore.setProducaoMudas(verificarValor(arvoreJSON.optString("producaoMudas")));
                arvore.setColheitaBeneficiamento(verificarValor(arvoreJSON.optString("colheitaBeneficiamento")));
                arvore.setSistemasAgroflorestais(verificarValor(arvoreJSON.optString("sistemasAgroflorestais")));
                arvore.setCultivoViveiros(verificarValor(arvoreJSON.optString("cultivoViveiros")));
                arvore.setCaracteristicasSilviculturais(verificarValor(arvoreJSON.optString("caracteristicasSilviculturais")));
                arvore.setPrincipaisPragas(verificarValor(arvoreJSON.optString("principaisPragas")));
                arvore.setSolos(verificarValor(arvoreJSON.optString("solos")));
                arvore.setLatitude(verificarValor(arvoreJSON.optString("latitude")));
                arvore.setLongitude(verificarValor(arvoreJSON.optString("longitude")));
                arvore.setFoto(verificarValor(arvoreJSON.optString("foto")));

                listaArvores.add(arvore);
            }
        } catch (Exception e) {
            Log.e("JSON_ERROR", "Erro ao processar JSON: " + e.getMessage());
        }
        return listaArvores;
    }

    // remove e adiciona árvores no banco de dados
    private void atualizarBancoDeDados(List<Arvore> listaArvoresAPI) {
        List<Arvore> listaArvoresBanco = dbHelper.buscarTodasArvores();

        // remove do banco as árvores que não estão mais na API
        for (Arvore arvoreBanco : listaArvoresBanco) {
            boolean encontradaNaAPI = false;
            for (Arvore arvoreAPI : listaArvoresAPI) {
                if (arvoreBanco.getArvoreID().equals(arvoreAPI.getArvoreID())) {
                    encontradaNaAPI = true;
                    break;
                }
            }
            if (!encontradaNaAPI) {
                dbHelper.excluirArvore(arvoreBanco.getArvoreID());
            }
        }

        // adiciona as novas arvores da API ao banco
        for (Arvore arvore : listaArvoresAPI) {
            if (!dbHelper.arvoreExiste(arvore.getArvoreID())) {
                dbHelper.salvarArvore(arvore);
            }
        }
    }

    // valores vazios são substituídos por "N/A"
    public String verificarValor(String valor) {
        return (valor == null || valor.isEmpty()) ? "N/A" : valor;
    }
}
