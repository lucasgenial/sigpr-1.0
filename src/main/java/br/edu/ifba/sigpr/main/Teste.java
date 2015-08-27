package br.edu.ifba.sigpr.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

    public static void main(String[] args) {
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("sigpr");
        EntityManager administracao = fabrica.createEntityManager();
        
        administracao.close();
        fabrica.close();
    }
}
