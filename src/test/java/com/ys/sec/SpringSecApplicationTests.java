package com.ys.sec;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@SpringBootTest
class SpringSecApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void password(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String password = encoder.encode("123456");
        System.out.println(password);

        boolean matcher = encoder.matches("123456", password);
        System.out.println(matcher);

        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String key = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(key);
    }

}
