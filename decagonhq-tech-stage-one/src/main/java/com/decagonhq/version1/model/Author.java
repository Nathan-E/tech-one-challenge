package com.decagonhq.version1.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
	
	public int id;
	public String username;
	public String about;
	public int submitted;
	public Date updated_at;
	public int submission_count;
	public int comment_count;
	public Date created_at;
	
	//is necessary to have empty constructor for java marshaling...
	public Author() { }

	
	public Author(int id, String username, String about, int submitted, Date updated_at, int submission_count,
			int comment_count, Date created_at) {
		super();
		this.id = id;
		this.username = username;
		this.about = about;
		this.submitted = submitted;
		this.updated_at = updated_at;
		this.submission_count = submission_count;
		this.comment_count = comment_count;
		this.created_at = created_at;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getSubmitted() {
		return submitted;
	}
	public void setSubmitted(int submitted) {
		this.submitted = submitted;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public int getSubmission_count() {
		return submission_count;
	}
	public void setSubmission_count(int submission_count) {
		this.submission_count = submission_count;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


}
