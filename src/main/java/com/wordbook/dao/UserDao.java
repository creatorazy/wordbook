package com.wordbook.dao;

import com.wordbook.entity.User;

public interface UserDao extends BaseDao<User> {
    User loginByPassword(User user);
}
