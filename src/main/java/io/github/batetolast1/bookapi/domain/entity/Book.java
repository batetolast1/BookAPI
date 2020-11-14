package io.github.batetolast1.bookapi.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
@Data
@EqualsAndHashCode(callSuper = true, of = {})
public class Book extends BaseEntity {

    @NotBlank
    private String isbn;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String publisher;

    @NotBlank
    private String type;
}
