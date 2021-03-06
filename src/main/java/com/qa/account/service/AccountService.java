package com.qa.account.service;

import org.springframework.http.ResponseEntity;

import com.qa.account.persistence.domain.SentAccount;

import java.util.List;

public interface AccountService {

	List<SentAccount> getAccounts();

	SentAccount getAccount(Long accountId);

	List<SentAccount> getPlaying(Boolean playing);

	ResponseEntity<Object> updateAccount(SentAccount account, Long accountId);

	ResponseEntity<Object> deleteAccount(Long accountId);
}