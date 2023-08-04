package com.luv2code.userpostbackend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luv2code.userpostbackend.dao.PostRespository;
import com.luv2code.userpostbackend.entity.Post;
import com.luv2code.userpostbackend.util.ReturnPost;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Service
public class PostService {

	private PostRespository postRepository;

	
	@Autowired
	public PostService(PostRespository postRepository)
	{
		this.postRepository=postRepository;
	}
//	
	public Post createPost(Post post)
	{
		post.setId(0);//Database will set the id the moment it is created
		return postRepository.save(post);
	}
	
	public ReturnPost getAllPosts()
	{
		List<Post> posts = postRepository.findAll();
		ReturnPost returnPost = new ReturnPost("Posts fetched succesfuly!",posts, posts.size() );
		return returnPost;
	}
	
	
}
