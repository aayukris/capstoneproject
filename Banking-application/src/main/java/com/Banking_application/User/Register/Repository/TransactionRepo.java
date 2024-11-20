package com.Banking_application.User.Register.Repository;

import com.Banking_application.User.Register.Entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<TransactionEntity,Long> {
}
