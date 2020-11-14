package io.github.batetolast1.bookapi.domain.entity;

import io.github.batetolast1.bookapi.domain.entity.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {

    private ResponseStatus responseStatus;
    private T payload;
}
