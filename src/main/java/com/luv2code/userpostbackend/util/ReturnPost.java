package com.luv2code.userpostbackend.util;

import java.util.List;

import com.luv2code.userpostbackend.entity.Post;

public class ReturnPost {
	private String message;
	private List<Post> posts;
	private Integer maxPosts;
	public ReturnPost(String message, List<Post> posts, Integer maxPosts) {
		this.message = message;
		this.posts = posts;
		this.maxPosts = maxPosts;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public Integer getMaxPosts() {
		return maxPosts;
	}
	public void setMaxPosts(Integer maxPosts) {
		this.maxPosts = maxPosts;
	}
	@Override
	public String toString() {
		return "ReturnPost [message=" + message + ", posts=" + posts + ", maxPosts=" + maxPosts + "]";
	}
	
	
	
	
}
