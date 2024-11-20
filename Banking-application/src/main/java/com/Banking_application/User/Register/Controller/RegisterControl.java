package com.Banking_application.User.Register.Controller;

import com.Banking_application.User.Register.Entity.UserEntity;
import com.Banking_application.User.Register.Service.RegisterService;
import com.Banking_application.User.Register.Service.RegisterServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrations")
public class RegisterControl {

        @Autowired
        private RegisterServiceImpl registerEntityService;

        @GetMapping
        public List<UserEntity> getAllEntities() {
            return registerEntityService.getAllEntities();
        }

        @GetMapping("/{accountNumber}")
        public ResponseEntity<UserEntity> getEntityById(@PathVariable Long accountNumber) {
            Optional<UserEntity> entity = registerEntityService.getEntityById(accountNumber);
            if (entity.isPresent()) {
                return ResponseEntity.ok(entity.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public UserEntity createEntity(@RequestBody UserEntity userEntity) {
            return registerEntityService.createEntity(userEntity);
        }

        @PutMapping("/{accountNumber}")
        public ResponseEntity<UserEntity> updateEntity(@PathVariable Long accountNumber, @RequestBody UserEntity entityDetails) {
            try {
                UserEntity updatedEntity = registerEntityService.updateEntity(accountNumber, entityDetails);
                return ResponseEntity.ok(updatedEntity);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{accountNumber}")
        public ResponseEntity<Void> deleteEntity(@PathVariable Long accountNumber) {
            registerEntityService.deleteEntity(accountNumber);
            return ResponseEntity.noContent().build();
        }
    }
