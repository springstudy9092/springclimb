package spring.study.user.service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.study.user.domain.User;
import spring.study.user.domain.repository.JpaUserRepository;
import spring.study.user.domain.repository.UserRepository;
import spring.study.user.service.UserRequest.UserRequest;
import spring.study.user.service.UserResponse.UserResponse;

@Service
@RequiredArgsConstructor
public class UserService {
    private JpaUserRepository userrepository;

    @Autowired
    public UserService(JpaUserRepository userrepository) {
        this.userrepository = userrepository;
    }

    public String signUp(UserRequest userRequest) {
        return "test";
    }

    // 사용자 이메일 정보 기준으로 사용자 객체 반환
    public UserResponse getByUserEmail(String email) {
       User user = userrepository.findById(email).get();
                //.orElseThrow(UserNotFoundException::new);
        return new UserResponse(user.getEmail(), user.getPassword(),
                user.getName());
    }

}
