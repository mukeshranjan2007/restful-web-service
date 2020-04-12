package com.rest.webservice.restfulwebservice.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	
	private Integer id;
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
	public Integer getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public User getUser() {
		return user;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	

}
