package com.luv2code.userpostbackend.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@NotNull(message="Email must not be null")
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message="Invalid email format")
	@Column(name="email")
	private String email;
	
	@NotNull(message="Password must not be null")
	@Column(name="password")
	private String password;
	
	
	//If you delete a user, delete all hist posts
	@JsonIgnore
	@OneToMany(mappedBy="creator", cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},fetch=FetchType.LAZY)
	private List<Post> posts;
	
	public User()
	{
		
	}
	
	public User(String email,String password)
	{
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public void add(Post post)
	{
		if(posts == null)
		{
			posts = new ArrayList<>();
		}
		posts.add(post);
		post.setCreator(this);
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}
	
	

}
