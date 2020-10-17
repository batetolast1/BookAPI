package io.github.batetolast1.bookapi.domain.repositories;

import io.github.batetolast1.bookapi.domain.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, ID> {

    List<T> findAll();

    T save(T t);

    Optional<T> getById(ID id);

    Book edit(T t);

    boolean deleteById(ID id);
}
