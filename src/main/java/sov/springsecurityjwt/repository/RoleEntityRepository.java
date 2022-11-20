package sov.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sov.springsecurityjwt.entity.RoleEntity;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);
}
