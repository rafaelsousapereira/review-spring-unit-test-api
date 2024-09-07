package br.com.rafael.reviewspringunittestapi.services.impl;

import br.com.rafael.reviewspringunittestapi.UserRepository;
import br.com.rafael.reviewspringunittestapi.domain.User;
import br.com.rafael.reviewspringunittestapi.services.UserService;
import br.com.rafael.reviewspringunittestapi.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Resource not found"));
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

}
