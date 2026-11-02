package org.integracao;

public class ConfiguracaoCafeteria {

    private ConfiguracaoCafeteria() {};
    private static ConfiguracaoCafeteria instance = new ConfiguracaoCafeteria();
    private String nomeLoja;

    public static ConfiguracaoCafeteria getInstance() {
        return instance;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }
}