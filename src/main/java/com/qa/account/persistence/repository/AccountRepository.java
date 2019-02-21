package com.qa.account.persistence.repository;

import com.qa.account.persistence.domain.SentAccount;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<SentAccount, Long> {

	@Query("{ 'accountId' : ?0 }")
	SentAccount findAccountById(Long accountId);

}