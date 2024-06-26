package com.guiram.backend.usersapp.backend_usersapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.guiram.backend.usersapp.backend_usersapp.models.entities.Role;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
