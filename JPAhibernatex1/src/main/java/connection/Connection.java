package connection;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection { 
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancojpahibernate1");

    public EntityManager getConnection(){
        return emf.createEntityManager();
    }
}