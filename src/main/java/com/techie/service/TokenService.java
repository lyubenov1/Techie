package com.techie.service;

import org.springframework.stereotype.*;

import java.util.*;
import java.util.concurrent.*;


/**
 * This class provides functionality to create, retrieve, and remove tokens
 * used for user authentication or other purposes. Tokens are stored in a
 * thread-safe map, with each token associated with a specific username.
 * Key methods:
 * - {@link #createToken(String)}: Generates a new token for a given username
 *   and stores it.
 */
@Service
public class TokenService {

    private final Map<String, String> tokenStorage = new ConcurrentHashMap<>();

    public String createToken(String username) {
        String token = UUID.randomUUID().toString();
        tokenStorage.put(token, username);
        return token;
    }

    public String getUsernameByToken(String token) {
        return tokenStorage.get(token);
    }

    public void removeToken(String token) {
        tokenStorage.remove(token);
    }
}