package com.example.auth_service.services;




import com.example.auth_service.dto.UserCreate;
import com.example.auth_service.dto.UserUpdate;
import com.example.auth_service.dto.UserView;
import com.example.auth_service.mapper.UserMapper;
import com.example.auth_service.models.Role;
import com.example.auth_service.models.User;
import com.example.auth_service.repositories.RoleRepository;
import com.example.auth_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =userRepository.findByEmail(email );
        if(user==null){
            throw new UsernameNotFoundException("USER NOT FOUND!");
        }
        return user;
    }

    public UserView addUser(UserCreate userCreate){
        User checkUser =userRepository.findByEmail(userCreate.getEmail());
        if(checkUser!=null)
            return null;
        if(!userCreate.getPassword().equals(userCreate.getRePassword()))
            return null;
        User user = UserMapper.INSTANCE.toEntity(userCreate);
        user.setPassword(passwordEncoder.encode(userCreate.getRePassword()));
        Role role=roleRepository.findRoleUser();
        user.setRoles(List.of(role));
        return UserMapper.INSTANCE.toView(userRepository.save(user));
    }

    public User getCurrentUser(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof AnonymousAuthenticationToken)
            return null;
        return (User) authentication.getPrincipal();
    }

    public User editUser(UserUpdate userUpdate){
        User currentUser =getCurrentUser();
        if(!passwordEncoder.matches(userUpdate.getPassword(),currentUser.getPassword())){
            return null;
        }
        if(!userUpdate.getNewPassword().equals(userUpdate.getReNewPassword())){
            return null;
        }
        User user = UserMapper.INSTANCE.toEntity(userUpdate);
        user.setPassword(passwordEncoder.encode(userUpdate.getNewPassword()));
        return userRepository.save(user);
    }


    public UserView getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        UserView userView = UserMapper.INSTANCE.toView(user);
        return userView;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}