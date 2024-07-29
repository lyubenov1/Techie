package com.techie.config;

import com.github.benmanes.caffeine.cache.*;
import org.springframework.cache.*;
import org.springframework.cache.caffeine.*;
import org.springframework.context.annotation.*;

import java.util.concurrent.*;

@Configuration
public class CacheConfig {

    @Bean
    @Primary
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(500)
                .expireAfterAccess(20, TimeUnit.MINUTES)
                .recordStats());
        return cacheManager;
    }

    @Bean
    public CacheManager cacheManagerBlacklist() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("userBlacklist");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.HOURS)
                .maximumSize(1000));
        return cacheManager;
    }

    @Bean
    public CacheManager cacheManagerCart() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("shoppingCart");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(50)
                .maximumSize(200)
                .expireAfterWrite(3, TimeUnit.DAYS)
                .recordStats());
        return cacheManager;
    }

}