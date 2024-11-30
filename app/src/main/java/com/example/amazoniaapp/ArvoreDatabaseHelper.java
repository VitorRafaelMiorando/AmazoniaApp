package com.example.amazoniaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

public class ArvoreDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "arvores.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ARVORES = "arvores";

    // definindo as colunas da tabela de árvores
    private static final String COLUMN_ARVORE_ID = "arvoreID";
    private static final String COLUMN_IS_DELETED = "isDeleted";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_FRUTIFICACAO = "frutificacao";
    private static final String COLUMN_DESCRICAO_BOTANICA = "descricaoBotanica";
    private static final String COLUMN_NOME_CIENTIFICO = "nomeCientifico";
    private static final String COLUMN_SINONIMOS = "sinonimos";
    private static final String COLUMN_NOMES_VULGARES = "nomesVulgares";
    private static final String COLUMN_ETIMOLOGIA = "etimologia";
    private static final String COLUMN_FORMA_BIOLOGICA = "formaBiologica";
    private static final String COLUMN_TRONCO = "tronco";
    private static final String COLUMN_RAMIFICACAO = "ramificacao";
    private static final String COLUMN_CASCA = "casca";
    private static final String COLUMN_FOLHAS = "folhas";
    private static final String COLUMN_INFLORESCENCIA = "inflorescencia";
    private static final String COLUMN_FLORES = "flores";
    private static final String COLUMN_FRUTOS = "frutos";
    private static final String COLUMN_SEMENTES = "sementes";
    private static final String COLUMN_BIOLOGIA_REPRODUTIVA = "biologiaReprodutiva";
    private static final String COLUMN_FENOLOGIA = "fenologia";
    private static final String COLUMN_DISPERSAO = "dispersao";
    private static final String COLUMN_OCORRENCIA_NATURAL = "ocorrenciaNatural";
    private static final String COLUMN_ASPECTOS_ECOLOGICOS = "aspectosEcologicos";
    private static final String COLUMN_REGENERACAO_NATURAL = "regeneracaoNatural";
    private static final String COLUMN_APROVEITAMENTO_ALIMENTACAO = "aproveitamentoAlimentacao";
    private static final String COLUMN_DADOS_NUTRICIONAIS = "dadosNutricionais";
    private static final String COLUMN_FORMAS_DE_CONSUMO = "formasDeConsumo";
    private static final String COLUMN_APROVEITAMENTO_BIOTECNOLOGICO = "aproveitamentoBiotecnologico";
    private static final String COLUMN_COMPOSICAO = "composicao";
    private static final String COLUMN_USO_MEDICINAL = "usoMedicinal";
    private static final String COLUMN_USO_PAISAGISTICO = "usoPaisagistico";
    private static final String COLUMN_USO_MADEIREIRO = "usoMadeireiro";
    private static final String COLUMN_USO_APICOLA = "usoApicola";
    private static final String COLUMN_USO_INDUSTRIAL = "usoIndustrial";
    private static final String COLUMN_USO_ENERGETICO = "usoEnergetico";
    private static final String COLUMN_COMPOSICAO_QUIMICA = "composicaoQuimica";
    private static final String COLUMN_BIOATIVIDADE = "bioatividade";
    private static final String COLUMN_POTENCIAIS_BIOPRODUTOS = "potenciaisBioprodutos";
    private static final String COLUMN_TRANSPLANTE = "transplante";
    private static final String COLUMN_CUIDADOS_AGUA = "cuidadosAgua";
    private static final String COLUMN_CUIDADOS_SOLO = "cuidadosSolo";
    private static final String COLUMN_PAISAGISMO = "paisagismo";
    private static final String COLUMN_COLHEITA_BENEFICIAMENTO_SEMENTES = "colheitaBeneficiamentoSementes";
    private static final String COLUMN_PRODUCAO_MUDAS = "producaoMudas";
    private static final String COLUMN_COLHEITA_BENEFICIAMENTO = "colheitaBeneficiamento";
    private static final String COLUMN_SISTEMAS_AGROFLORESTAIS = "sistemasAgroflorestais";
    private static final String COLUMN_CULTIVO_VIVEIROS = "cultivoViveiros";
    private static final String COLUMN_CARACTERISTICAS_SILVICULTURAIS = "caracteristicasSilviculturais";
    private static final String COLUMN_PRINCIPAIS_PRAGAS = "principaisPragas";
    private static final String COLUMN_SOLOS = "solos";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_INSERT_DATE = "insertDate";
    private static final String COLUMN_UPDATE_DATE = "updateDate";
    private static final String COLUMN_FOTO = "foto";

    public ArvoreDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // verifica se uma arvore com o ID já existe no banco
    public boolean arvoreExiste(String arvoreID) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + TABLE_ARVORES + " WHERE " + COLUMN_ARVORE_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{arvoreID});

        boolean exists = false;
        if (cursor != null) {
            cursor.moveToFirst();
            exists = cursor.getInt(0) > 0;
            cursor.close();
        }
        db.close();
        return exists;
    }

    // metodo para excluir arvores q não estão mais cadastradas na API
    public void excluirArvore(String arvoreID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ARVORES, COLUMN_ARVORE_ID + " = ?", new String[]{arvoreID});
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // criaçao da tabela no banco de dados
        String CREATE_TABLE = "CREATE TABLE " + TABLE_ARVORES + " (" +
                COLUMN_ARVORE_ID + " TEXT PRIMARY KEY, " +
                COLUMN_IS_DELETED + " INTEGER, " +
                COLUMN_NOME + " TEXT, " +
                COLUMN_FRUTIFICACAO + " TEXT, " +
                COLUMN_DESCRICAO_BOTANICA + " TEXT, " +
                COLUMN_NOME_CIENTIFICO + " TEXT, " +
                COLUMN_SINONIMOS + " TEXT, " +
                COLUMN_NOMES_VULGARES + " TEXT, " +
                COLUMN_ETIMOLOGIA + " TEXT, " +
                COLUMN_FORMA_BIOLOGICA + " TEXT, " +
                COLUMN_TRONCO + " TEXT, " +
                COLUMN_RAMIFICACAO + " TEXT, " +
                COLUMN_CASCA + " TEXT, " +
                COLUMN_FOLHAS + " TEXT, " +
                COLUMN_INFLORESCENCIA + " TEXT, " +
                COLUMN_FLORES + " TEXT, " +
                COLUMN_FRUTOS + " TEXT, " +
                COLUMN_SEMENTES + " TEXT, " +
                COLUMN_BIOLOGIA_REPRODUTIVA + " TEXT, " +
                COLUMN_FENOLOGIA + " TEXT, " +
                COLUMN_DISPERSAO + " TEXT, " +
                COLUMN_OCORRENCIA_NATURAL + " TEXT, " +
                COLUMN_ASPECTOS_ECOLOGICOS + " TEXT, " +
                COLUMN_REGENERACAO_NATURAL + " TEXT, " +
                COLUMN_APROVEITAMENTO_ALIMENTACAO + " TEXT, " +
                COLUMN_DADOS_NUTRICIONAIS + " TEXT, " +
                COLUMN_FORMAS_DE_CONSUMO + " TEXT, " +
                COLUMN_APROVEITAMENTO_BIOTECNOLOGICO + " TEXT, " +
                COLUMN_COMPOSICAO + " TEXT, " +
                COLUMN_USO_MEDICINAL + " TEXT, " +
                COLUMN_USO_PAISAGISTICO + " TEXT, " +
                COLUMN_USO_MADEIREIRO + " TEXT, " +
                COLUMN_USO_APICOLA + " TEXT, " +
                COLUMN_USO_INDUSTRIAL + " TEXT, " +
                COLUMN_USO_ENERGETICO + " TEXT, " +
                COLUMN_COMPOSICAO_QUIMICA + " TEXT, " +
                COLUMN_BIOATIVIDADE + " TEXT, " +
                COLUMN_POTENCIAIS_BIOPRODUTOS + " TEXT, " +
                COLUMN_TRANSPLANTE + " TEXT, " +
                COLUMN_CUIDADOS_AGUA + " TEXT, " +
                COLUMN_CUIDADOS_SOLO + " TEXT, " +
                COLUMN_PAISAGISMO + " TEXT, " +
                COLUMN_COLHEITA_BENEFICIAMENTO_SEMENTES + " TEXT, " +
                COLUMN_PRODUCAO_MUDAS + " TEXT, " +
                COLUMN_COLHEITA_BENEFICIAMENTO + " TEXT, " +
                COLUMN_SISTEMAS_AGROFLORESTAIS + " TEXT, " +
                COLUMN_CULTIVO_VIVEIROS + " TEXT, " +
                COLUMN_CARACTERISTICAS_SILVICULTURAIS + " TEXT, " +
                COLUMN_PRINCIPAIS_PRAGAS + " TEXT, " +
                COLUMN_SOLOS + " TEXT, " +
                COLUMN_LATITUDE + " TEXT, " +
                COLUMN_LONGITUDE + " TEXT, " +
                COLUMN_INSERT_DATE + " TEXT, " +
                COLUMN_UPDATE_DATE + " TEXT, " +
                COLUMN_FOTO + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // atualiza a estrutura da tabela quando a versão do banco mudar
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARVORES);
        onCreate(db);
    }

    // salva arvore no banco de dados
    public void salvarArvore(Arvore arvore) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // adiciona os valores das colunas
        values.put(COLUMN_ARVORE_ID, arvore.getArvoreID());
        values.put(COLUMN_IS_DELETED, arvore.isDeleted());
        values.put(COLUMN_NOME, arvore.getNome());
        values.put(COLUMN_FRUTIFICACAO, arvore.getFrutificacao());
        values.put(COLUMN_DESCRICAO_BOTANICA, arvore.getDescricaoBotanica());
        values.put(COLUMN_NOME_CIENTIFICO, arvore.getNomeCientifico());
        values.put(COLUMN_SINONIMOS, arvore.getSinonimos());
        values.put(COLUMN_NOMES_VULGARES, arvore.getNomesVulgares());
        values.put(COLUMN_ETIMOLOGIA, arvore.getEtimologia());
        values.put(COLUMN_FORMA_BIOLOGICA, arvore.getFormaBiologica());
        values.put(COLUMN_TRONCO, arvore.getTronco());
        values.put(COLUMN_RAMIFICACAO, arvore.getRamificacao());
        values.put(COLUMN_CASCA, arvore.getCasca());
        values.put(COLUMN_FOLHAS, arvore.getFolhas());
        values.put(COLUMN_INFLORESCENCIA, arvore.getInflorescencia());
        values.put(COLUMN_FLORES, arvore.getFlores());
        values.put(COLUMN_FRUTOS, arvore.getFrutos());
        values.put(COLUMN_SEMENTES, arvore.getSementes());
        values.put(COLUMN_BIOLOGIA_REPRODUTIVA, arvore.getBiologiaReprodutiva());
        values.put(COLUMN_FENOLOGIA, arvore.getFenologia());
        values.put(COLUMN_DISPERSAO, arvore.getDispersao());
        values.put(COLUMN_OCORRENCIA_NATURAL, arvore.getOcorrenciaNatural());
        values.put(COLUMN_ASPECTOS_ECOLOGICOS, arvore.getAspectosEcologicos());
        values.put(COLUMN_REGENERACAO_NATURAL, arvore.getRegeneracaoNatural());
        values.put(COLUMN_APROVEITAMENTO_ALIMENTACAO, arvore.getAproveitamentoAlimentacao());
        values.put(COLUMN_DADOS_NUTRICIONAIS, arvore.getDadosNutricionais());
        values.put(COLUMN_FORMAS_DE_CONSUMO, arvore.getFormasDeConsumo());
        values.put(COLUMN_APROVEITAMENTO_BIOTECNOLOGICO, arvore.getAproveitamentoBiotecnologico());
        values.put(COLUMN_COMPOSICAO, arvore.getComposicao());
        values.put(COLUMN_USO_MEDICINAL, arvore.getUsoMedicinal());
        values.put(COLUMN_USO_PAISAGISTICO, arvore.getUsoPaisagistico());
        values.put(COLUMN_USO_MADEIREIRO, arvore.getUsoMadeireiro());
        values.put(COLUMN_USO_APICOLA, arvore.getUsoApicola());
        values.put(COLUMN_USO_INDUSTRIAL, arvore.getUsoIndustrial());
        values.put(COLUMN_USO_ENERGETICO, arvore.getUsoEnergetico());
        values.put(COLUMN_COMPOSICAO_QUIMICA, arvore.getComposicaoQuimica());
        values.put(COLUMN_BIOATIVIDADE, arvore.getBioatividade());
        values.put(COLUMN_POTENCIAIS_BIOPRODUTOS, arvore.getPotenciaisBioprodutos());
        values.put(COLUMN_TRANSPLANTE, arvore.getTransplante());
        values.put(COLUMN_CUIDADOS_AGUA, arvore.getCuidadosAgua());
        values.put(COLUMN_CUIDADOS_SOLO, arvore.getCuidadosSolo());
        values.put(COLUMN_PAISAGISMO, arvore.getPaisagismo());
        values.put(COLUMN_COLHEITA_BENEFICIAMENTO_SEMENTES, arvore.getColheitaBeneficiamentoSementes());
        values.put(COLUMN_PRODUCAO_MUDAS, arvore.getProducaoMudas());
        values.put(COLUMN_COLHEITA_BENEFICIAMENTO, arvore.getColheitaBeneficiamento());
        values.put(COLUMN_SISTEMAS_AGROFLORESTAIS, arvore.getSistemasAgroflorestais());
        values.put(COLUMN_CULTIVO_VIVEIROS, arvore.getCultivoViveiros());
        values.put(COLUMN_CARACTERISTICAS_SILVICULTURAIS, arvore.getCaracteristicasSilviculturais());
        values.put(COLUMN_PRINCIPAIS_PRAGAS, arvore.getPrincipaisPragas());
        values.put(COLUMN_SOLOS, arvore.getSolos());
        values.put(COLUMN_LATITUDE, arvore.getLatitude());
        values.put(COLUMN_LONGITUDE, arvore.getLongitude());
        values.put(COLUMN_FOTO, arvore.getFoto());

        db.insert(TABLE_ARVORES, null, values);
        db.close();
    }


    @SuppressLint("Range")
    public List<Arvore> buscarTodasArvores() {
        List<Arvore> listaArvores = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_ARVORES;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Arvore arvore = new Arvore();
                arvore.setArvoreID(cursor.getString(cursor.getColumnIndex(COLUMN_ARVORE_ID)));
                arvore.setNome(cursor.getString(cursor.getColumnIndex(COLUMN_NOME)));
                arvore.setFrutificacao(cursor.getString(cursor.getColumnIndex(COLUMN_FRUTIFICACAO)));
                arvore.setDescricaoBotanica(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRICAO_BOTANICA)));
                arvore.setNomeCientifico(cursor.getString(cursor.getColumnIndex(COLUMN_NOME_CIENTIFICO)));
                arvore.setSinonimos(cursor.getString(cursor.getColumnIndex(COLUMN_SINONIMOS)));
                arvore.setNomesVulgares(cursor.getString(cursor.getColumnIndex(COLUMN_NOMES_VULGARES)));
                arvore.setEtimologia(cursor.getString(cursor.getColumnIndex(COLUMN_ETIMOLOGIA)));
                arvore.setFormaBiologica(cursor.getString(cursor.getColumnIndex(COLUMN_FORMA_BIOLOGICA)));
                arvore.setTronco(cursor.getString(cursor.getColumnIndex(COLUMN_TRONCO)));
                arvore.setRamificacao(cursor.getString(cursor.getColumnIndex(COLUMN_RAMIFICACAO)));
                arvore.setCasca(cursor.getString(cursor.getColumnIndex(COLUMN_CASCA)));
                arvore.setFolhas(cursor.getString(cursor.getColumnIndex(COLUMN_FOLHAS)));
                arvore.setInflorescencia(cursor.getString(cursor.getColumnIndex(COLUMN_INFLORESCENCIA)));
                arvore.setFlores(cursor.getString(cursor.getColumnIndex(COLUMN_FLORES)));
                arvore.setFrutos(cursor.getString(cursor.getColumnIndex(COLUMN_FRUTOS)));
                arvore.setSementes(cursor.getString(cursor.getColumnIndex(COLUMN_SEMENTES)));
                arvore.setBiologiaReprodutiva(cursor.getString(cursor.getColumnIndex(COLUMN_BIOLOGIA_REPRODUTIVA)));
                arvore.setFenologia(cursor.getString(cursor.getColumnIndex(COLUMN_FENOLOGIA)));
                arvore.setDispersao(cursor.getString(cursor.getColumnIndex(COLUMN_DISPERSAO)));
                arvore.setOcorrenciaNatural(cursor.getString(cursor.getColumnIndex(COLUMN_OCORRENCIA_NATURAL)));
                arvore.setAspectosEcologicos(cursor.getString(cursor.getColumnIndex(COLUMN_ASPECTOS_ECOLOGICOS)));
                arvore.setRegeneracaoNatural(cursor.getString(cursor.getColumnIndex(COLUMN_REGENERACAO_NATURAL)));
                arvore.setAproveitamentoAlimentacao(cursor.getString(cursor.getColumnIndex(COLUMN_APROVEITAMENTO_ALIMENTACAO)));
                arvore.setDadosNutricionais(cursor.getString(cursor.getColumnIndex(COLUMN_DADOS_NUTRICIONAIS)));
                arvore.setFormasDeConsumo(cursor.getString(cursor.getColumnIndex(COLUMN_FORMAS_DE_CONSUMO)));
                arvore.setAproveitamentoBiotecnologico(cursor.getString(cursor.getColumnIndex(COLUMN_APROVEITAMENTO_BIOTECNOLOGICO)));
                arvore.setComposicao(cursor.getString(cursor.getColumnIndex(COLUMN_COMPOSICAO)));
                arvore.setUsoMedicinal(cursor.getString(cursor.getColumnIndex(COLUMN_USO_MEDICINAL)));
                arvore.setUsoPaisagistico(cursor.getString(cursor.getColumnIndex(COLUMN_USO_PAISAGISTICO)));
                arvore.setUsoMadeireiro(cursor.getString(cursor.getColumnIndex(COLUMN_USO_MADEIREIRO)));
                arvore.setUsoApicola(cursor.getString(cursor.getColumnIndex(COLUMN_USO_APICOLA)));
                arvore.setUsoIndustrial(cursor.getString(cursor.getColumnIndex(COLUMN_USO_INDUSTRIAL)));
                arvore.setUsoEnergetico(cursor.getString(cursor.getColumnIndex(COLUMN_USO_ENERGETICO)));
                arvore.setComposicaoQuimica(cursor.getString(cursor.getColumnIndex(COLUMN_COMPOSICAO_QUIMICA)));
                arvore.setBioatividade(cursor.getString(cursor.getColumnIndex(COLUMN_BIOATIVIDADE)));
                arvore.setPotenciaisBioprodutos(cursor.getString(cursor.getColumnIndex(COLUMN_POTENCIAIS_BIOPRODUTOS)));
                arvore.setTransplante(cursor.getString(cursor.getColumnIndex(COLUMN_TRANSPLANTE)));
                arvore.setCuidadosAgua(cursor.getString(cursor.getColumnIndex(COLUMN_CUIDADOS_AGUA)));
                arvore.setCuidadosSolo(cursor.getString(cursor.getColumnIndex(COLUMN_CUIDADOS_SOLO)));
                arvore.setPaisagismo(cursor.getString(cursor.getColumnIndex(COLUMN_PAISAGISMO)));
                arvore.setColheitaBeneficiamentoSementes(cursor.getString(cursor.getColumnIndex(COLUMN_COLHEITA_BENEFICIAMENTO_SEMENTES)));
                arvore.setProducaoMudas(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUCAO_MUDAS)));
                arvore.setColheitaBeneficiamento(cursor.getString(cursor.getColumnIndex(COLUMN_COLHEITA_BENEFICIAMENTO)));
                arvore.setSistemasAgroflorestais(cursor.getString(cursor.getColumnIndex(COLUMN_SISTEMAS_AGROFLORESTAIS)));
                arvore.setCultivoViveiros(cursor.getString(cursor.getColumnIndex(COLUMN_CULTIVO_VIVEIROS)));
                arvore.setCaracteristicasSilviculturais(cursor.getString(cursor.getColumnIndex(COLUMN_CARACTERISTICAS_SILVICULTURAIS)));
                arvore.setPrincipaisPragas(cursor.getString(cursor.getColumnIndex(COLUMN_PRINCIPAIS_PRAGAS)));
                arvore.setSolos(cursor.getString(cursor.getColumnIndex(COLUMN_SOLOS)));
                arvore.setLatitude(cursor.getString(cursor.getColumnIndex(COLUMN_LATITUDE)));
                arvore.setLongitude(cursor.getString(cursor.getColumnIndex(COLUMN_LONGITUDE)));
                arvore.setFoto(cursor.getString(cursor.getColumnIndex(COLUMN_FOTO)));

                listaArvores.add(arvore);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listaArvores;
    }
}
