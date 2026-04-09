package com.marafigo.finance.services;

import com.marafigo.finance.entities.Transaction;
import com.marafigo.finance.entities.User;
import com.marafigo.finance.entities.dto.UserBalanceDTO;
import com.marafigo.finance.repositories.TransactionRepository;
import com.marafigo.finance.repositories.UserRepository;
import com.marafigo.finance.services.exceptions.DatabaseException;
import com.marafigo.finance.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private TransactionRepository transactionRepository;

    public List<User> findAll() {
        return repository.findAll();
    }


    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
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

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }

    public UserBalanceDTO getUserBalance(Long id,String minDate, String maxDate){
        User user = findById(id);

        Instant min = (minDate == null || minDate.isBlank() ? Instant.parse("2000-01-01T00:00:00Z") : Instant.parse(minDate));
        Instant max = (maxDate == null || maxDate.isBlank()) ? Instant.now() : Instant.parse(maxDate);


        List<Transaction> transactions = transactionRepository.findByDateRange(id, min, max);
        BigDecimal income = BigDecimal.ZERO;
        BigDecimal expense = BigDecimal.ZERO;
        for(Transaction t : transactions){
            if(t.getType().toString().equals("INCOME")){
                income = income.add(t.getAmount());
            }else {
                expense = expense.add(t.getAmount());
            }
        }return new UserBalanceDTO(
                income.doubleValue(),
                expense.doubleValue(),
                income.subtract(expense).doubleValue()
        );
    }


}
