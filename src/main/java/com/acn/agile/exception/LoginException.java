package com.acn.agile.exception;

public class LoginException extends Exception {
    public LoginException() {
        super("Invalid user name or password");
    }
}
