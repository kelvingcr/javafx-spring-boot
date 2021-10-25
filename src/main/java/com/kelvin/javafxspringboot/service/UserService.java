package com.kelvin.javafxspringboot.service;

import com.kelvin.javafxspringboot.controller.SimpleUiController;
import com.kelvin.javafxspringboot.entity.User;
import com.kelvin.javafxspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    SimpleUiController c1;

    public void authenticate(String username, String password) {
        User obj = userRepository.findByUsername(username);

        if(obj != null) {
            if(obj.getPassword().equalsIgnoreCase(password)){
                c1.textUserExist.setVisible(false);
                c1.btnSucessAdd.setText("SUCCESS! CONNECTED");
                c1.btnSucessAdd.setVisible(true);
            }else{
                c1.textUserExist.setText("Username or password invalid.");
                c1.textUserExist.setVisible(true);
            }
        }else{
            c1.textUserExist.setText("Username or password invalid.");
            c1.textUserExist.setVisible(true);
        }
    }

    public void create(String firstname, String lastname, String username, String password){
        User obj = userRepository.findByUsername(username);

        if(obj == null) {
            User user = new User(null, firstname, lastname, username, password);
            userRepository.save(user);
            c1.btnSucessAdd.setVisible(true);
            c1.textAlertR.setVisible(false);
            c1.btnSucessAdd.setText("SUCCESS! ADDED USER");
        }else{
            c1.textAlertR.setText("User already exists");
            c1.textAlertR.setVisible(true);
        }
    }

}
