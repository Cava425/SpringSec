package com.ys.sec.config;

import com.ys.sec.entity.CustomTokenEnhancer;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.crypto.SecretKey;
import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;


    @Bean
    TokenEnhancer tokenEnhancer(){
        return new CustomTokenEnhancer();
    }

    /**
     * 密码模式中的授权服务器端点
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        // 增强body中的内容
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        // 传入一个包含tokenEnhancer和accessTokenConverter的列表
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter));

        endpoints
                // 自定义登录逻辑
                .userDetailsService(userDetailsService)
                // 授权管理器
                .authenticationManager(authenticationManager)
                // 令牌存储位置
                .tokenStore(tokenStore())
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(tokenEnhancerChain);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                // client id
                .withClient("admin")
                // client password
                .secret(encoder.encode("123456"))
                .redirectUris("http://localhost:8080/oauth/authorized/code")
                //
                .scopes("all")
                .authorizedGrantTypes("authorization_code", "password");
    }


    @Bean
    TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // 生成长度为256bit的签名密钥
        // SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        // String key = Encoders.BASE64.encode(secretKey.getEncoded());
        converter.setSigningKey("VUdS3H+RaFo5Gj3LeIvgvCJxWQnsGdEJ63UcrH+joyM=");
        return converter;
    }
}
