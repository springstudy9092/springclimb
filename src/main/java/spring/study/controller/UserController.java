package spring.study.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.study.domain.User;
import spring.study.dto.UserDto;
import spring.study.service.UserService;

import java.util.Optional;

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
    public ResponseEntity<String> login(@RequestBody UserDto reqBody) {
        String result = userService.login(reqBody);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping({"/join"})
    public ResponseEntity<UserDto> join(@RequestBody UserDto userDto) {
        //System.out.println("reqbody" + userDto.getEmail());
        userService.saveUser(userDto);
        UserDto response = userService.searchUser(userDto.getEmail()).get();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findId")
    public ResponseEntity<UserDto> getCurrentUser(
            //@AuthenticatedMemberId String email
            String email
    ) {
        System.out.println("/api/user/findId" + email);
        UserDto response = userService.searchUser(email).get();
        System.out.println("/api/user/findId1" + response);
        return ResponseEntity.ok().body(response);
    }

}