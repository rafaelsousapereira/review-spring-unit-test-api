package br.com.rafael.reviewspringunittestapi.services;

import br.com.rafael.reviewspringunittestapi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
