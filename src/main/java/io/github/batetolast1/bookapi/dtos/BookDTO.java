package io.github.batetolast1.bookapi.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.NotBlank;

@Data
public class BookDTO {

    private Long id;

    @ISBN
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
