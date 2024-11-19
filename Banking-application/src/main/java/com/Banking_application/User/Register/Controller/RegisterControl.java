package com.Banking_application.User.Register.Controller;

import com.Banking_application.User.Register.Entity.RegisterEntity;
import com.Banking_application.User.Register.Service.RegisterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/registrations")
public class RegisterControl {
    @Autowired
    private RegisterService registrationService;

    @GetMapping
    public List<RegisterEntity> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public RegisterEntity getRegistrationById(@PathVariable String id) {
        return registrationService.getRegistrationById(id);
    }

    @PostMapping
    public RegisterEntity createRegistration(@RequestBody RegisterEntity registration) {
        return registrationService.saveRegistration(registration);
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable String id) {
        registrationService.deleteRegistration(id);
    }
}
