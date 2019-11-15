package com.stackroute.multicasting.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class User {
    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    //    @Id
//    private  int id;
//    private  String firstName;
//    private  String lastName;
//    private  String emailId;
//    private  String departmentId;
//    private  String profilePic;
//    private  int teamId;

}
