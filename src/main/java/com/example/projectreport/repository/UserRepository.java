package com.example.projectreport.repository;

import com.example.projectreport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from users WHERE email = ? and password = ?",nativeQuery = true )
    User findByUsername(String username);
    @Query(value = "select * from users WHERE email = ? and password = ?",nativeQuery = true )
    User findByEmailAndPassword(String email, String password);
}
