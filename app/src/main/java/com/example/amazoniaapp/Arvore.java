package com.example.amazoniaapp;

import com.google.gson.annotations.SerializedName;

public class Arvore {
    @SerializedName("arvoreID")
    private String arvoreID;

    @SerializedName("isDeleted")
    private boolean isDeleted;

    @SerializedName("nome")
    private String nome;

    @SerializedName("frutificacao")
    private String frutificacao;

    @SerializedName("descricaoBotanica")
    private String descricaoBotanica;

    @SerializedName("nomeCientifico")
    private String nomeCientifico;

    @SerializedName("sinonimos")
    private String sinonimos;

    @SerializedName("nomesVulgares")
    private String nomesVulgares;

    @SerializedName("etimologia")
    private String etimologia;

    @SerializedName("formaBiologica")
    private String formaBiologica;

    @SerializedName("tronco")
    private String tronco;

    @SerializedName("ramificacao")
    private String ramificacao;

    @SerializedName("casca")
    private String casca;

    @SerializedName("folhas")
    private String folhas;

    @SerializedName("inflorescencia")
    private String inflorescencia;

    @SerializedName("flores")
    private String flores;

    @SerializedName("frutos")
    private String frutos;

    @SerializedName("sementes")
    private String sementes;

    @SerializedName("biologiaReprodutiva")
    private String biologiaReprodutiva;

    @SerializedName("fenologia")
    private String fenologia;

    @SerializedName("dispersao")
    private String dispersao;

    @SerializedName("ocorrenciaNatural")
    private String ocorrenciaNatural;

    @SerializedName("aspectosEcologicos")
    private String aspectosEcologicos;

    @SerializedName("regeneracaoNatural")
    private String regeneracaoNatural;

    @SerializedName("aproveitamentoAlimentacao")
    private String aproveitamentoAlimentacao;

    @SerializedName("dadosNutricionais")
    private String dadosNutricionais;

    @SerializedName("formasDeConsumo")
    private String formasDeConsumo;

    @SerializedName("aproveitamentoBiotecnologico")
    private String aproveitamentoBiotecnologico;

    @SerializedName("composicao")
    private String composicao;

    @SerializedName("usoMedicinal")
    private String usoMedicinal;

    @SerializedName("usoPaisagistico")
    private String usoPaisagistico;

    @SerializedName("usoMadeireiro")
    private String usoMadeireiro;

    @SerializedName("usoApicola")
    private String usoApicola;

    @SerializedName("usoIndustrial")
    private String usoIndustrial;

    @SerializedName("usoEnergetico")
    private String usoEnergetico;

    @SerializedName("composicaoQuimica")
    private String composicaoQuimica;

    @SerializedName("bioatividade")
    private String bioatividade;

    @SerializedName("potenciaisBioprodutos")
    private String potenciaisBioprodutos;

    @SerializedName("transplante")
    private String transplante;

    @SerializedName("cuidadosAgua")
    private String cuidadosAgua;

    @SerializedName("cuidadosSolo")
    private String cuidadosSolo;

    @SerializedName("paisagismo")
    private String paisagismo;

    @SerializedName("colheitaBeneficiamentoSementes")
    private String colheitaBeneficiamentoSementes;

    @SerializedName("producaoMudas")
    private String producaoMudas;

    @SerializedName("colheitaBeneficiamento")
    private String colheitaBeneficiamento;

    @SerializedName("sistemasAgroflorestais")
    private String sistemasAgroflorestais;

    @SerializedName("cultivoViveiros")
    private String cultivoViveiros;

    @SerializedName("caracteristicasSilviculturais")
    private String caracteristicasSilviculturais;

    @SerializedName("principaisPragas")
    private String principaisPragas;

    @SerializedName("solos")
    private String solos;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("foto")
    private String foto;


    public String getFrutificacao() {
        return frutificacao;
    }

    public void setFrutificacao(String frutificacao) {
        this.frutificacao = frutificacao;
    }

    public String getAproveitamentoAlimentacao() {
        return aproveitamentoAlimentacao;
    }

