package com.biblioteca.flash_cards.controller;

import com.biblioteca.flash_cards.dto.UserDTO;
import com.biblioteca.flash_cards.entity.User;
import com.biblioteca.flash_cards.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        Optional<User> user = service.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO data){
        String response = service.createUser(data);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody @Valid UserDTO data){
        String response = service.updateUser(data);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        String response = service.deleteUser(id);
        return ResponseEntity.ok().body(response);
    }

}
