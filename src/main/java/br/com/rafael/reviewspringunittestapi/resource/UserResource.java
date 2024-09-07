package br.com.rafael.reviewspringunittestapi.resource;

import br.com.rafael.reviewspringunittestapi.domain.dto.UserDTO;
import br.com.rafael.reviewspringunittestapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        var users = this.userService.findAll().stream().map(x -> mapper.map(x, UserDTO.class)).toList();

        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody  UserDTO obj) {
        var newObj = this.userService.create(obj);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}").buildAndExpand(newObj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable  Integer id, @RequestBody UserDTO obj) {
        obj.setId(id);
        var user = mapper.map(this.userService.update(obj), UserDTO.class);

        return ResponseEntity.ok().body(user);
    }
}
