package com.guiram.backend.usersapp.backend_usersapp.models.dto;

public class UserDto {
    private Long id;
    private String username;
    private String email;

    public UserDto(Long id, String username, String email) {
        this.username = username;
        this.id = id;
        this.email = email;
    }
    public UserDto() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
