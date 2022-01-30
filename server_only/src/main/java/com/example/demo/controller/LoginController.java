package com.example.demo.controller;


import com.example.demo.dto.UserVO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    LoginService loginService;

    @GetMapping("/login/check")                 //로그인시 비밀번호 OTP 확인 작업
    int insertUser(@RequestParam String userid, @RequestParam int index, @RequestParam char input){

        String tmp = loginService.login(userid);

        if(tmp.charAt(index-1) == input)return 1;
        else return -1;
    }

    @GetMapping("/login/length")                    // 아이디의 비밀번호 길이 반환
    int getlength(@RequestParam String userid){

        if(userRepository.existsById(userid))return loginService.login(userid).length();
        else return -1;
    }
}
