package org.mycorp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.mycorp.models.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class RepositoryImpl<T extends BaseEntity> implements Repository<T> {
    @Autowired
    protected JinqJPAStreamProvider jinqDataProvider;
    @PersistenceContext
    private EntityManager entityManager;

    protected abstract Class<T> entityType();

    @Override
    public void saveEntity(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public Optional<T> getEntity(long id) {
        return stream().
                where(c -> c.getId() == id).
                findFirst();
    }

    @Override
    public List<T> getAllEntities() {
        return stream().toList();
    }

    @Override
    public boolean deleteEntity(long entityId) {
        Optional<T> findEntity = getEntity(entityId);
        if (getEntity(entityId).isEmpty())
            return false;
        entityManager.remove(findEntity.get());
        return true;
    }

    protected JPAJinqStream<T> stream() {
        return jinqDataProvider.streamAll(entityManager, entityType());
    }
}
