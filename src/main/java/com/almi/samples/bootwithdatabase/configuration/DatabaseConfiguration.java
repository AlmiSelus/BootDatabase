package com.almi.samples.bootwithdatabase.configuration;

import com.almi.samples.bootwithdatabase.user.User;
import com.almi.samples.bootwithdatabase.user.UserRepository;
import org.h2.server.web.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by Almi on 27-Jan-18.
 */
@Configuration
public class DatabaseConfiguration {
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

    @Bean
    public CommandLineRunner populateDatabase(UserRepository userRepository) {
        return (args) -> {
            User joeSmith = User.builder()
                    .credentialsExpired(false)
                    .locked(true)
                    .enabled(false)
                    .name("Joe")
                    .surname("Smith")
                    .email("j.smith@mail.com")
                    .password("123456")
                    .build();

            User johnDoe = User.builder()
                    .credentialsExpired(false)
                    .locked(true)
                    .enabled(false)
                    .name("John")
                    .surname("Doe")
                    .email("j.doe@mail.com")
                    .password("1234567")
                    .build();

            userRepository.save(joeSmith);
            userRepository.save(johnDoe);
        };
    }
}
