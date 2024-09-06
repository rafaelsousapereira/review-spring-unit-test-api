package br.com.rafael.reviewspringunittestapi.services.impl;

import br.com.rafael.reviewspringunittestapi.UserRepository;
import br.com.rafael.reviewspringunittestapi.domain.User;
import br.com.rafael.reviewspringunittestapi.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
