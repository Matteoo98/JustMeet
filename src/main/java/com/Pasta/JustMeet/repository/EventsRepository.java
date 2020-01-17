/**
 * 
 */
package com.Pasta.JustMeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pasta.JustMeet.model.Events;
import com.Pasta.JustMeet.model.User;


/**
 * @author matti
 *
 */
public interface EventsRepository extends JpaRepository<Events, Integer> {
	
	
	
	Events findByName(String name);
	Events findById(int id);

}
