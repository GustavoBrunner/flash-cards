package com.biblioteca.flash_cards.service;

import com.biblioteca.flash_cards.dto.UserDTO;
import com.biblioteca.flash_cards.entity.User;
import com.biblioteca.flash_cards.exceptions.EmailAlreadyInUseException;
import com.biblioteca.flash_cards.exceptions.UserNotFoundException;
import com.biblioteca.flash_cards.exceptions.UsernameAlreadyInUseException;
import com.biblioteca.flash_cards.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException();
        }
        return user;
    }

    public String createUser(UserDTO data){
        if(userRepository.findByEmail(data.email()) != null) throw new EmailAlreadyInUseException();
        if(userRepository.findByUsername(data.username()) != null) throw new UsernameAlreadyInUseException();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data);
        newUser.setPassword(encryptedPassword);
        userRepository.save(newUser);
        return "Usuário criado com sucesso";
    }

    public String updateUser(UserDTO data){
        User user = userRepository.getReferenceById(data.id());
        if(!user.getEmail().equals(data.email()) && userRepository.findByEmail(data.email()) != null){
            throw new EmailAlreadyInUseException();
        }
        user.setEmail(data.email());
        if(!user.getUsername().equals(data.username()) && userRepository.findByUsername(data.username()) != null){
            throw new UsernameAlreadyInUseException();
        }
        user.setUsername(data.username());
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return "Usuário atualizado com sucesso";
    }

    public String deleteUser(Long id){
        User user = userRepository.getReferenceById(id);
        userRepository.delete(user);
        return "Usuário deletado com sucesso";
    }
}
