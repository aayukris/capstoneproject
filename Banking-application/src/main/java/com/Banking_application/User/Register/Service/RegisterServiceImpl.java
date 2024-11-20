package com.Banking_application.User.Register.Service;
import com.Banking_application.User.Register.Entity.UserEntity;
import com.Banking_application.User.Register.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterServiceImpl {
    @Autowired
    private UserRepo registerEntityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserEntity> getAllEntities() {
        return registerEntityRepository.findAll();
    }

    public Optional<UserEntity> getEntityById(Long accountNumber) {
        return registerEntityRepository.findById(accountNumber);
    }

    public UserEntity createEntity(UserEntity registerEntity) {
        return registerEntityRepository.save(registerEntity);
    }

    public UserEntity updateEntity(Long accountNumber, UserEntity entityDetails) {
        Optional<UserEntity> entityOptional = registerEntityRepository.findById(accountNumber);
        if (entityOptional.isPresent()) {
            UserEntity registerEntity = entityOptional.get();
            registerEntity.setName(entityDetails.getName());
            registerEntity.setAccType(entityDetails.getAccType());
            registerEntity.setCreditId(entityDetails.getCreditId());
            registerEntity.setUsername(entityDetails.getUsername());
            registerEntity.setPhoneNumber(entityDetails.getPhoneNumber());
            registerEntity.setPassword(entityDetails.getPassword());
            return registerEntityRepository.save(registerEntity);
        } else {
            throw new RuntimeException("RegisterEntity not found with account number: " + accountNumber);
        }
    }

    public void deleteEntity(Long accountNumber) {
        registerEntityRepository.deleteById(accountNumber);
    }
}