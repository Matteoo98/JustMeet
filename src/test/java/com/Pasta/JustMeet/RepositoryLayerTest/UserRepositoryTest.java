package com.Pasta.JustMeet.RepositoryLayerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.Pasta.JustMeet.JustMeet;
import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository userRepository;

	@Test
	public void whenFindByUsername_thenReturnUser() {
	    // given
	    User alex = new User();
	    alex.setUsername("alex");
	    entityManager.persist(alex);
	    entityManager.flush();
	 
	    // when
	    User found = userRepository.findByUsername(alex.getUsername());
	 
	    // then
	    assertThat(found.getUsername())
	      .isEqualTo(alex.getUsername());
	}

}
