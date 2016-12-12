package org.restws.aggreg.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String id;
	private String login;
	private String password;
	private TwitterAccount twitteraccount;
	private InstagramAccount instagramAccount;
	
	public TwitterAccount getTwitteraccount() {
		return twitteraccount;
	}
	public void setTwitteraccount(TwitterAccount twitteraccount) {
		this.twitteraccount = twitteraccount;
	}
	public InstagramAccount getInstagramAccount() {
		return instagramAccount;
	}
	public void setInstagramAccount(InstagramAccount instagramAccount) {
		this.instagramAccount = instagramAccount;
	}
	
	public User(String id, String login, String password, TwitterAccount twitteraccount,
			InstagramAccount instagramAccount) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.twitteraccount = twitteraccount;
		this.instagramAccount = instagramAccount;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
