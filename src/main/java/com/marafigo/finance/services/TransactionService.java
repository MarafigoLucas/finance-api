package com.marafigo.finance.services;

import com.marafigo.finance.entities.Transaction;
import com.marafigo.finance.repositories.TransactionRepository;
import com.marafigo.finance.services.exceptions.DatabaseException;
import com.marafigo.finance.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public List<Transaction> findAll(){
        return repository.findAll();
    }

    public Transaction findById(Long id){
        Optional<Transaction> obj = repository.findById(id);
       return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Transaction insert(Transaction obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try{
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Não é possível excluir: este registro possui vínculos ativos.");
        }
    }

    public Transaction update(Long id, Transaction obj){
        Transaction entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(Transaction entity, Transaction obj){
        entity.setDescription(obj.getDescription());
        entity.setAmount(obj.getAmount());
        entity.setType(obj.getType());
        entity.setDate(obj.getDate());
        entity.setCategory(obj.getCategory());
    }



}
