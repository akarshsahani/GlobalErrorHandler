package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findByEmail(String email);

	@Query(value = "SELECT * FROM user WHERE name LIKE %?1% OR email LIKE %?1%", nativeQuery = true)
	List<User> search(String search);

}
