package com.Banking_application.User.Register.Service;

import com.Banking_application.User.Register.Entity.CreditCardEntity;
import com.Banking_application.User.Register.Entity.UserEntity;
import com.Banking_application.User.Register.Repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCardEntity createCreditCard(CreditCardEntity creditCardEntity) {
        // Add any business logic if needed
        return creditCardRepository.save(creditCardEntity);  // Save the entity to the database
    }

    public List<CreditCardEntity> getAllEntities() {
        return creditCardRepository.findAll();
    }
}
