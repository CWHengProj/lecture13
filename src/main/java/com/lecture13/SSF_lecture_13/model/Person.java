package com.lecture13.SSF_lecture_13.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    //variables
    @NotNull(message = "ID must be auto generated")
    private String id;
    @NotEmpty(message="First name is mandatory")
    @Size(min=5, max=60, message = "First Name must be between 5 to 60 characters.")
    private String firstName;
    @NotEmpty(message="Last name is mandatory")
    @Size(min=5, max=60, message = "Last Name must be between 5 to 60 characters.")
    private String lastName;
    @Min(value = 1500, message = "Minimum salary starts from 1500")
    @Max(value = 50000, message = "Maximum salary is 50000")
    private Integer salary;
    @Email(message = "Email input does not conform to email format.")
    @NotBlank(message = "Email is mandatory.")
    private String email;
    @Past(message = "Your date of birth should be before today.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    //constructor method
    public Person(String firstName, String lastName, String email, Integer salary, Date birthday){
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.dateOfBirth = birthday;
    }

}
