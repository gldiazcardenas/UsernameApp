package com.intertect.username.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.intertect.usernameapp.dto.UsernameValidationResult;
import com.intertect.usernameapp.service.RestrictedWordService;
import com.intertect.usernameapp.service.UserService;
import com.intertect.usernameapp.service.UsernameGenerator;
import com.intertect.usernameapp.service.exception.ServiceException;
import com.intertect.usernameapp.service.impl.UsernameValidatorImpl;

@RunWith(MockitoJUnitRunner.class)
public class UsernameValidatorImplTest {
	
	@Mock
	private UserService userService;
	
	@Mock
	private UsernameGenerator usernameGenerator;
	
	@Mock
	private RestrictedWordService restrictedWordService;
	
	@InjectMocks
	private UsernameValidatorImpl validator;
	
	@Test
	public void testValidUsername () {
		String username = "gabriel";
		when(userService.isTakenUsername(any(String.class))).thenReturn(false);
		UsernameValidationResult result = validator.validate(username);
		assertNotNull(result);
		assertTrue(result.isValid());
		assertNotNull(result.getSuggestedUsernames());
		assertTrue(result.getSuggestedUsernames().isEmpty());
		verify(userService, atLeastOnce()).isTakenUsername(eq(username));
	}
	
	@Test(expected = ServiceException.class)
	public void testErrorUsernameNull () {
		validator.validate(null);
	}
	
	@Test(expected = ServiceException.class)
	public void testErrorUsernameTooShort () {
		validator.validate("short");
	}
	
	@Test
	public void testInvalidTakenUsername () {
		String username = "gabriel";
		when(userService.isTakenUsername(eq(username))).thenReturn(true);
		when(usernameGenerator.suggestUsername(any(String.class))).thenReturn("gabriel_01");
		when(restrictedWordService.containsRestrictedWord(any(String.class))).thenReturn(false);
		
		UsernameValidationResult result = validator.validate(username);
		
		verify(userService, atLeastOnce()).isTakenUsername(eq(username));
		verify(restrictedWordService, atLeastOnce()).containsRestrictedWord(any(String.class));
		
		assertNotNull(result);
		assertFalse(result.isValid());
		assertNotNull(result.getSuggestedUsernames());
		assertFalse(result.getSuggestedUsernames().isEmpty());
		assertEquals(result.getSuggestedUsernames().size(), 1);
	}
	
	@Test
	public void testInvalidTakenUsername_ContainsRestrictedWord () {
		String username = "gabriel";
		String suggested = "gabriel_01";
		when(userService.isTakenUsername(eq(username))).thenReturn(true);
		when(usernameGenerator.suggestUsername(any(String.class))).thenReturn("gabriel_01");
		when(restrictedWordService.containsRestrictedWord(eq(suggested))).thenReturn(true);
		
		UsernameValidationResult result = validator.validate(username);
		
		verify(userService, atLeastOnce()).isTakenUsername(eq(username));
		verify(restrictedWordService, atLeastOnce()).containsRestrictedWord(any(String.class));
		
		assertNotNull(result);
		assertFalse(result.isValid());
		assertNotNull(result.getSuggestedUsernames());
		assertTrue(result.getSuggestedUsernames().isEmpty());
	}

}
