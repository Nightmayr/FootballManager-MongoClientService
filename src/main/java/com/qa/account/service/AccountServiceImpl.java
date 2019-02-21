package com.qa.account.service;

import com.qa.account.persistence.repository.AccountRepository;
import com.qa.account.persistence.domain.SentAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repo;

	@Override
	public List<SentAccount> getAccounts() {
		return repo.findAll();
	}

	@Override
	public SentAccount getAccount(Long accountId) {
		return repo.findSentAccountByAccountId(accountId);
	}
	
	@Override
	public ResponseEntity<Object> updateAccount(SentAccount account, Long accountId) {
		SentAccount accToDelete = repo.findSentAccountByAccountId(accountId);
		if (accToDelete != null) {
			account.setAccountId(accountId);
			repo.save(accToDelete);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Object> deleteAccount(Long accountId) {
		SentAccount accToDelete = repo.findSentAccountByAccountId(accountId);
		if (accToDelete != null) {
			repo.delete(accToDelete);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}