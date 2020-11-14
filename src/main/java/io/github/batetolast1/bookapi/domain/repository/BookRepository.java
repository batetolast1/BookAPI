package io.github.batetolast1.bookapi.domain.repository;

import io.github.batetolast1.bookapi.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
