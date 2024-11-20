package com.Banking_application.User.Register.Controller;

import com.Banking_application.User.Register.Entity.TransactionEntity;
import com.Banking_application.User.Register.Entity.UserEntity;
import com.Banking_application.User.Register.Service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionServiceImpl transactionService;

    @GetMapping
    public List<TransactionEntity> getTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionEntity getTransactionById(@PathVariable Long id){
        return transactionService.getTransactionByID(id);
    }

    @PostMapping
    public TransactionEntity createTransaction(@RequestBody TransactionEntity transactionEntity){
        return transactionService.saveTransaction(transactionEntity);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(@RequestBody TransferRequest request) {
        try {
            Long fromAccount = request.getFromAccount();
            Long toAccount = request.getToAccount();
            Long amount = request.getAmount();

            if (fromAccount == null || toAccount == null || amount == null) {
                return ResponseEntity.badRequest().body("Invalid account or amount.");
            }

            transactionService.transferFunds(fromAccount, toAccount, amount);
            return ResponseEntity.ok("Transfer successful");

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Transfer failed: " + e.getMessage());
        }
    }

}
