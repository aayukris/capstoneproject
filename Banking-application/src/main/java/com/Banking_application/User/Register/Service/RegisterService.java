package com.Banking_application.User.Register.Service;

import com.Banking_application.User.Register.Entity.UserEntity;

import java.util.List;

public interface RegisterService {
    List<UserEntity> getAllRegistrations();
    UserEntity getRegistrationById(String id);
    UserEntity saveRegistration(UserEntity register);
    void deleteRegistration(String id);
}
