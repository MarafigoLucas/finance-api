package com.marafigo.finance.config;

import com.marafigo.finance.entities.Category;
import com.marafigo.finance.entities.Transaction;
import com.marafigo.finance.entities.User;
import com.marafigo.finance.entities.enums.TransactionType;
import com.marafigo.finance.repositories.CategoryRepository;
import com.marafigo.finance.repositories.TransactionRepository;
import com.marafigo.finance.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas","Lucas@gmail","naruto10",null);
        User u2 = new User(null, "Nic","Nic@gmail","Olga10",null);

        userRepository.saveAll(Arrays.asList(u1,u2));

        Category c1 = new Category(null,"Mercado",null);
        Category c2 = new Category(null,"Lazer",null);
        Category c3 = new Category(null,"Salario",null);

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

        Transaction t1 = new Transaction(null,
                "Compra mes",
                new BigDecimal("250.50"),
                Instant.parse("2026-04-06T10:00:00Z"),
                TransactionType.EXPENSE,
                u1,
                c1);
        Transaction t2 = new Transaction(null,
                "Restaurante",
                new BigDecimal("120.20"),
                Instant.parse("2026-05-06T10:00:00Z"),
                TransactionType.EXPENSE,
                u2,
                c2);
        Transaction t3 = new Transaction(null,
                "salario",
                new BigDecimal("1500.00"),
                Instant.parse("2026-05-06T10:00:00Z"),
                TransactionType.INCOME,
                u2,
                c2);

        transactionRepository.saveAll(Arrays.asList(t1,t2,t3));
    }

}
