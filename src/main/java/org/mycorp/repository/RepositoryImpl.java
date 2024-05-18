package org.mycorp.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.mycorp.models.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public abstract class RepositoryImpl<T extends BaseEntity> implements Repository<T> {
    @Autowired
    protected JinqJPAStreamProvider jinqDataProvider;
    @PersistenceContext
    private EntityManager entityManager;

    protected abstract Class<T> entityType();

    @Override
    @Transactional
    public void saveEntity(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public Optional<T> getEntity(Long id) {
        return stream().where((T entity) -> entity.getId().equals(id)).findOne();
    };

    @Override
    public List<T> getAllEntities() {
        return stream().toList();
    }

    @Override
    @Transactional
    public boolean deleteEntity(Long entityId) {
        entityManager.remove(getEntity(entityId).get());
        return true;
    }

    protected JPAJinqStream<T> stream() {
        return jinqDataProvider.streamAll(entityManager, entityType());
    }
}
