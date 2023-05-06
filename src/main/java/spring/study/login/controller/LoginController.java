package spring.study.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.study.login.service.LoginService;
import spring.study.user.service.UserService;

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
