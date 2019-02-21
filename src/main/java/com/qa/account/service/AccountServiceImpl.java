package com.qa.account.service;

import com.qa.account.persistence.repository.AccountRepository;
import com.qa.account.persistence.domain.SentAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repo;

	@Override
	public List<SentAccount> getAccounts() {
		return repo.findAll();
	}
	
	@Override
	public ResponseEntity<Object> updateAccount(SentAccount account, Long accountId) {
		// if (accountExists(accountId)) {
		// 	account.setAccountId(accountId);
		// 	repo.save(account);
		// 	return ResponseEntity.ok().build();
		// }
		// return ResponseEntity.notFound().build();
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteAccount(Long accountId) {
		// if (accountExists(accountId)) {
		// 	repo.deleteById(accountId);
		// 	return ResponseEntity.ok().build();
		// }
		// return ResponseEntity.notFound().build();
		return null;
	}

	private boolean accountExists(Long accountId) {
		// Optional<SentAccount> accountOptional = repo.findById(accountId);
		// return accountOptional.isPresent();
		return false;
	}

}