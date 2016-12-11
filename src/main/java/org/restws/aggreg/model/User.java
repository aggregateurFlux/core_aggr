package org.restws.aggreg.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String identifiant;
	private String password;
	
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public User(String identifiant, String password) {
		this.identifiant = identifiant;
		this.password = password;
	}
	public User() {
		this.identifiant = "identifiant";
		this.password = "password";
	}
}
