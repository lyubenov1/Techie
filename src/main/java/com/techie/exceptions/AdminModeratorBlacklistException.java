package com.techie.exceptions;

public class AdminModeratorBlacklistException extends RuntimeException {
    public AdminModeratorBlacklistException() {
        super("Admins and moderators cannot be blacklisted!");
    }
}
