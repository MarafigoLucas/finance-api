package com.marafigo.finance.repositories;

import com.marafigo.finance.entities.Category;
import com.marafigo.finance.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
