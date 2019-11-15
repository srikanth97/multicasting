package com.stackroute.multicasting.controller;


import com.stackroute.multicasting.domain.Group;
import com.stackroute.multicasting.domain.Message;
import com.stackroute.multicasting.domain.User;
import com.stackroute.multicasting.repository.GroupInterface;
import com.stackroute.multicasting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MessageController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private GroupInterface groupInterface;

    @MessageMapping("/chat.sendMessage/{fromName}/{toName}")
    @SendTo("/message/{toName}")
    public Message sendMessage(@DestinationVariable String fromName,@DestinationVariable String toName,@Payload Message message){
        return message;
    }

    @MessageMapping("/chat.groupMessage/{groupName}")
    public void groupMessage(@DestinationVariable String groupName,@Payload Message message){
        List<String> users = groupInterface.findUserInGroup(groupName);
        System.out.println(users);
        for(String user:users){
            template.convertAndSend("/message/"+user, message);
        }
    }

    @MessageMapping("/chat.newGroup/{groupName}")
    public void createGroup(@Payload String userName, @DestinationVariable String groupName){
        groupInterface.save(new Group(new Random().nextInt(100), groupName, userName));
        template.convertAndSend("/message/allGroups",groupInterface.distinctGroup().toArray());
        template.convertAndSend("/message/groupList/"+userName,groupInterface.distinctGroupForUser(userName).toArray());
        return;
    }
    @MessageMapping("/chat.newUser")
    @SendTo("/message/users")
    public List<User> addUser(@Payload String name){
        userRepository.save(new User(name));
        List<User> user = new ArrayList<>();
        userRepository.findAll().forEach(user::add);
        template.convertAndSend("/message/allGroups",groupInterface.distinctGroup().toArray());
        template.convertAndSend("/message/groupList/"+name,groupInterface.distinctGroupForUser(name).toArray());
        return user;
    }
}
