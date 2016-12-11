package org.restws.aggreg.model;

public class TwitterAccount extends SocialNetworkAccount {

	private String access_token;
	private String access_token_secret;
	
	public TwitterAccount() {
		super();
		this.setName("Twitter");
	}
	public TwitterAccount(String access_token, String access_token_secret) {
		super();
		this.setName("Twitter");
		this.access_token = access_token;
		this.access_token_secret = access_token_secret;
	}
	public String getAccessTokenId() {
		return access_token;
	}
	public void setAccessTokenId(String access_token) {
		this.access_token = access_token;
	}
	public String getAccessTokenSecret() {
		return access_token_secret;
	}
	public void setAccessTokenSecret(String access_token_secret) {
		this.access_token_secret = access_token_secret;
	}
	
	
}
