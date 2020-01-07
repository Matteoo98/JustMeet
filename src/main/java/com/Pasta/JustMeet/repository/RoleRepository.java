package com.Pasta.JustMeet.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.Pasta.JustMeet.model.*;

public interface RoleRepository extends JpaRepository<Role, Integer>{
   
	Role findByName(String name);
}
