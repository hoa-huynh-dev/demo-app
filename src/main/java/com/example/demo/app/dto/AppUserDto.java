package com.example.demo.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppUserDto {
    private long id;
    private String username;
    private String password;
    private String role;
}
