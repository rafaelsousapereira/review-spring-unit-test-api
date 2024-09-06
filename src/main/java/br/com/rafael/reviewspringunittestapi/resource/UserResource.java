package br.com.rafael.reviewspringunittestapi.resource;

import br.com.rafael.reviewspringunittestapi.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {

        return ResponseEntity.ok().body(new User(1, "Rafael Sousa", "rafael", "rafael.sousa@gmail.com", "p123"));
    }
}
