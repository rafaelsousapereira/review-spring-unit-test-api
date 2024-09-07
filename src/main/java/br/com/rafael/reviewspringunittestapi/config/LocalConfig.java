package br.com.rafael.reviewspringunittestapi.config;

import br.com.rafael.reviewspringunittestapi.UserRepository;
import br.com.rafael.reviewspringunittestapi.domain.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@RequiredArgsConstructor
@Configuration
@Profile("local")
public class LocalConfig {

    private final UserRepository repository;

    @PostConstruct
    public void startDB() {
        var user1 = new User(null, "Rafael", "rafael", "rafael@gmail.com", "p123");
        var user2 = new User(null, "Sousa", "sousa", "sousa@gmail.com", "p321");

        this.repository.saveAll(List.of(user1, user2));
    }
}
