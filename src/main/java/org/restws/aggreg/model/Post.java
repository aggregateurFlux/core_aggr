package org.restws.aggreg.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Post {

	private String idAuthor;
	private String authorName;
	private String content;
	private String imageLink;
	private String postCreatedAt;
	private String origin;
	
	public Post() {
		this.idAuthor = "idAuthor";
		this.authorName = "authorName";
		this.content = "content";
		this.imageLink = "imageLink";
		this.postCreatedAt = "postCreatedAt";
		this.origin = "origin";
	}

	public Post(String idAuthor, String authorName, String content, String imageLink, String postCreatedAt, String origin) {
		super();
		this.idAuthor = idAuthor;
		this.authorName = authorName;
		this.content = content;
		this.imageLink = imageLink;
		this.postCreatedAt = postCreatedAt;
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(String idAuthor) {
		this.idAuthor = idAuthor;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getPostCreatedAt() {
		return postCreatedAt;
	}
	public void setPostCreatedAt(String postCreatedAt) {
		this.postCreatedAt = postCreatedAt;
	}
	
	
}
