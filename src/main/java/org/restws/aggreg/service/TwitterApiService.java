package org.restws.aggreg.service;

import java.util.ArrayList;
import java.util.List;

import org.restws.aggreg.model.Post;
import org.restws.aggreg.model.User;

public class TwitterApiService {

	private List<Post> list;

	public List<Post> getPosts(String access_token, String access_token_secret) {
		//appel à twitter
		return list;
	}
	
	public TwitterApiService(List<Post> list) {
		super();
		this.list = list;
	}
	public TwitterApiService() {
		super();
		list = new ArrayList<Post>();
	}
	public List<Post> getList() {
		return list;
	}
	public void setList(List<Post> list) {
		this.list = list;
	}

	public static Post getPosts(User accountInfos) {
		return null;
	}
	
}
