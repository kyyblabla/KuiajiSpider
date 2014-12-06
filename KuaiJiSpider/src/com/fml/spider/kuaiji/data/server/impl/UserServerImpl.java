/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.data.server.impl;

import com.fml.spider.kuaiji.data.dao.UserDao;
import com.fml.spider.kuaiji.data.dao.impl.UserDaoImpl;
import com.fml.spider.kuaiji.data.server.UserServer;
import com.fml.spider.kuaiji.model.User;
import java.util.List;

/**
 *
 * @author ky
 */
public class UserServerImpl implements UserServer {

    private UserDao userDao;

    public UserServerImpl() {

        userDao = new UserDaoImpl();

    }

    @Override
    public List<User> getUsers() {

        return userDao.getUsers();

    }

    @Override
    public boolean setUsers(List<User> users) {

        return userDao.setUsers(users);

    }

}
