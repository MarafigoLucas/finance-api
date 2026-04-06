package com.marafigo.finance.services;

import com.marafigo.finance.entities.Transaction;
import com.marafigo.finance.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public List<Transaction> findAll(){
        return repository.findAll();
    }

}
