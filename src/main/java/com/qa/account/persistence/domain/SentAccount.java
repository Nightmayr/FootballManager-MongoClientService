package com.qa.account.persistence.domain;

import javax.persistence.Id;

public class SentAccount {
	
	@Id
	private String id;
	private Long accountId;
	private String email;
	private String fullName;
	private Boolean playing;

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
	
}