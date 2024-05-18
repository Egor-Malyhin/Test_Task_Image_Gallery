package org.mycorp.repository;

import org.mycorp.models.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends BaseEntity> {
    void saveEntity(T entity);

    Optional<T> getEntity(Long id);

    List<T> getAllEntities();

    boolean deleteEntity(Long entityId);
}
