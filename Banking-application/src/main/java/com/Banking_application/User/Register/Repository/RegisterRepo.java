package com.Banking_application.User.Register.Repository;

import com.Banking_application.User.Register.Entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<RegisterEntity, String> {
}
