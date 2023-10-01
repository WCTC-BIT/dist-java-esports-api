package edu.wctc.distjavaesportsapi.exception;

import jakarta.annotation.Resource;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceType, int id) {
        super(String.format("%s not found with ID %d", resourceType, id));
    }
}
