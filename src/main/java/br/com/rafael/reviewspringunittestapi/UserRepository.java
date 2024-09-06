package br.com.rafael.reviewspringunittestapi;

import br.com.rafael.reviewspringunittestapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
