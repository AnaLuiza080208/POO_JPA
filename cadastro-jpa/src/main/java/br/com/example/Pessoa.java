package br.com.example;

import jakarta.persistence.*;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue()

    private Long id;
    private String nome;

    @OneToOne
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private Documento documento;

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Pessoa(){
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

}
