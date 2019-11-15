package com.stackroute.multicasting.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "groupUsers")
public class Group {


    @Id
    private int id;
    private String groupName;
//    private int admin_Id;
    private String userName;

    public Group() {
    }

    public Group(int id, String groupName, String userName) {
        this.id = id;
        this.groupName = groupName;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
