package com.mini.arcade.repository;

import com.mini.arcade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
