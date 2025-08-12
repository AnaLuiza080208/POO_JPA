package br.com.example;

import jakarta.persistence.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();

        Documento doc = new Documento();
        doc.setTipo("RG");
        doc.setEmissor("emissor");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ana");
        pessoa.setDocumento(doc);

        Telefone tel1 = new Telefone();
        tel1.setNumero("11111111");
        tel1.setPessoa(pessoa);

        Telefone tel2 = new Telefone();
        tel2.setNumero("22222222");
        tel2.setPessoa(pessoa);
   
        pessoa.setTelefones(new ArrayList<>());
        pessoa.getTelefones().add(tel1);
        pessoa.getTelefones().add(tel2);

        Projeto proj1 = new Projeto();
        proj1.setNome("Projeto A");

        Projeto proj2 = new Projeto();
        proj2.setNome("Projeto B");

        pessoa.setProjetos(new HashSet<>());
        pessoa.getProjetos().add(proj1);
        pessoa.getProjetos().add(proj2);

        proj1.setPessoas(new HashSet<>());
        proj2.setPessoas(new HashSet<>());
        proj1.getPessoas().add(pessoa);
        proj2.getPessoas().add(pessoa);

        em.getTransaction().begin();

        em.persist(proj1);
        em.persist(proj2);
        em.persist(pessoa);

        em.getTransaction().commit();

        List<Pessoa> pessoas = em.createQuery("FROM Pessoa", Pessoa.class).getResultList();

        for (Pessoa p : pessoas) {
            System.out.println("Pessoa: " + p.getNome());
            System.out.println("Documento: Emissor = " + p.getDocumento().getEmissor() + ", Tipo = " + p.getDocumento().getTipo());
        
            System.out.println("Telefones:");
            for (Telefone t : p.getTelefones()) {
                System.out.println("  - " + t.getNumero());
            }
        
            System.out.println("Projetos:");
            for (Projeto proj : p.getProjetos()) {
                System.out.println("  - " + proj.getNome());
            }
        
            System.out.println("--------------------");
        }

        em.close();
        emf.close();

        System.out.println("Dados persistidos com sucesso!");
    }
}
