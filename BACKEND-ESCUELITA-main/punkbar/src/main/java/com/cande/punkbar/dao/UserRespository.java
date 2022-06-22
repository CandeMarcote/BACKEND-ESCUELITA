package com.cande.punkbar.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cande.punkbar.entity.User;

public interface UserRespository extends JpaRepository<User, Integer> {

	public Optional<User> findByUsernameOrEmailAndPassword(String username, String email, String password);
}
