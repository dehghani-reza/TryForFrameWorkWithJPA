package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ir.shividpolo");
    private  static EntityManager entityManager;

    private JPAUtil(){}

    public static EntityManager getEntityManager(){
        if (entityManager==null){
            entityManager = entityManagerFactory.createEntityManager() ;
        }
        return entityManager;
    }
}
