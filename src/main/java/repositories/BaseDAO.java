package repositories;


import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class BaseDAO<Entity,ID extends Number> {

    protected abstract Class<Entity> getEntityClass();

    EntityManager entityManager = JPAUtil.getEntityManager();

    public Entity save(Entity entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public Entity loadById(ID id){
        entityManager.getTransaction().begin();
        Entity entity = entityManager.find(getEntityClass(), id);
        entityManager.getTransaction().commit();
        return entity;
    }

    public List<Entity> loadAll(){
        entityManager.getTransaction().begin();
        TypedQuery<Entity> query = entityManager.createQuery("select entity from " + getEntityClass().getName()+" entity", getEntityClass());
        List<Entity> resultList = query.getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

    public Entity update(Entity entity){
        entityManager.getTransaction().begin();
        Entity merge = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return merge;
    }

    public void delete(Entity entity){
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public void deleteById(ID id) throws Exception {
        Entity entity = loadById(id);
        if(entity==null){
            throw new Exception("Entity with class name: "+
                    getEntityClass().getSimpleName()+
                    " and id: "+id+" not exist");
        }
        delete(entity);
    }

}
