package com.techie.exceptions.role;

public class AdminModeratorBlacklistException extends RuntimeException {
    public AdminModeratorBlacklistException() {
        super("Admins and moderators cannot be blacklisted!");
    }
}
