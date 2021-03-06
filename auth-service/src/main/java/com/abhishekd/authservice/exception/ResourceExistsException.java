package com.abhishekd.authservice.exception;

/**
 * ResourceExistsException class
 */
public class ResourceExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceExistsException(String resourceName) {
        super("Resource with resourceName={" + resourceName + "} already exists");
    }
}
