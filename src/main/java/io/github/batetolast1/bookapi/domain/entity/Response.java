package io.github.batetolast1.bookapi.domain.entity;

import io.github.batetolast1.bookapi.domain.entity.enums.Status;

public class Response<T> {

    private Status status;
    private T payload;

    public Response(Status status, T payload) {
        this.status = status;
        this.payload = payload;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
