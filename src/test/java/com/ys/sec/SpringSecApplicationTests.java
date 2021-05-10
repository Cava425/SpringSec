package com.ys.sec;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    }

}
