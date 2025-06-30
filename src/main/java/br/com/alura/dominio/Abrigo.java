package br.com.alura.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class Abrigo {

    public Abrigo(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Pet[] pets;

}
