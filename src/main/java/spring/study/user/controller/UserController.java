package spring.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.study.user.domain.User;
import spring.study.user.service.UserRequest.UserRequest;
import spring.study.user.service.UserResponse.UserResponse;
import spring.study.user.service.UserService;

@RestController
@RequestMapping({"/api/user"})
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/test"})
    public String test() {
        return "user test.";
    }

    @PostMapping({"/login"})
    public ResponseEntity<String> login(@RequestBody UserRequest reqBody) {
        String result = userService.login(reqBody);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping({"/join"})
    public ResponseEntity<UserRequest> signUp(@RequestBody UserRequest reqBody) {
        // 일단 받은 내용 다시 반환까지 확인
        System.out.println("reqbody" + reqBody.getEmail());
        //  return userService.signUp(reqBody);
        return ResponseEntity.ok().body(reqBody);
    }

    @GetMapping("/findId")
    public ResponseEntity<UserResponse> getCurrentUser(
            //@AuthenticatedMemberId String email
            String email
    ) {
        System.out.println("/api/user/findId" + email);
        UserResponse response = userService.getByUserEmail(email);
        System.out.println("/api/user/findId1" + response);
        return ResponseEntity.ok().body(response);
    }

}
