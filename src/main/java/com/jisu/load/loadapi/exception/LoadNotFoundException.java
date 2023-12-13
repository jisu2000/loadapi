package com.jisu.load.loadapi.exception;

public class LoadNotFoundException extends RuntimeException {

    public LoadNotFoundException(String s) {
        super(s);
    }

    public LoadNotFoundException() {
        super("Requested Resourse not found!!");
    }

}
