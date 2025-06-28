package br.com.alura.dominio;

public class Pet {

    public Pet(long id, String tipo,String nome, String raca, int idade,String cor, Float peso){
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.cor = cor;
        this.peso = peso;
    }

    private long id;
    private String tipo;
    private String nome;
    private String raca;
    private int idade;
    private String cor;
    private Float peso;

    public String toString(){
        return String.format("%s - %s - %s - %s",id,tipo,nome,raca);
    }
}
