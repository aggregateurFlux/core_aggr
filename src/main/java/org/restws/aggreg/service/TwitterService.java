package org.restws.aggreg.service;

import java.util.ArrayList;
import java.util.List;

import org.restws.aggreg.model.Post;

public class TwitterService {

	private List<Post> list;

	public List<Post> getPosts() {
		return list;
	}
	
	public TwitterService(List<Post> list) {
		super();
		this.list = list;
	}
	public TwitterService() {
		super();
		list = new ArrayList<Post>();
	}
	public List<Post> getList() {
		return list;
	}
	public void setList(List<Post> list) {
		this.list = list;
	}
	
}
