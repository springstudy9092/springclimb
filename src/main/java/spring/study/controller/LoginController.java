package spring.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.study.service.LoginService;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/login/oauth"})
public class LoginController {
    private LoginService loginService;

    @GetMapping(path = "/kakao")
    public ResponseEntity<String> loginByKakao(){
        ResponseEntity<String> result = ResponseEntity.ok("good");

        return result;
    }

}