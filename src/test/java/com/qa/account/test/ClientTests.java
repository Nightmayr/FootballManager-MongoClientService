package com.qa.account.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.qa.account.persistence.domain.SentAccount;
import com.qa.account.rest.AccountRest;
import com.qa.account.service.AccountService;

@RunWith(MockitoJUnitRunner.class)
public class ClientTests {

	@InjectMocks
	AccountRest rest;
	
	@Mock
	AccountService service;
	
	@Mock
	RestTemplate restTemp;
	
	private static final SentAccount MOCK_ACCOUNT_1 = new SentAccount(1L, "BenJackson", "example1@hotmail.com",  "qwerty", false);
	private static final SentAccount MOCK_ACCOUNT_2 = new SentAccount(2L, "Alvin&TheChipmunks", "example2@hotmail.com",  "password", false);
	private static final ResponseEntity<Object> MOCK_RESPONSE_ENTITY = new ResponseEntity<>(HttpStatus.ACCEPTED);
 
	
	@Test
	public void getAccountsTest() {
		List<SentAccount> MOCK_LIST = new ArrayList<>();;
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);
		Mockito.when(service.getAccounts()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, rest.getAccounts());
		Mockito.verify(service).getAccounts();
	}
	
	@Test
	public void getAccountTest() {
		Mockito.when(service.getAccount(1L)).thenReturn(MOCK_ACCOUNT_1);
		assertEquals(MOCK_ACCOUNT_1, rest.getAccount(1L));
		Mockito.verify(service).getAccount(1L);
	}
	
	@Test
	public void deleteAccountTest() {
		Mockito.when(service.deleteAccount(1L)).thenReturn(MOCK_RESPONSE_ENTITY);
		assertEquals(MOCK_RESPONSE_ENTITY, rest.deleteAccount(1L));
		Mockito.verify(service).deleteAccount(1L);
	}
	 
	@Test
	public void updateAccountTest() {
		Mockito.when(service.updateAccount(MOCK_ACCOUNT_1, 1L)).thenReturn(MOCK_RESPONSE_ENTITY);
		assertEquals(MOCK_RESPONSE_ENTITY, rest.updateAccount(MOCK_ACCOUNT_1, 1L));
		Mockito.verify(service).updateAccount(MOCK_ACCOUNT_1, 1L);
	}
	
}