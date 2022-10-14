package com.ct.service;

import com.ct.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
public class UserService implements IService<User>{


    @Override
    public User getById() {

        return new User("chentao",20);
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
