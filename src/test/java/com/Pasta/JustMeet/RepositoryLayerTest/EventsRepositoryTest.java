package com.Pasta.JustMeet.RepositoryLayerTest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.repository.EventsRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class EventsRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private EventsRepository eventsRepository;
    
    @Test
	public void whenFindByName_thenReturnEvent() {
	    // given
	    Events evento = new Events();
	    evento.setName("Partita di calcetto");
	    entityManager.persist(evento);
	    entityManager.flush();
	 
	    // when
	    Events found = eventsRepository.findByName(evento.getName());
	 
	    // then
	    assertThat(found.getName())
	      .isEqualTo(evento.getName());
	}
    
    @Test
	public void whenFindById_thenReturnEvent() {
	    // given
	    Events evento = new Events();
	    entityManager.persist(evento);
	    entityManager.flush();
	    
	    int id=evento.getId();
	    // when
	    Events found = eventsRepository.findById(id);
	 
	    // then
	    assertThat(found.getId())
	      .isEqualTo(evento.getId());
	}

}
