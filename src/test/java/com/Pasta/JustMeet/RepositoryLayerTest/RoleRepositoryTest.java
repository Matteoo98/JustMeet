package com.Pasta.JustMeet.RepositoryLayerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.Pasta.JustMeet.model.Role;
import com.Pasta.JustMeet.repository.RoleRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class RoleRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	@Autowired
    private RoleRepository roleRepository;
	
	@Test
	void whenFindByName_thenReturnRole() {
		// given
		Role role = new Role();
		role.setName("ROLE");
		entityManager.persist(role);
		entityManager.flush();
		
		//when
		Role found=roleRepository.findByName(role.getName());
		
		// then
	    assertThat(found.getName())
	      .isEqualTo(role.getName());
	}

}
