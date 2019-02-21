package com.qa.account.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.account.persistence.domain.SentAccount;
import com.qa.account.service.AccountService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class AccountRest {

	@Autowired
	private AccountService service;
	
	@Value("${path.base}")
	private String basePath;

	@GetMapping("${path.getAccounts}")
	public List<SentAccount> getAccounts() {
		return service.getAccounts();
	}

	@GetMapping("/get/{accountId}")
	public SentAccount getAccount(@PathVariable Long accountId) {
		return service.getAccount(accountId);
	}
	
	@PutMapping("${path.updateAccount}")
	public ResponseEntity<Object> updateAccount(@RequestBody SentAccount account, @PathVariable Long accountId) {
		return service.updateAccount(account, accountId);
	}

	@DeleteMapping("${path.deleteAccount}")
	public ResponseEntity<Object> deleteAccount(@PathVariable Long accountId) {
		return service.deleteAccount(accountId);
}

}