    public void setAproveitamentoAlimentacao(String aproveitamentoAlimentacao) {
        this.aproveitamentoAlimentacao = aproveitamentoAlimentacao;
    }

    public String getAproveitamentoBiotecnologico() {
        return aproveitamentoBiotecnologico;
    }

    public void setAproveitamentoBiotecnologico(String aproveitamentoBiotecnologico) {
        this.aproveitamentoBiotecnologico = aproveitamentoBiotecnologico;
    }

    public String getArvoreID() {
        return arvoreID;
    }

    public void setArvoreID(String arvoreID) {
        this.arvoreID = arvoreID;
    }

    public String getAspectosEcologicos() {
        return aspectosEcologicos;
    }

    public void setAspectosEcologicos(String aspectosEcologicos) {
        this.aspectosEcologicos = aspectosEcologicos;
    }

    public String getBioatividade() {
        return bioatividade;
    }

    public void setBioatividade(String bioatividade) {
        this.bioatividade = bioatividade;
    }

    public String getBiologiaReprodutiva() {
        return biologiaReprodutiva;
    }

    public void setBiologiaReprodutiva(String biologiaReprodutiva) {
        this.biologiaReprodutiva = biologiaReprodutiva;
    }

    public String getCaracteristicasSilviculturais() {
        return caracteristicasSilviculturais;
    }

    public void setCaracteristicasSilviculturais(String caracteristicasSilviculturais) {
        this.caracteristicasSilviculturais = caracteristicasSilviculturais;
    }

    public String getCasca() {
        return casca;
    }

    public void setCasca(String casca) {
        this.casca = casca;
    }

    public String getColheitaBeneficiamento() {
        return colheitaBeneficiamento;
    }

    public void setColheitaBeneficiamento(String colheitaBeneficiamento) {
        this.colheitaBeneficiamento = colheitaBeneficiamento;
    }

    public String getColheitaBeneficiamentoSementes() {
        return colheitaBeneficiamentoSementes;
    }

