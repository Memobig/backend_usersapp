package com.guiram.backend.usersapp.backend_usersapp.models.dto.mapper;

import com.guiram.backend.usersapp.backend_usersapp.models.dto.UserDto;
import com.guiram.backend.usersapp.backend_usersapp.models.entities.User;

public class DtoMapperUser {

    private User user;

    private DtoMapperUser(){

    }
    public static DtoMapperUser getInstance(){
        return new DtoMapperUser();
    }

    public DtoMapperUser setUser(User user){
        this.user = user;
        return this;
    }

    public UserDto build(){
        return new UserDto(this.user.getId(), this.user.getUsername(),this.user.getEmail());
    }
}
