package spring.study.user.service.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.study.user.domain.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserResponse {

    private String email;
    private String password;
    private String name;

    public UserResponse(User user) {
        this(user.getEmail(), user.getName(), user.getPassword());
    }
}
