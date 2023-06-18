package com.example.tarlascraping1.ModelsDTO;

import com.example.tarlascraping1.Models.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userDto {
    private String name;
    private String surname;
    private String email;
    private String password;

    public User matchUserDto (userDto userdto){
        User user = new User();
        user.setName(userdto.getName());
        user.setSurname(userdto.getSurname());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        return user;
    }
}
