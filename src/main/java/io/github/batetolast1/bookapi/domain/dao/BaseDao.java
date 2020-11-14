package io.github.batetolast1.bookapi.domain.dao;

import io.github.batetolast1.bookapi.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BaseDao<T, ID> {

    List<T> findAll();

    T save(T t);

    Optional<T> getById(ID id);

    Book edit(T t);

    boolean deleteById(ID id);
}
