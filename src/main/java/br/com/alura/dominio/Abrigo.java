package br.com.alura.dominio;

public class Abrigo {

    public Abrigo(long id, String nome,String telefone,String email, Pet[] pets){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.pets = pets;
    }

    public Abrigo(String nome,String telefone,String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Pet[] pets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
