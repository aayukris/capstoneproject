package com.Banking_application.User.Register.Service;
import com.Banking_application.User.Register.Entity.RegisterEntity;
import com.Banking_application.User.Register.Repository.RegisterRepo;
import com.Banking_application.User.Register.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterRepo registrationRepository;

    private static final SecureRandom random = new SecureRandom();

    private String generateAccountNumber() {
        return String.format("%012d", random.nextLong() & Long.MAX_VALUE); // Ensure the number is positive and 12 digits
    }

    @Override
    public List<RegisterEntity> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public RegisterEntity getRegistrationById(String id) {
        return registrationRepository.findById(id).orElse(null);
    }

    @Override
    public RegisterEntity saveRegistration(RegisterEntity registration) {
        // Auto-generate 12-digit account number
        registration.setAccountNumber(generateAccountNumber());
        return registrationRepository.save(registration);
    }

    @Override
    public void deleteRegistration(String id) {
        registrationRepository.deleteById(id);
    }
}
