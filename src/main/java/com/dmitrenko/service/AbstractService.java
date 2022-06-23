package com.dmitrenko.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<T, ID> {
    protected abstract JpaRepository<T, ID> getRepository();

    public List<T> getAll() {
        return getRepository().findAll();
    }

    public T getById(ID id) {
        return getRepository().findById(id)
                .orElse(null);
    }

    public T create(T object) {
        return getRepository().save(object);
    }

    public T update(ID id, T object) {
        object = getRepository().getById(id);
        if (object != null) {
            return getRepository().save(object);
        } else {
            return null;
        }
    }

    public T delete(ID id) {
        T object = getRepository().getById(id);
        if (object != null) {
            getRepository().deleteById(id);
            return object;
        }
        return null;
    }
}
