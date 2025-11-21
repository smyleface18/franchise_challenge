package com.franquicias.franquify.domain.exception;


public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entityName, String id) {
        super(entityName + " not found with id: " + id);
    }

    public EntityNotFoundException(String entityName, String fieldName, String fieldValue) {
        super(entityName + " not found with " + fieldName + ": " + fieldValue);
    }
}