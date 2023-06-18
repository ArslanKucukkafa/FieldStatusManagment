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
import org.springframework.stereotype.Service;

@Service
public class userService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    public ResponseEntity saveUser(userDto userdto){
        return new ResponseEntity(userRepository.save(userdto.matchUserDto(userdto)), HttpStatus.OK);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException(email);
        }
        return new userDtoImpl(user);
    }
}