    public void setColheitaBeneficiamentoSementes(String colheitaBeneficiamentoSementes) {
        this.colheitaBeneficiamentoSementes = colheitaBeneficiamentoSementes;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public String getComposicaoQuimica() {
        return composicaoQuimica;
    }

    public void setComposicaoQuimica(String composicaoQuimica) {
        this.composicaoQuimica = composicaoQuimica;
    }

    public String getCuidadosAgua() {
        return cuidadosAgua;
    }

    public void setCuidadosAgua(String cuidadosAgua) {
        this.cuidadosAgua = cuidadosAgua;
    }

    public String getCuidadosSolo() {
        return cuidadosSolo;
    }

    public void setCuidadosSolo(String cuidadosSolo) {
        this.cuidadosSolo = cuidadosSolo;
    }

    public String getCultivoViveiros() {
        return cultivoViveiros;
    }

    public void setCultivoViveiros(String cultivoViveiros) {
        this.cultivoViveiros = cultivoViveiros;
    }

    public String getDadosNutricionais() {
        return dadosNutricionais;
    }

    public void setDadosNutricionais(String dadosNutricionais) {
        this.dadosNutricionais = dadosNutricionais;
    }

    public String getDescricaoBotanica() {
        return descricaoBotanica;
    }

    public void setDescricaoBotanica(String descricaoBotanica) {
        this.descricaoBotanica = descricaoBotanica;
    }

    public String getDispersao() {
        return dispersao;
    }

    public void setDispersao(String dispersao) {
        this.dispersao = dispersao;
    }

    public String getEtimologia() {
        return etimologia;
    }

    public void setEtimologia(String etimologia) {
        this.etimologia = etimologia;
    }

    public String getFenologia() {
        return fenologia;
    }

    public void setFenologia(String fenologia) {
        this.fenologia = fenologia;
    }

    public String getFlores() {
        return flores;
    }

    public void setFlores(String flores) {
        this.flores = flores;
    }

    public String getFolhas() {
        return folhas;
    }

    public void setFolhas(String folhas) {
        this.folhas = folhas;
    }

    public String getFormaBiologica() {
        return formaBiologica;
    }

    public void setFormaBiologica(String formaBiologica) {
        this.formaBiologica = formaBiologica;
    }

    public String getFormasDeConsumo() {
        return formasDeConsumo;
    }

    public void setFormasDeConsumo(String formasDeConsumo) {
        this.formasDeConsumo = formasDeConsumo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFrutos() {
        return frutos;
    }

    public void setFrutos(String frutos) {
        this.frutos = frutos;
    }

    public String getInflorescencia() {
        return inflorescencia;
    }

    public void setInflorescencia(String inflorescencia) {
        this.inflorescencia = inflorescencia;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getNomesVulgares() {
        return nomesVulgares;
    }

    public void setNomesVulgares(String nomesVulgares) {
        this.nomesVulgares = nomesVulgares;
    }

    public String getOcorrenciaNatural() {
        return ocorrenciaNatural;
    }

    public void setOcorrenciaNatural(String ocorrenciaNatural) {
        this.ocorrenciaNatural = ocorrenciaNatural;
    }

    public String getPaisagismo() {
        return paisagismo;
    }

    public void setPaisagismo(String paisagismo) {
        this.paisagismo = paisagismo;
    }

    public String getPotenciaisBioprodutos() {
        return potenciaisBioprodutos;
    }

    public void setPotenciaisBioprodutos(String potenciaisBioprodutos) {
        this.potenciaisBioprodutos = potenciaisBioprodutos;
    }

    public String getPrincipaisPragas() {
        return principaisPragas;
    }

    public void setPrincipaisPragas(String principaisPragas) {
        this.principaisPragas = principaisPragas;
    }

    public String getProducaoMudas() {
        return producaoMudas;
    }

    public void setProducaoMudas(String producaoMudas) {
        this.producaoMudas = producaoMudas;
    }

    public String getRamificacao() {
        return ramificacao;
    }

    public void setRamificacao(String ramificacao) {
        this.ramificacao = ramificacao;
    }

    public String getRegeneracaoNatural() {
        return regeneracaoNatural;
    }

    public void setRegeneracaoNatural(String regeneracaoNatural) {
        this.regeneracaoNatural = regeneracaoNatural;
    }

    public String getSementes() {
        return sementes;
    }

    public void setSementes(String sementes) {
        this.sementes = sementes;
    }

    public String getSinonimos() {
        return sinonimos;
    }

    public void setSinonimos(String sinonimos) {
        this.sinonimos = sinonimos;
    }

    public String getSistemasAgroflorestais() {
        return sistemasAgroflorestais;
    }

    public void setSistemasAgroflorestais(String sistemasAgroflorestais) {
        this.sistemasAgroflorestais = sistemasAgroflorestais;
    }

    public String getSolos() {
        return solos;
    }

    public void setSolos(String solos) {
        this.solos = solos;
    }

    public String getTransplante() {
        return transplante;
    }

    public void setTransplante(String transplante) {
        this.transplante = transplante;
    }

    public String getTronco() {
        return tronco;
    }

    public void setTronco(String tronco) {
        this.tronco = tronco;
    }

    public String getUsoApicola() {
        return usoApicola;
    }

    public void setUsoApicola(String usoApicola) {
        this.usoApicola = usoApicola;
    }

    public String getUsoEnergetico() {
        return usoEnergetico;
    }

    public void setUsoEnergetico(String usoEnergetico) {
        this.usoEnergetico = usoEnergetico;
    }

    public String getUsoIndustrial() {
        return usoIndustrial;
    }

    public void setUsoIndustrial(String usoIndustrial) {
        this.usoIndustrial = usoIndustrial;
    }

    public String getUsoMadeireiro() {
        return usoMadeireiro;
    }

    public void setUsoMadeireiro(String usoMadeireiro) {
        this.usoMadeireiro = usoMadeireiro;
    }

    public String getUsoMedicinal() {
        return usoMedicinal;
    }

    public void setUsoMedicinal(String usoMedicinal) {
        this.usoMedicinal = usoMedicinal;
    }

    public String getUsoPaisagistico() {
        return usoPaisagistico;
    }

    public void setUsoPaisagistico(String usoPaisagistico) {
        this.usoPaisagistico = usoPaisagistico;
    }
}