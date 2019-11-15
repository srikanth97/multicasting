package com.stackroute.multicasting.repository;

import com.stackroute.multicasting.domain.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,String> {}

