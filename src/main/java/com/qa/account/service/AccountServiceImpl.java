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
	public SentAccount getAccount(Long accountId) {
		System.out.println(repo.findAccountById(accountId));
		return repo.findAccountById(accountId);
	}
	
	@Override
	public ResponseEntity<Object> updateAccount(SentAccount account, Long accountId) {
		if (accountExists(accountId)) {
			account.setAccountId(accountId);
			repo.save(account);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Object> deleteAccount(Long accountId) {
		SentAccount accToDelete = repo.findAccountById(accountId);
		if (accToDelete != null) {
			repo.delete(accToDelete);
			System.out.println("it worked");
			return ResponseEntity.ok().build();
		}
		System.out.println("it no work");
		return ResponseEntity.notFound().build();
	}

	private boolean accountExists(Long accountId) {
		Optional<SentAccount> accountOptional = repo.findById(accountId);
		return accountOptional.isPresent();
	}

}