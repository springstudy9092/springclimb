package spring.study.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.study.user.domain.User;
import spring.study.user.domain.repository.JpaUserRepository;
import spring.study.user.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/login/oauth"})
public class LoginService {
    private JpaUserRepository userRepository;

    public ResponseEntity<String> userById(String id){
        ResponseEntity<String> result = ResponseEntity.ok("good");
        User user = userRepository.getById(id);

        return result;
    }

}
