/**
 * 
 */
package com.Pasta.JustMeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pasta.JustMeet.model.Notifiche;

/**
 * @author matti
 *
 */
public interface NotificheRepository extends JpaRepository<Notifiche, Integer>{
	
	
	
	Notifiche findById(int id);

}
