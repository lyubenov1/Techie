package com.techie.config;

import com.github.benmanes.caffeine.cache.*;
import org.springframework.cache.*;
import org.springframework.cache.caffeine.*;
import org.springframework.context.annotation.*;

import java.util.concurrent.*;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManagerCategories() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("categories");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(500)
                .expireAfterAccess(20, TimeUnit.MINUTES)
                .recordStats());
        return cacheManager;
    }

    @Bean
    public CacheManager cacheManagerProducts() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("products");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(500)
                .expireAfterAccess(20, TimeUnit.MINUTES)
                .recordStats());
        return cacheManager;
    }

}