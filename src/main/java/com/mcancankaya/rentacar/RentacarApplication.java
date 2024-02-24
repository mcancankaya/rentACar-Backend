package com.mcancankaya.rentacar;

import com.mcancankaya.rentacar.entities.User;
import com.mcancankaya.rentacar.enums.Role;
import com.mcancankaya.rentacar.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class RentacarApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RentacarApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User adminAccount = userRepository.findByRole(Role.ADMIN);
        if (adminAccount == null) {
            User user = new User();
            user.setEmail("admin@rentacar.com");
            user.setFirstName("admin");
            user.setLastName("root");
            user.setRole(Role.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }
}
