package com.mail_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mail_service.entity.User;
import java.util.List;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{ 
	Optional<User> findByEmail(String email);
	List<User> findByUsernameAndPassword(String username, String password);
}
