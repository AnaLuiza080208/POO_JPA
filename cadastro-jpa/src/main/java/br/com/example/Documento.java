package br.com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Documento {

    @Id
    @GeneratedValue()
    private int id;
    private String tipo;
    private String emissor;
    
    public Documento() {
    }

    public Documento(int id, String tipo, String emissor) {
        this.id = id;
        this.tipo = tipo;
        this.emissor = emissor;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEmissor() {
        return emissor;
    }
    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }
    
}
