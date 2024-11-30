package com.example.amazoniaapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.List;

public class ArvoreAdapter extends RecyclerView.Adapter<ArvoreAdapter.ArvoreViewHolder> {

    private List<Arvore> listaArvores;

    public ArvoreAdapter(List<Arvore> listaArvores) {
        this.listaArvores = listaArvores;
    }

    @NonNull
    @Override
    public ArvoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_arvore, parent, false);
        return new ArvoreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArvoreViewHolder holder, int position) {
        Arvore arvore = listaArvores.get(position);

        // define os dados basicos no viewholder
        holder.nome.setText(arvore.getNome());
        holder.descricao.setText(arvore.getDescricaoBotanica());

        // carrega a imagem da arvore
        Glide.with(holder.itemView.getContext())
                .load(arvore.getFoto())
                .into(holder.imagem);

        // clique no item para abrir os detalhes
        holder.itemView.setOnClickListener(v -> abrirDetalhes(holder.itemView, arvore));
    }

    @Override
    public int getItemCount() {
        return listaArvores.size();
    }

    public void atualizarLista(List<Arvore> novaLista) {
        this.listaArvores.clear();
        this.listaArvores.addAll(novaLista);
        notifyDataSetChanged();
    }

    private void abrirDetalhes(View itemView, Arvore arvore) {
        Intent intent = new Intent(itemView.getContext(), DetalhesActivity.class);

        // prepara os dados pra serem enviados pra DetalhesActivity
        intent.putExtra("arvoreID", arvore.getArvoreID());
        intent.putExtra("nome", arvore.getNome());
        intent.putExtra("frutificacao", arvore.getFrutificacao());
        intent.putExtra("descricaoBotanica", arvore.getDescricaoBotanica());
        intent.putExtra("nomeCientifico", arvore.getNomeCientifico());
        intent.putExtra("sinonimos", arvore.getSinonimos());
        intent.putExtra("nomesVulgares", arvore.getNomesVulgares());
        intent.putExtra("etimologia", arvore.getEtimologia());
        intent.putExtra("formaBiologica", arvore.getFormaBiologica());
        intent.putExtra("tronco", arvore.getTronco());
        intent.putExtra("ramificacao", arvore.getRamificacao());
        intent.putExtra("casca", arvore.getCasca());
        intent.putExtra("folhas", arvore.getFolhas());
        intent.putExtra("inflorescencia", arvore.getInflorescencia());
        intent.putExtra("flores", arvore.getFlores());
        intent.putExtra("frutos", arvore.getFrutos());
        intent.putExtra("sementes", arvore.getSementes());
        intent.putExtra("biologiaReprodutiva", arvore.getBiologiaReprodutiva());
        intent.putExtra("fenologia", arvore.getFenologia());
        intent.putExtra("dispersao", arvore.getDispersao());
        intent.putExtra("ocorrenciaNatural", arvore.getOcorrenciaNatural());
        intent.putExtra("aspectosEcologicos", arvore.getAspectosEcologicos());
        intent.putExtra("regeneracaoNatural", arvore.getRegeneracaoNatural());
        intent.putExtra("aproveitamentoAlimentacao", arvore.getAproveitamentoAlimentacao());
        intent.putExtra("dadosNutricionais", arvore.getDadosNutricionais());
        intent.putExtra("formasDeConsumo", arvore.getFormasDeConsumo());
        intent.putExtra("aproveitamentoBiotecnologico", arvore.getAproveitamentoBiotecnologico());
        intent.putExtra("composicao", arvore.getComposicao());
        intent.putExtra("usoMedicinal", arvore.getUsoMedicinal());
        intent.putExtra("usoPaisagistico", arvore.getUsoPaisagistico());
        intent.putExtra("usoMadeireiro", arvore.getUsoMadeireiro());
        intent.putExtra("usoApicola", arvore.getUsoApicola());
        intent.putExtra("usoIndustrial", arvore.getUsoIndustrial());
        intent.putExtra("usoEnergetico", arvore.getUsoEnergetico());
        intent.putExtra("composicaoQuimica", arvore.getComposicaoQuimica());
        intent.putExtra("bioatividade", arvore.getBioatividade());
        intent.putExtra("potenciaisBioprodutos", arvore.getPotenciaisBioprodutos());
        intent.putExtra("transplante", arvore.getTransplante());
        intent.putExtra("cuidadosAgua", arvore.getCuidadosAgua());
        intent.putExtra("cuidadosSolo", arvore.getCuidadosSolo());
        intent.putExtra("paisagismo", arvore.getPaisagismo());
        intent.putExtra("colheitaBeneficiamentoSementes", arvore.getColheitaBeneficiamentoSementes());
        intent.putExtra("producaoMudas", arvore.getProducaoMudas());
        intent.putExtra("colheitaBeneficiamento", arvore.getColheitaBeneficiamento());
        intent.putExtra("sistemasAgroflorestais", arvore.getSistemasAgroflorestais());
        intent.putExtra("cultivoViveiros", arvore.getCultivoViveiros());
        intent.putExtra("caracteristicasSilviculturais", arvore.getCaracteristicasSilviculturais());
        intent.putExtra("principaisPragas", arvore.getPrincipaisPragas());
        intent.putExtra("solos", arvore.getSolos());
        intent.putExtra("latitude", arvore.getLatitude());
        intent.putExtra("longitude", arvore.getLongitude());
        intent.putExtra("foto", arvore.getFoto());

        itemView.getContext().startActivity(intent);
    }

    public static class ArvoreViewHolder extends RecyclerView.ViewHolder {
        TextView nome, descricao;
        ImageView imagem;

        public ArvoreViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tvNome);
            descricao = itemView.findViewById(R.id.tvDescricao);
            imagem = itemView.findViewById(R.id.ivFoto);
        }
    }
}
