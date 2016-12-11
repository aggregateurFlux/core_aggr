package org.restws.aggreg.model;

public class InstagramAccount extends SocialNetworkAccount{

	private String token;

	public InstagramAccount() {
		super();
		this.setName("Instagram");
	}

	public InstagramAccount(String token) {
		super();
		this.setName("Instagram");
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
