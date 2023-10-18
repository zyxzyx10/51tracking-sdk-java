package com.tracking51.model;

import lombok.Data;

@Data
public class Tracking51Response<T>  {

    private Meta meta;
    private T data;

    public Tracking51Response() {}

    public Tracking51Response(T data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }
}
