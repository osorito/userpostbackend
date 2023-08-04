package com.luv2code.userpostbackend.rest;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.userpostbackend.entity.Post;
import com.luv2code.userpostbackend.entity.User;
import com.luv2code.userpostbackend.service.PostService;
import com.luv2code.userpostbackend.service.UserService;
import com.luv2code.userpostbackend.util.FileUploadUtil;
import com.luv2code.userpostbackend.util.ReturnPost;

import jakarta.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/Posts")
public class PostRestController {
	
	private PostService postService;
	private UserService userService;
	
	@Autowired
	public PostRestController(PostService postService,UserService userService)
	{
		this.postService=postService;
		this.userService=userService;
	}
	
	@PostMapping("/")
	public Post addPost(@RequestParam("title")  String title,@RequestParam("content") String content,@RequestParam("image") MultipartFile multipartFile) throws IOException
	{
		System.out.println("addPost");
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		//System.out.println("Filename " + fileName); 
		Post post = new Post();
		post.setTitle(title);
		post.setContent(content);
		post.setImagePath(fileName);
		User user = userService.getUserById("cat@dog.com");
		post.setCreator(user);
		Post temp = postService.createPost(post);

		String uploadDir =  "src/main/resources/static/Images/" + temp.getId();
		System.out.println("uploadDir : " + uploadDir);
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		return post;
	}
	
	@GetMapping("/")
	public ReturnPost getPosts(@RequestParam("pagesize") Integer pagesize,@RequestParam("page") Integer page) 
	{
		return postService.getAllPosts();
	}


		
}
