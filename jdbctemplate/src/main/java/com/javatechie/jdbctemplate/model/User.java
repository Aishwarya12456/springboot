package com.javatechie.jdbctemplate.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class User {

//    @NotNull(message = "Please enter the fullname")
//    @NotEmpty(message = "Please enter the fullname")
    @NotBlank(message = "Please enter the fullname")
    private String fullName;
    @NotBlank(message = "Please enter the Email")
    @Email(message="please enter valid email adress")
    private String email;
    private String password;
    private String gender;
    private String hobbies;
    private String dob;
    private String country;
    @Min(value=10,message="mobile number must be 10-digit")
    @Max(value=10,message="mobile number must be 10-digit")
    private String phone;
}
