package com.example.amazoniaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetalhesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        // config da visu do mapa
        configurarMapa();

        // config da exibição de info detalhada da árvore
        configurarInformacoes();
    }

    //testando mapa
    private void configurarMapa() {
        ImageView ivMapa = findViewById(R.id.ivMapa);
        String latitude = getIntent().getStringExtra("latitude");
        String longitude = getIntent().getStringExtra("longitude");
        String token = "seu Mapbox token";

        if (latitude != null && longitude != null && !latitude.isEmpty() && !longitude.isEmpty()) {
            String mapaUrl = "https://api.mapbox.com/styles/v1/mapbox/satellite-v9/static/" +
                    "pin-l+ff0000(" + longitude + "," + latitude + ")/" +
                    longitude + "," + latitude + ",15/600x300?access_token=" + token;

            Glide.with(this)
                    .load(mapaUrl)
                    .into(ivMapa);
        } else {
            ivMapa.setVisibility(View.GONE);
            Toast.makeText(this, "Localização não disponível para esta árvore", Toast.LENGTH_SHORT).show();
        }
    }

    private void configurarInformacoes() {
        // elementos do layout
        ImageView ivFoto = findViewById(R.id.ivFotoDetalhes);
        TextView tvNome = findViewById(R.id.tvNome);
        TextView tvFrutificacao = findViewById(R.id.tvFrutificacao);
        TextView tvDescricaoBotanica = findViewById(R.id.tvDescricaoBotanica);
        TextView tvNomeCientifico = findViewById(R.id.tvNomeCientifico);
        TextView tvSinonimos = findViewById(R.id.tvSinonimos);
        TextView tvNomesVulgares = findViewById(R.id.tvNomesVulgares);
        TextView tvEtimologia = findViewById(R.id.tvEtimologia);
        TextView tvFormaBiologica = findViewById(R.id.tvFormaBiologica);
        TextView tvTronco = findViewById(R.id.tvTronco);
        TextView tvRamificacao = findViewById(R.id.tvRamificacao);
        TextView tvCasca = findViewById(R.id.tvCasca);
        TextView tvFolhas = findViewById(R.id.tvFolhas);
        TextView tvInflorescencia = findViewById(R.id.tvInflorescencia);
        TextView tvFlores = findViewById(R.id.tvFlores);
        TextView tvFrutos = findViewById(R.id.tvFrutos);
        TextView tvSementes = findViewById(R.id.tvSementes);
        TextView tvBiologiaReprodutiva = findViewById(R.id.tvBiologiaReprodutiva);
        TextView tvFenologia = findViewById(R.id.tvFenologia);
        TextView tvDispersao = findViewById(R.id.tvDispersao);
        TextView tvOcorrenciaNatural = findViewById(R.id.tvOcorrenciaNatural);
        TextView tvAspectosEcologicos = findViewById(R.id.tvAspectosEcologicos);
        TextView tvRegeneracaoNatural = findViewById(R.id.tvRegeneracaoNatural);
        TextView tvAproveitamentoAlimentacao = findViewById(R.id.tvAproveitamentoAlimentacao);
        TextView tvDadosNutricionais = findViewById(R.id.tvDadosNutricionais);
        TextView tvFormasDeConsumo = findViewById(R.id.tvFormasDeConsumo);
        TextView tvAproveitamentoBiotecnologico = findViewById(R.id.tvAproveitamentoBiotecnologico);
        TextView tvComposicao = findViewById(R.id.tvComposicao);
        TextView tvUsoMedicinal = findViewById(R.id.tvUsoMedicinal);
        TextView tvUsoPaisagistico = findViewById(R.id.tvUsoPaisagistico);
        TextView tvUsoMadeireiro = findViewById(R.id.tvUsoMadeireiro);
        TextView tvUsoApicola = findViewById(R.id.tvUsoApicola);
        TextView tvUsoIndustrial = findViewById(R.id.tvUsoIndustrial);
        TextView tvUsoEnergetico = findViewById(R.id.tvUsoEnergetico);
        TextView tvComposicaoQuimica = findViewById(R.id.tvComposicaoQuimica);
        TextView tvBioatividade = findViewById(R.id.tvBioatividade);
        TextView tvPotenciaisBioprodutos = findViewById(R.id.tvPotenciaisBioprodutos);
        TextView tvTransplante = findViewById(R.id.tvTransplante);
        TextView tvCuidadosAgua = findViewById(R.id.tvCuidadosAgua);
        TextView tvCuidadosSolo = findViewById(R.id.tvCuidadosSolo);
        TextView tvPaisagismo = findViewById(R.id.tvPaisagismo);
        TextView tvColheitaBeneficiamentoSementes = findViewById(R.id.tvColheitaBeneficiamentoSementes);
        TextView tvProducaoMudas = findViewById(R.id.tvProducaoMudas);
        TextView tvColheitaBeneficiamento = findViewById(R.id.tvColheitaBeneficiamento);
        TextView tvSistemasAgroflorestais = findViewById(R.id.tvSistemasAgroflorestais);
        TextView tvCultivoViveiros = findViewById(R.id.tvCultivoViveiros);
        TextView tvCaracteristicasSilviculturais = findViewById(R.id.tvCaracteristicasSilviculturais);
        TextView tvPrincipaisPragas = findViewById(R.id.tvPrincipaisPragas);
        TextView tvSolos = findViewById(R.id.tvSolos);
        TextView tvLatitude = findViewById(R.id.tvLatitude);
        TextView tvLongitude = findViewById(R.id.tvLongitude);


        // recebe e atribui o dados do intent
        Glide.with(this).load(getIntent().getStringExtra("foto")).into(ivFoto);
        tvNome.setText(getIntent().getStringExtra("nome"));
        tvFrutificacao.setText(getIntent().getStringExtra("frutificacao"));
        tvDescricaoBotanica.setText(getIntent().getStringExtra("descricaoBotanica"));
        tvNomeCientifico.setText(getIntent().getStringExtra("nomeCientifico"));
        tvSinonimos.setText(getIntent().getStringExtra("sinonimos"));
        tvNomesVulgares.setText(getIntent().getStringExtra("nomesVulgares"));
        tvEtimologia.setText(getIntent().getStringExtra("etimologia"));
        tvFormaBiologica.setText(getIntent().getStringExtra("formaBiologica"));
        tvTronco.setText(getIntent().getStringExtra("tronco"));
        tvRamificacao.setText(getIntent().getStringExtra("ramificacao"));
        tvCasca.setText(getIntent().getStringExtra("casca"));
        tvFolhas.setText(getIntent().getStringExtra("folhas"));
        tvInflorescencia.setText(getIntent().getStringExtra("inflorescencia"));
        tvFlores.setText(getIntent().getStringExtra("flores"));
        tvFrutos.setText(getIntent().getStringExtra("frutos"));
        tvSementes.setText(getIntent().getStringExtra("sementes"));
        tvBiologiaReprodutiva.setText(getIntent().getStringExtra("biologiaReprodutiva"));
        tvFenologia.setText(getIntent().getStringExtra("fenologia"));
        tvDispersao.setText(getIntent().getStringExtra("dispersao"));
        tvOcorrenciaNatural.setText(getIntent().getStringExtra("ocorrenciaNatural"));
        tvAspectosEcologicos.setText(getIntent().getStringExtra("aspectosEcologicos"));
        tvRegeneracaoNatural.setText(getIntent().getStringExtra("regeneracaoNatural"));
        tvAproveitamentoAlimentacao.setText(getIntent().getStringExtra("aproveitamentoAlimentacao"));
        tvDadosNutricionais.setText(getIntent().getStringExtra("dadosNutricionais"));
        tvFormasDeConsumo.setText(getIntent().getStringExtra("formasDeConsumo"));
        tvAproveitamentoBiotecnologico.setText(getIntent().getStringExtra("aproveitamentoBiotecnologico"));
        tvComposicao.setText(getIntent().getStringExtra("composicao"));
        tvUsoMedicinal.setText(getIntent().getStringExtra("usoMedicinal"));
        tvUsoPaisagistico.setText(getIntent().getStringExtra("usoPaisagistico"));
        tvUsoMadeireiro.setText(getIntent().getStringExtra("usoMadeireiro"));
        tvUsoApicola.setText(getIntent().getStringExtra("usoApicola"));
        tvUsoIndustrial.setText(getIntent().getStringExtra("usoIndustrial"));
        tvUsoEnergetico.setText(getIntent().getStringExtra("usoEnergetico"));
        tvComposicaoQuimica.setText(getIntent().getStringExtra("composicaoQuimica"));
        tvBioatividade.setText(getIntent().getStringExtra("bioatividade"));
        tvPotenciaisBioprodutos.setText(getIntent().getStringExtra("potenciaisBioprodutos"));
        tvTransplante.setText(getIntent().getStringExtra("transplante"));
        tvCuidadosAgua.setText(getIntent().getStringExtra("cuidadosAgua"));
        tvCuidadosSolo.setText(getIntent().getStringExtra("cuidadosSolo"));
        tvPaisagismo.setText(getIntent().getStringExtra("paisagismo"));
        tvColheitaBeneficiamentoSementes.setText(getIntent().getStringExtra("colheitaBeneficiamentoSementes"));
        tvProducaoMudas.setText(getIntent().getStringExtra("producaoMudas"));
        tvColheitaBeneficiamento.setText(getIntent().getStringExtra("colheitaBeneficiamento"));
        tvSistemasAgroflorestais.setText(getIntent().getStringExtra("sistemasAgroflorestais"));
        tvCultivoViveiros.setText(getIntent().getStringExtra("cultivoViveiros"));
        tvCaracteristicasSilviculturais.setText(getIntent().getStringExtra("caracteristicasSilviculturais"));
        tvPrincipaisPragas.setText(getIntent().getStringExtra("principaisPragas"));
        tvSolos.setText(getIntent().getStringExtra("solos"));
        tvLatitude.setText(getIntent().getStringExtra("latitude"));
        tvLongitude.setText(getIntent().getStringExtra("longitude"));
    }
}
