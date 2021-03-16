package com.wade.spring.examples.security.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import com.wade.spring.examples.security.model.Role;
import com.wade.spring.examples.security.model.User;

@ExtendWith(MockitoExtension.class)
class MyUserDetailsServiceTest {
	@Mock
	private UserService mockUserService;
	@InjectMocks
	private MyUserDetailsService service;

	@Test
	void testLoadUserByUsername() {
		Role role = Role.builder().id(1).role("role").build();
		HashSet<Role> roles = new HashSet<>();
		roles.add(role);
		User user = User.builder().id(1).userName("GPonce").email("test@test.com").name("Gustavo").lastName("Ponce")
				.password("pasword").active(true).roles(roles).build();
		String userName = "GPonce";
		when(mockUserService.findUserByUserName(userName)).thenReturn(user);
		UserDetails result = service.loadUserByUsername(userName);
		assertNotNull(result);
		assertNotNull(result.getUsername());
		assertNotNull(result.getPassword());
		assertNotNull(result.getAuthorities());
	}
}
