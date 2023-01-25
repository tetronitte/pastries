package com.example.pastries_jee.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    Optional<T> get(Long id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}
