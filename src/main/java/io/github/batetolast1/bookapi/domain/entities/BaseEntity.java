package io.github.batetolast1.bookapi.domain.entities;

public class BaseEntity {

    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
