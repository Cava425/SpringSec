package com.ys.sec.controller;

import com.ys.sec.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/oauth/authorized")
public class AuthorizationCodeController {
    @GetMapping("code")
    public Result code(String code){
        Map<String, String> object = new HashMap<>();
        object.put("authorized_code", code);
        return Result.success(object);
    }
}
