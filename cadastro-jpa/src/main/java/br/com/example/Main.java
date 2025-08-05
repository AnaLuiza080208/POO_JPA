package br.com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa();
        p1.setNome("Ana");

        // Cria o EntityManagerFactory com base na unidade de persistência 'meuPU'
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();

        // Inicia a transação
        em.getTransaction().begin();

        // Persiste o objeto no banco de dados
        em.persist(p1);

        // Finaliza a transação
        em.getTransaction().commit();

        // Fecha o EntityManager e o EntityManagerFactory
        em.close();
        emf.close();

        System.out.println("Pessoa salva com sucesso!");
    }
}
