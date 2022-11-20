package sov.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sov.springsecurityjwt.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);
}
