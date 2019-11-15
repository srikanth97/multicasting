package com.stackroute.multicasting.repository;

import com.stackroute.multicasting.domain.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupInterface extends CrudRepository<Group, Integer> {

    @Query("SELECT DISTINCT groupName from Group where userName = :name")
    public List<String> distinctGroupForUser(@Param("name") String username);

    @Query("SELECT DISTINCT groupName from Group")
    public List<String> distinctGroup();

    @Query("SELECT userName from Group where groupName= :name")
    public List<String> findUserInGroup(@Param("name") String name);
}
