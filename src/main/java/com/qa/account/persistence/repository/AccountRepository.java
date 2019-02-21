package com.qa.account.persistence.repository;

import java.util.List;

import com.qa.account.persistence.domain.SentAccount;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<SentAccount, String> {

	// List<Account> findByAccountId(@Param("accountId") Long accountId);
	// List<Account> findByPlaying(@Param("playing") Boolean playing);

}