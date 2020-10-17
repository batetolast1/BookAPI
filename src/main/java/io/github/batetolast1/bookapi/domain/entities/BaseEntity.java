package io.github.batetolast1.bookapi.domain.entities;

import java.time.LocalDateTime;

public class BaseEntity {

    private Long id;
    private LocalDateTime createdOn;

    public BaseEntity(Long id) {
        this.id = id;
        createdOn = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
