package com.luv2code.userpostbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.userpostbackend.entity.User;

public interface UserRepository extends JpaRepository<User,String> {

}
