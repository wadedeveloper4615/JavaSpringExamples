package com.wade.spring.examples.security.repository;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wade.spring.examples.security.model.User;
import com.wade.spring.examples.security.model.User.UserBuilder;

import nl.jqno.equalsverifier.EqualsVerifier;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserRepositoryTest {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private RoleRepository repository;

	@Test
	void injectedComponentsAreNotNull1() {
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
		assertNotNull(entityManager);
		assertNotNull(repository);

		UserBuilder b = User.builder().id(1).userName("GPonce").email("test@test.com").password("???").name("Gustavo")
				.lastName("Ponce").active(true).roles(new HashSet<>());
		User user = b.build();
		assertNotNull(user.hashCode());
		assertNotNull(user.getId());
		assertNotNull(user.getUserName());
		assertNotNull(user.toString());
		assertNotNull(b.toString());
	}

	@Test
	void injectedComponentsAreNotNull2() {
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
		assertNotNull(entityManager);
		assertNotNull(repository);

		User user = new User(1, "GPonce", "test@test.com", "", "Gustavo", "Ponce", true, new HashSet<>());
		assertNotNull(user.hashCode());
		assertNotNull(user.getId());
		assertNotNull(user.getUserName());
		assertNotNull(user.toString());
	}

	@Test
	void injectedComponentsAreNotNull3() {
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
		assertNotNull(entityManager);
		assertNotNull(repository);

		User user = new User();
		user.setId(1);
		user.setUserName("GPonce");
		user.setEmail("test@test.com");
		user.setLastName("Ponce");
		user.setName("Gustavo");
		assertNotNull(user.hashCode());
		assertNotNull(user.getId());
		assertNotNull(user.getUserName());
		assertNotNull(user.toString());
		EqualsVerifier.forClass(User.class).withIgnoredAnnotations(Id.class).verify();
	}
}
