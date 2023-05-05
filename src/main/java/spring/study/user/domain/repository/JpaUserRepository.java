package spring.study.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.user.domain.User;

public interface JpaUserRepository extends JpaRepository<User, String>, UserRepository {
}