package com.fgcalarm.model.persistence.repositories.types;

import com.fgcalarm.model.entities.base.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Biel on 24/11/2016.
 */

public interface CrudRepository<T extends Entity<ID>, ID extends Serializable> extends Repository<T, ID> {
    <S extends T> S save(S entity);
    T findOne(ID primaryKey);
    List<T> findAll();
    Long count();
    void delete(T entity);
    boolean exists(ID primaryKey);
}
