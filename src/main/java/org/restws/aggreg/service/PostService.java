package org.restws.aggreg.service;

import java.util.ArrayList;
import java.util.List;

import org.restws.aggreg.model.Post;

public class PostService {

	public List<Post> getAllPosts(String userIdentifiant) {
		Post p1 = new Post();
		Post p2 = new Post();
		List<Post> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		return list;
	}
}
