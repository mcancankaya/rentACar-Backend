package com.mcancankaya.rentacar.repositories;

import com.mcancankaya.rentacar.entities.User;
import com.mcancankaya.rentacar.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User findByRole(Role role);
}
