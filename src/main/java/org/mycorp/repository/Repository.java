package org.mycorp.repository;

import org.mycorp.models.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends BaseEntity> {
    void saveEntity(T entity);

    List<T> getAllEntities();

    void deleteEntity(Long entityId);
}
