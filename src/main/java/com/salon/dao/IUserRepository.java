package com.salon.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salon.bean.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{
	@Query("Select u from User u where u.userId=?1 and u.password=?2")
	Optional<User> SignIn(int userId,String password);
	
	@Query("Select u from User u where u.userId=?1")
	Optional<User> SignOut(int userId);
	
	@Query("Select u from User u where u.userId=?1 and u.password=?2")
	Optional<User> Changepassword(int userId,String password);

}
