package com.marafigo.finance.config;

import com.marafigo.finance.entities.Category;
import com.marafigo.finance.entities.User;
import com.marafigo.finance.repositories.CategoryRepository;
import com.marafigo.finance.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas","Lucas@gmail","naruto10",null);
        User u2 = new User(null, "Nic","Nic@gmail","Olga10",null);

        userRepository.saveAll(Arrays.asList(u1,u2));

        Category c1 = new Category(null,"Mercado",null);
        Category c2 = new Category(null,"Mercado",null);

        categoryRepository.saveAll(Arrays.asList(c1,c2));
    }

}
