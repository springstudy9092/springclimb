package spring.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.study.domain.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {
    private String email;
    private String password;
    private String name;

    // dto로 변환
    public static UserDto from(User entity) {
        return new UserDto(
                entity.getEmail(),
                entity.getPassword(),
                entity.getName()
        );
    }

    // entity로 변환
    public User toEntity() {
        return User.of(
                email,
                password,
                name
        );
    }
}
