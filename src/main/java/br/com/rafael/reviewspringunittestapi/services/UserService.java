package br.com.rafael.reviewspringunittestapi.services;

import br.com.rafael.reviewspringunittestapi.domain.User;

public interface UserService {

    User findById(Integer id);
}
