package com.guiram.backend.usersapp.backend_usersapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guiram.backend.usersapp.backend_usersapp.models.dto.UserDto;
import com.guiram.backend.usersapp.backend_usersapp.models.dto.mapper.DtoMapperUser;
import com.guiram.backend.usersapp.backend_usersapp.models.entities.Role;
import com.guiram.backend.usersapp.backend_usersapp.models.entities.User;
import com.guiram.backend.usersapp.backend_usersapp.models.request.UserRequest;
import com.guiram.backend.usersapp.backend_usersapp.repositories.RoleRepository;
import com.guiram.backend.usersapp.backend_usersapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAll() {

        List<User> users = (List<User>) repository.findAll();
        return users
        .stream()
        .map(u -> DtoMapperUser.getInstance().setUser(u).build())
        .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> findById(Long id) {
        Optional<User> o = repository.findById(id);
        if (o.isPresent()) {
            return Optional.of(
                DtoMapperUser.getInstance().setUser(o.orElseThrow()).build()
            );
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public UserDto save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<Role> o = roleRepository.findByName("ROLE_USER");

        List<Role> roles = new ArrayList<>();

        if (o.isPresent()) {
            roles.add(o.orElseThrow());
        }
        user.setRoles(roles);
        
        return DtoMapperUser.getInstance().setUser(repository.save(user)).build() ;
    }

    @Override
    @Transactional
    public Optional<UserDto> update(UserRequest user, Long id) {
        Optional<User> o = repository.findById(id);
        if (o.isPresent()) {
            User dbUser = o.orElseThrow();
            dbUser.setUsername(user.getUsername());
            dbUser.setEmail(user.getEmail());
            return Optional.ofNullable(DtoMapperUser.getInstance().setUser(repository.save(dbUser)).build());
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
