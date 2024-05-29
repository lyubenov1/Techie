package com.techie.repository;

import com.techie.domain.entities.RoleEntity;
import com.techie.domain.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

   Optional<RoleEntity> findRoleEntityByRole(UserRoleEnum role);

}
