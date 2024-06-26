package com.guiram.backend.usersapp.backend_usersapp.services;

import java.util.List;
import java.util.Optional;

import com.guiram.backend.usersapp.backend_usersapp.models.dto.UserDto;
import com.guiram.backend.usersapp.backend_usersapp.models.entities.User;
import com.guiram.backend.usersapp.backend_usersapp.models.request.UserRequest;

public interface UserService {

    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);

    UserDto save(User user);

    Optional<UserDto> update(UserRequest user, Long id);

    void remove(Long id);
}
