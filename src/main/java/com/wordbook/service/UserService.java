package com.wordbook.service;

import com.wordbook.dao.UserDao;
import com.wordbook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao ud;

    public User loginByPassword(User user) {
        return ud.loginByPassword(user);
    }

    public boolean reg(User user) {
        return ud.insert(user) > 0;
    }

    public boolean up(User user){
        return ud.update(user)>0;
    }
}
