package com.Banking_application.User.Register.Service;

import com.Banking_application.User.Register.Entity.RegisterEntity;
import java.util.List;

public interface RegisterService {
    List<RegisterEntity> getAllRegistrations();
    RegisterEntity getRegistrationById(String id);
    RegisterEntity saveRegistration(RegisterEntity register);
    void deleteRegistration(String id);
}
