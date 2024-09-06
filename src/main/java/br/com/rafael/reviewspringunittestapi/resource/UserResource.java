package br.com.rafael.reviewspringunittestapi.resource;

import br.com.rafael.reviewspringunittestapi.domain.User;
import br.com.rafael.reviewspringunittestapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserResource {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        var result = this.userService.findById(id);

        return ResponseEntity.ok().body(result);
    }
}
