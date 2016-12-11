package org.restws.aggreg.service;

import java.util.ArrayList;
import java.util.List;

import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.User;

public class InstagramApiService {
	public List<Post> list;

	public static List<Post> getPosts(User user) {
		List<Post> list = new ArrayList();
		return list;
	}
	
	public InstagramApiService() {
		super();
	}
	public InstagramApiService(List<Post> list) {
		super();
		this.list = list;
	}
	public List<Post> getList() {
		return list;
	}
	public void setList(List<Post> list) {
		this.list = list;
	}
	
	

}
