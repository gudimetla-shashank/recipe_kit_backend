package com.example.user_service.repository.JPA;

import com.example.user_service.entities.outputentities.outputentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface JPARepository extends JpaRepository<outputentity,Long> {


    boolean existsByEmail(String email);
    boolean existsByPhonenumber(String phonenumber);
}

