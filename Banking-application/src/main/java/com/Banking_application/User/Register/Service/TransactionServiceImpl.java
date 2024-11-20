package com.Banking_application.User.Register.Service;
import com.Banking_application.User.Register.Entity.TransactionEntity;
import com.Banking_application.User.Register.Entity.UserEntity;
import com.Banking_application.User.Register.Repository.TransactionRepo;
import com.Banking_application.User.Register.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class TransactionServiceImpl {

    @Autowired
    private TransactionRepo transactionRepository;

    @Autowired
    private UserRepo userRepo;

    public List<TransactionEntity> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public TransactionEntity getTransactionByID(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public TransactionEntity saveTransaction(TransactionEntity transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }


    @Transactional
    public void transferFunds(Long from, Long to, Long amount){
        Optional<UserEntity> fromAccountOpt = userRepo.findById(from);
        Optional<UserEntity> toAccountOpt = userRepo.findById(to);

        if (fromAccountOpt.isPresent() && toAccountOpt.isPresent()) {
            UserEntity fromAccountEntity = fromAccountOpt.get();
            UserEntity toAccountEntity = toAccountOpt.get();
            if (fromAccountEntity.getBalance().compareTo(Double.valueOf(amount)) >= 0) {
                fromAccountEntity.setBalance(fromAccountEntity.getBalance() - amount);
                toAccountEntity.setBalance(toAccountEntity.getBalance() + amount);
                userRepo.save(fromAccountEntity);
                userRepo.save(toAccountEntity);
            } else {
                throw new RuntimeException("Insufficient funds in the source account");
            }
        } else {
            throw new RuntimeException("One or both accounts not found");
        }
    }
}

