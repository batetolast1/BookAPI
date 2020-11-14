package io.github.batetolast1.bookapi.dtos;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;
}
