package com.techie.repository;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

   Optional<RoleEntity> findRoleEntityByRole(UserRoleEnum role);
}
