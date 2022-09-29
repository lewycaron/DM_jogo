package br.com.up.garrafa.Model;

public class RoletaModel {
    private String premiacao;

    public RoletaModel(String premiacao){
        this.premiacao = premiacao;
    }
    public String getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(String premiacao) {
        this.premiacao = premiacao;
    }
}
