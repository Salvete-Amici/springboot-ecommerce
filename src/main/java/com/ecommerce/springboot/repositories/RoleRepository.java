package com.ecommerce.springboot.repositories;

import com.ecommerce.springboot.model.AppRole;
import com.ecommerce.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
