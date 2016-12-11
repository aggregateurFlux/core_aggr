package org.restws.aggreg.model;

public abstract class SocialNetworkAccount {

	private String name;

	public SocialNetworkAccount() {
		super();
	}
	public SocialNetworkAccount(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
