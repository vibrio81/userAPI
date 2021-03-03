package com.tts.userAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class UserV1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The Long id is the users identification number")
    private Long Id;
    @ApiModelProperty(notes = "The first name is the users given name")
    @NotEmpty(message = "Please provide a firstname")
    @Length(max = 20, message = "Your firstname cannot have more than 20 characters")
    private String firstname;

    @ApiModelProperty(notes = "The last name is the users surname")
    @NotEmpty(message = "Please provide a lastname")
    @Length(min = 2, message = "Your lastname must have at least 2 characters")
    private String lastname;

    @ApiModelProperty(notes = "The state is the users state of residence")
    @NotEmpty(message = "Please provide a state")
    @Length(min = 4, message = "Your State must have at least 4 characters")
    @Length(max = 20, message = "Your State cannot have more than 20 characters")
    private String state;
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public UserV1(String firstname, String lastname, String state) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.state = state;
//    }
//
//    public UserV1(){
//
//    }
}
