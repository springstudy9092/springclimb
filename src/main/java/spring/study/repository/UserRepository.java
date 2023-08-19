package spring.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.study.domain.User;

public interface UserRepository extends JpaRepository<User, String> { }
