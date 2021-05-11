package com.ys.sec.controller;


import com.ys.sec.entity.Result;
import com.ys.sec.entity.ResultStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
        String url = request.getRequestURL().toString();
        return Result.success(url);
    }
}
