package com.guiram.backend.usersapp.backend_usersapp.models.dto.mapper;

import com.guiram.backend.usersapp.backend_usersapp.models.dto.UserDto;
import com.guiram.backend.usersapp.backend_usersapp.models.entities.User;

public class DtoMapperUser {

    private static DtoMapperUser mapper;

    private User user;

    private DtoMapperUser(){

    }
    public static DtoMapperUser getInstance(){
        mapper = new DtoMapperUser();
        return mapper;
    }

    public DtoMapperUser setUser(User user){
        this.user = user;
        return mapper;
    }

    public UserDto build(){
        return new UserDto(this.user.getId(), this.user.getUsername(),this.user.getEmail());
    }
}
