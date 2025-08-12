package br.com.example;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "projetos")
    private Set<Pessoa> pessoas;

    public Projeto() {
    }

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

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }
   
    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
