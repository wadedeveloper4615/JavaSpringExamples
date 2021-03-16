package com.wade.spring.examples.security.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wade.spring.examples.security.model.User;
import com.wade.spring.examples.security.repository.RoleRepository;
import com.wade.spring.examples.security.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private UserRepository mockUserRepository;
	@Mock
	private RoleRepository mockRoleRepository;
	@Mock
	private BCryptPasswordEncoder mockBCryptPasswordEncoder;
	@InjectMocks
	private UserService userServiceUnderTest;
	private User user;

	@BeforeEach
	public void setUp() {
		user = User.builder().id(1).userName("GPonce").name("Gustavo").lastName("Ponce").email("test@test.com").build();
	}

	@Test
	public void testFindByUserName() {
		String userName = "GPonce";
		when(mockUserRepository.findByUserName(userName)).thenReturn(user);
		User result = userServiceUnderTest.findUserByUserName(userName);
		assertNotNull(result);
		assertEquals(userName, result.getUserName());
	}

	@Test
	public void testFindUserByEmail() {
		when(mockUserRepository.findByEmail(anyString())).thenReturn(user);
		final String email = "test@test.com";
		final User result = userServiceUnderTest.findUserByEmail(email);
		assertEquals(email, result.getEmail());
	}

	@Test
	public void testSaveUser() {
		when(mockUserRepository.save(any())).thenReturn(user);
		final String email = "test@test.com";
		User result = userServiceUnderTest.saveUser(User.builder().build());
		assertEquals(email, result.getEmail());
	}
}
