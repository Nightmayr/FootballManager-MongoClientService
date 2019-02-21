package com.qa.account;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sentAccount", path = "sentAccount")
public interface AccountRepository extends MongoRepository<Account, String> {

	List<Account> findByAccountId(@Param("accountId") Long accountId);
	List<Account> findByPlaying(@Param("playing") Boolean playing);

}