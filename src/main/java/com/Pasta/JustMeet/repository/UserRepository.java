package com.Pasta.JustMeet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Pasta.JustMeet.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

	//User findById(Integer id);
}