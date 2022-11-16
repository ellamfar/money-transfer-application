package com.ellamfar.moneytransferapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(AccountRepository repository) {

    // Preload two accounts
    return args -> {
      log.info("Preloading " + repository.save(new Account("Bilbo", "Baggins", 40000)));
      log.info("Preloading " + repository.save(new Account("Frodo", "Baggins", 2000)));
    };
  }
}