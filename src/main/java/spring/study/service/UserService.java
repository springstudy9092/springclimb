package spring.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.study.common.exception.UserNotFoundException;
import spring.study.domain.User;
import spring.study.dto.UserDto;
import spring.study.repository.UserRepository;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String join(UserDto userRequest) {
        // 임시 처리
        // 저장 구현 예정
        return "test";
    }

    public String login(UserDto userRequest){
        try{
            Optional<User> user = userRepository.findById(userRequest.getEmail());

            if(user.isPresent()){
                return "true";
            }
        }
        catch (Exception ex){
            return "false";
        }
//        Optional<User> user = userRepository.findById(userRequest.getEmail());
//
//        if(user.isPresent()){
//            return "true";
//        }
        return "false";
    }

    // 사용자 이메일 정보 기준으로 사용자 객체 반환
    @Transactional(readOnly = true)
    public Optional<UserDto> searchUser(String email) {
        // User user = userRepository.findById(email).get();
        //.orElseThrow(UserNotFoundException::new);
        // return new UserDto(user.getEmail(), user.getPassword(), user.getName());
        // return userRepository.findById(email).map(UserDto::from);
        userRepository.findById(email);
        return userRepository.findById(email).map(UserDto::from);
    }

    public void saveUser(UserDto dto) {
        userRepository.save(dto.toEntity());
    }

    public void updateUser(UserDto dto) {
        User user = userRepository.findById(dto.getEmail()).get();
        if (dto.getPassword() != null) { user.setPassword(dto.getPassword()); }
        if (dto.getName() != null) { user.setName(dto.getName()); }
    }
}
