package com.ys.sec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * redis配置类，使用redis + token方式认证时启用
 */
public class RedisConfig {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    TokenStore redisTokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }
}
