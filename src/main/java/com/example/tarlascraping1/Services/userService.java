package com.example.tarlascraping1.Services;

import com.example.tarlascraping1.Models.user.User;
import com.example.tarlascraping1.ModelsDTO.userDto;
import com.example.tarlascraping1.ModelsDTO.userDtoImpl;
import com.example.tarlascraping1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userService implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    public String saveUser(userDto userdto){
        Optional<User> user = getUsersEmail(userdto.getEmail());
        if(user.isPresent()){
            if(user.get().isEnabled()){
                return "User already exists";
            }
        }
        userdto.setPassword(encoder.encode(userdto.getPassword()));
        userRepository.save(userdto.matchUserDto(userdto));
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = getUsersEmail(email);
        if(!user.isPresent()){
            throw new UsernameNotFoundException(email);
        }
        return new userDtoImpl(user.get());
    }

    public Optional<User> getUsersEmail(String email){
        return userRepository.findByEmail(email);
    }
}
