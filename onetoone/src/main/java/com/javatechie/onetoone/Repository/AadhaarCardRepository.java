package com.javatechie.onetoone.Repository;


import com.javatechie.onetoone.model.AadhaarCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AadhaarCardRepository extends JpaRepository<AadhaarCard, Long> {
}