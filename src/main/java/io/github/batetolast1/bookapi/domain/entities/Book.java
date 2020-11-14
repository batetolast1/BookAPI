package io.github.batetolast1.bookapi.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "books")
@Data
@EqualsAndHashCode(callSuper = true, of = {})
public class Book extends BaseEntity {

    @NotNull
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;
}
