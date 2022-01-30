package com.example.demo.controller;

import com.example.demo.dto.UserVO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")                                   //회원가입
    int insertUser(@RequestBody UserVO user){
        return userService.register(user);
    }

    @GetMapping("/register/check")                              //회원가입시 중복확인
    int checkId(@RequestParam String checkid){
        return userService.check(checkid);
    }

    @GetMapping("/user/showinfo")                               //회원정보 반환
    UserVO showinfo(@RequestParam String userid){
        return userService.showuserinfo(userid);
    }

    @GetMapping("/user/cleardb")                                //DB날리기
    int cleardb(@RequestParam int flag){
        return userService.cleardb(flag);
    }
}
