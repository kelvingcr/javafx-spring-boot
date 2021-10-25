package com.kelvin.javafxspringboot.dto;

import com.kelvin.javafxspringboot.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends User {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;

    public UserDTO(User users) {
        this.id = users.getId();
        this.username = users.getUsername();
        this.firstName = users.getFirstName();
        this.lastName = users.getLastName();
    }

}
