package com.qa.account.persistence.repository;

import com.qa.account.persistence.domain.SentAccount;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<SentAccount, String> {

	SentAccount findSentAccountByAccountId(Long accountId);
	
}