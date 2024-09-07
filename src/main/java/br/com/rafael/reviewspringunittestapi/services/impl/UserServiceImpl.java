package br.com.rafael.reviewspringunittestapi.services.impl;

import br.com.rafael.reviewspringunittestapi.UserRepository;
import br.com.rafael.reviewspringunittestapi.domain.User;
import br.com.rafael.reviewspringunittestapi.domain.dto.UserDTO;
import br.com.rafael.reviewspringunittestapi.services.UserService;
import br.com.rafael.reviewspringunittestapi.services.exception.DataIntegrateViolationException;
import br.com.rafael.reviewspringunittestapi.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Resource not found"));
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        var user = mapper.map(obj, User.class);

        return this.repository.save(user);
    }

    @Override
    public User update(UserDTO obj) {
        getEmail(obj);
        var user = mapper.map(obj, User.class);

        return this.repository.save(user);
    }

    private void findByEmail(UserDTO obj) {
         Optional<User> user = this.repository.findByEmail(obj.getEmail());

         if (user.isPresent() && !user.get().getId().equals(obj.getId())) {
             throw new DataIntegrateViolationException("E-mail already exists at system");
         }
    }

    private void getEmail(UserDTO obj) {
        findByEmail(obj);
    }

}
