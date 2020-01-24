package com.Pasta.JustMeet.ServiceLayerTest;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Pasta.JustMeet.model.User;
import com.Pasta.JustMeet.repository.UserRepository;
import com.Pasta.JustMeet.service.UserService;
import com.Pasta.JustMeet.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
	
	@TestConfiguration
    static class UserServiceImplTestContextConfiguration {
  
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

	@Autowired
    private UserService userService;
	@MockBean
    private UserRepository userRepository;
	
	@Before
	public void setUp() {
	    User matteo = new User();
	    matteo.setUsername("Matteo");
	    Mockito.when(userRepository.findByUsername(matteo.getUsername()))
	      .thenReturn(matteo);
	}
	
	@Test
	public void whenValidUsername_thenUserShouldBeFound() {
	    String name = "Matteo";
	    User found = userService.findByUsername(name);
	     assertThat(
	    		 found.getUsername())
	      .isEqualTo(name);
	 }
	
}
