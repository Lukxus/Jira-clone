package br.com.portifolio.jira.usuarios.entidades;

public enum RolesEnum {

    ADMIN(1, "Administrator"),
    USER(2, "Standard User");

    private final int id;
    private final String description;

    RolesEnum(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "RolesEnum{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
