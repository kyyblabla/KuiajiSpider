/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji;

import com.fml.spider.kuaiji.data.server.UserServer;
import com.fml.spider.kuaiji.data.server.impl.UserServerImpl;
import com.fml.spider.kuaiji.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ky
 */
public abstract class UserManager {

    private UserServer server = null;

    private List<User> userList;

    public UserManager() {

        server = new UserServerImpl();
        userList = new ArrayList<>();

    }

    public void work() {

        initUserList();

    }

    private void initUserList() {

        userList = server.getUsers();
        onUserListUpdata();
    }

    public boolean addUser(User user) {

        boolean add = false;

        synchronized (this) {

            User u = checkUser(user.getCardCode());
            if (u == null) {
                userList.add(user);
                server.setUsers(userList);
                onUserListUpdata();
                add = true;
            }

        }

        return add;

    }

    public void updateUser(User user) {

        synchronized (this) {
            User u = checkUser(user.getCardCode());
            u = user;
            server.setUsers(userList);
            onUserListUpdata();
        }

    }

    private User getAnUser() {

        for (User user : userList) {

            if (user.isSuccess() == false) {
                return user;
            }
        }

        return null;

    }

    public User checkUser(String card) {

        for (User auser : userList) {

            if (auser.getCardCode().equals(card)) {
                return auser;
            }
        }

        return null;

    }

    public List<User> getUserList() {
        return userList;
    }

    public abstract void onUserListUpdata();

}
