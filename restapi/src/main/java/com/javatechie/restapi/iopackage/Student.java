//package com.javatechie.restapi.iopackage;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Student {
//    private Integer id;
//    @NotBlank(message="Name is required")
//    private String name;
//    @Email(message="email is not valid")
//    private String email;
//    @NotNull(message="dob is not valid")
//    private Date dob;
//
//}
//
package com.javatechie.restapi.iopackage;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="tbl_students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message="name is required")
    private String name;
    @NotNull(message="date of birth is required")
    private LocalDate dob;
}

