package com.kelvin.javafxspringboot.repository;

import com.kelvin.javafxspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT obj FROM User obj WHERE obj.username =:username")
    User findByUsername(@Param("username") String username);


}
