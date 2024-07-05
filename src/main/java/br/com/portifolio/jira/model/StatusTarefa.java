package br.com.portifolio.jira.model;

public enum StatusTarefa {

    BACKLOG(1, "BACKLOG"),
    DESENVOLVIMENTO(2, "DESENVOLVIMENTO"),
    FINALIZADO(3, "FINALIZADO");

    private final int codigo;
    private final String descricao;

    StatusTarefa(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
