package br.com.mongo.MongoProject.entity;

public class Curso {

    private String nome;

    public String getNome() {
        return nome;
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
