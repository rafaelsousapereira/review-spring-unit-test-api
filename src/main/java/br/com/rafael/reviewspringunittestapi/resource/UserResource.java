package br.com.rafael.reviewspringunittestapi.resource;

import br.com.rafael.reviewspringunittestapi.domain.dto.UserDTO;
import br.com.rafael.reviewspringunittestapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserResource {

    private final ModelMapper mapper;
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        var user = this.userService.findById(id);
        var result = mapper.map(user, UserDTO.class);

        return ResponseEntity.ok().body(result);
    }
}
