package org.restws.aggreg.model;

public class TwitterAccount extends SocialNetworkAccount {

	private String accessTokenId;
	private String accessTokenSecret;
	
	public TwitterAccount() {
		super();
		this.setName("Twitter");
	}
	public TwitterAccount(String accessTokenId, String accessTokenSecret) {
		super();
		this.setName("Twitter");
		this.accessTokenId = accessTokenId;
		this.accessTokenSecret = accessTokenSecret;
	}
	public String getAccessTokenId() {
		return accessTokenId;
	}
	public void setAccessTokenId(String accessTokenId) {
		this.accessTokenId = accessTokenId;
	}
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}
	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}
	
	
}
