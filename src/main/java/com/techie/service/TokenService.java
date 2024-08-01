package com.techie.service;

import org.springframework.stereotype.*;

import java.time.*;
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

    private static final long TOKEN_EXPIRATION_MINUTES = 30;
    private final Map<String, TokenInfo> tokenStorage = new ConcurrentHashMap<>();

    public String createToken(String email) {
        String token = UUID.randomUUID().toString();
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(TOKEN_EXPIRATION_MINUTES);
        tokenStorage.put(token, new TokenInfo(email, expirationTime));
        return token;
    }

    public String getEmailByToken(String token) {
        TokenInfo tokenInfo = tokenStorage.get(token);
        if (tokenInfo == null || tokenInfo.isExpired()) {
            tokenStorage.remove(token); // Clean up expired token
            return null;
        }
        return tokenInfo.email();
    }

    public void removeToken(String token) {
        tokenStorage.remove(token);
    }

    private record TokenInfo(String email, LocalDateTime expirationTime) {

        boolean isExpired() {
                return LocalDateTime.now().isAfter(expirationTime);
            }
        }
}