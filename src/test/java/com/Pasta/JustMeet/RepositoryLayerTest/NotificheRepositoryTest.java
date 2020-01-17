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


import com.Pasta.JustMeet.model.Notifiche;
import com.Pasta.JustMeet.repository.NotificheRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class NotificheRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private NotificheRepository notificheRepository;
    
    @Test
	public void whenFindById_thenReturnNotifica() {
	    // given
	    Notifiche notifica = new Notifiche();
	    entityManager.persist(notifica);
	    entityManager.flush();
	    
	    int id=notifica.getId();
	    // when
	    Notifiche found = notificheRepository.findById(id);
	 
	    // then
	    assertThat(found.getId())
	      .isEqualTo(notifica.getId());
	}

}
