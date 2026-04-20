package com.login.login.service;

import com.login.login.model.User;
import com.login.login.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User cadastrar(User user){
        repository.save(user);
        return user;
    }

    public User login(User user){
        String username = user.getUsername();
        Optional<User>  userBanco =repository.findByUsername(username);
        if(userBanco.isPresent()){
            if(user.getSenha()  == userBanco.get().getSenha()){
                System.out.println("Usuário autorizado com sucesso.");
            }
        }else{
            System.out.println("A caixa está vazia. Usuário não existe," +
                    "Favor fazer o cadastro.");
        }

        return user;
    }
}
