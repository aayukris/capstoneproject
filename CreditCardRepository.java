package com.Banking_application.User.Register.Repository;

import com.Banking_application.User.Register.Entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
    // You can define custom queries here if needed
}
