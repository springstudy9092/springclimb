package spring.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.study.domain.User;
import spring.study.repository.UserRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/login/oauth"})
public class LoginService {
    private UserRepository userRepository;

    public ResponseEntity<String> userById(String id){
        ResponseEntity<String> result = ResponseEntity.ok("good");
        User user = userRepository.getById(id);

        return result;
    }

}
