package ch.gobothegeek.database;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.TransactionScoped;
import java.io.Serializable;

@ApplicationScoped
public class GtgEntityManagerProducer implements Serializable {
    @PersistenceUnit(name = "SkelUnit") private EntityManagerFactory entityManagerFactory;

    @Produces
    @TransactionScoped
    public EntityManager create() {
        return this.entityManagerFactory.createEntityManager();
    }

    public void close(@Disposes EntityManager em)
    {
        if (em.isOpen()) { em.close(); }
    }

    public EntityManagerFactory getEntityManagerFactory() { return entityManagerFactory; }
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) { this.entityManagerFactory = entityManagerFactory; }
}
