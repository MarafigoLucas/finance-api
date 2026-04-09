package com.marafigo.finance.repositories;

import com.marafigo.finance.entities.Category;
import com.marafigo.finance.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT obj FROM Transaction obj WHERE obj.user.id = :userId AND obj.date BETWEEN :min AND :max")
    List<Transaction> findByDateRange(@Param("userId") Long userId,
                                      @Param("min") Instant min,
                                      @Param("max") Instant max);
}
