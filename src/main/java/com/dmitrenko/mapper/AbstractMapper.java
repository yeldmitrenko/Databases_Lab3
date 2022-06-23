package com.dmitrenko.mapper;

public abstract class AbstractMapper<T, DTO> {
    public abstract DTO mapObjectToDTO(T object);
}
