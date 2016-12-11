package org.restws.aggreg.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String id;
	private String login;
	private String password;
	private List<SocialNetworkAccount> socialNetworkAccounts;
	
	public User() {
		super();
		this.id = "id";
		this.login = "login";
		this.password = "password";
	}
	public User(String id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
	public List<SocialNetworkAccount> getSocialNetworkAccounts() {
		return socialNetworkAccounts;
	}
	public void setSocialNetworkAccounts(List<SocialNetworkAccount> socialNetworkAccounts) {
		this.socialNetworkAccounts = socialNetworkAccounts;
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
