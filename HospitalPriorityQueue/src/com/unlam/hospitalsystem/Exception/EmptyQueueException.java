package com.unlam.hospitalsystem.Exception;

public class EmptyQueueException extends Exception {
    private String msg;
    public EmptyQueueException(String msg) {
        super(msg);
    }
}
