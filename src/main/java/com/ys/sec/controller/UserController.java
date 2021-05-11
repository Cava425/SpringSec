package com.ys.sec.controller;


import com.ys.sec.entity.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ysx
 * @since 2021-05-10
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public Result user(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        String token = authorization.replace("Bearer ", "");
        Claims claims = Jwts.parserBuilder()
                .setSigningKey("VUdS3H+RaFo5Gj3LeIvgvCJxWQnsGdEJ63UcrH+joyM=".getBytes(StandardCharsets.UTF_8))
                .build()
                .parseClaimsJws(token)
                .getBody();
        return Result.success(claims);
    }
}
