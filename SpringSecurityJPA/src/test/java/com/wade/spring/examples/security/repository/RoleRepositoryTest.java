package com.wade.spring.examples.security.repository;

import static org.junit.Assert.assertNotNull;

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

import com.wade.spring.examples.security.model.Role;

import nl.jqno.equalsverifier.EqualsVerifier;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class RoleRepositoryTest {
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

		Role role = Role.builder().id(1).role("role").build();
		assertNotNull(role.hashCode());
		assertNotNull(role.getId());
		assertNotNull(role.getRole());
		assertNotNull(role.toString());
	}

	@Test
	void injectedComponentsAreNotNull2() {
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
		assertNotNull(entityManager);
		assertNotNull(repository);

		Role role = new Role(1, "role");
		assertNotNull(role.hashCode());
		assertNotNull(role.getId());
		assertNotNull(role.getRole());
		assertNotNull(role.toString());
	}

	@Test
	void injectedComponentsAreNotNull3() {
		assertNotNull(dataSource);
		assertNotNull(jdbcTemplate);
		assertNotNull(entityManager);
		assertNotNull(repository);

		Role role = new Role();
		role.setId(1);
		role.setRole("role");
		assertNotNull(role.hashCode());
		assertNotNull(role.getId());
		assertNotNull(role.getRole());
		assertNotNull(role.toString());
		EqualsVerifier.forClass(Role.class).withIgnoredAnnotations(Id.class).verify();
	}
}
