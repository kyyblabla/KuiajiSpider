/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.data.dao.impl;

import com.fml.spider.kuaiji.data.DataSource;
import com.fml.spider.kuaiji.data.dao.UserDao;
import com.fml.spider.kuaiji.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ky
 */
public class UserDaoImpl implements UserDao {

    private DataSource ds;

    public UserDaoImpl() {

        this.ds = new DataSource();

    }

    @Override
    public List<User> getUsers() {

        List<User> users = new ArrayList<>();
        try {
            List<String> readers = ds.reader();

            for (String reader : readers) {
                User u = new User(reader);
                users.add(u);
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;

    }

    @Override
    public boolean setUsers(List<User> users) {

        try {
            String lines[] = new String[users.size()];

            int i = 0;
            for (User u : users) {

                String line = u.toString();
                lines[i++] = line;
            }

            ds.writer(lines);

            return true;

        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("kyy1#123#412828#1"));
        users.add(new User("kyy2#123#412828#1"));
        users.add(new User("kyy3#123#412828#1"));

        new UserDaoImpl().setUsers(users);

    }

}
