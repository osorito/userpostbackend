package com.luv2code.userpostbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.userpostbackend.entity.Post;

public interface PostRespository extends JpaRepository<Post,Integer> {

}
