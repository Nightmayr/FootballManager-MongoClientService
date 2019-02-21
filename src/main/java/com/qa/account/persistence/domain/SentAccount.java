package com.qa.account.persistence.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sentAccount")
public class SentAccount {
	
	@Id private String id;
	private Long accountId;
	private String email;
	private String password;
	private Boolean playing;
	private String fullName;

	public SentAccount() {
		//Empty constructor
	}

	public SentAccount(Long accountId, String email, String password, String fullName, Boolean playing) {
		this.accountId = accountId;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.playing = playing;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(Boolean playing) {
		this.playing = playing;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getPlaying() {
		return playing;
	}
	
}