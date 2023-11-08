package com.magic.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic.user.service.entites.User;

public interface UserRepository extends JpaRepository<User, String> {

}
