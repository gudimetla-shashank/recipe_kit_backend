package com.example.user_service.Repository.JPA;

import com.example.user_service.entities.output.CartOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartJPARepository extends JpaRepository<CartOutputEntity, Long> {
}
