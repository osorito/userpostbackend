package com.luv2code.userpostbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name="post")
public class Post {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="image_path")
	private String imagePath;
	
	//If you delete a post, dont delete the User
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="creator")
	private User creator;
	
	public Post()
	{
		
	}

	public Post(String title, String content, String imagePath, User creator) {
		this.title = title;
		this.content = content;
		this.imagePath = imagePath;
		this.creator = creator;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Transient
	public String getImagePath() {
		return "http://localhost:8080/Images/" + getId() + "/" +  imagePath;
	}

	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", imagePath=" + imagePath
				+ ", creator=" + creator + "]";
	}
	
	
	
	
	

}
