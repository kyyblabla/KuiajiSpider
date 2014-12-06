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
    private static final String PATH = "E:/kuaji/tets.txt";

    public UserDaoImpl() {

        this.ds = new DataSource();

    }

    @Override
    public List<User> getUsers() {

//        String userName;
//        String passWord;
//        String cityCode;
//        boolean success = false;
        List<User> users = new ArrayList<>();
        try {
            List<String> readers = ds.reader(PATH);

            for (String reader : readers) {

                String[] split = reader.split("#");
                User u = new User(split[0], split[1], split[2], split[3].equals("1"));

            }

        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;

    }

    @Override
    public boolean setUsers(List<User> users) {

        try {
            List<String> lines = new ArrayList<>();

            for (User u : users) {

                String line = u.getUserName() + "#" + u.getPassWord() + "#" + u.getUserName() + "#" + (u.isSuccess() ? "1" : "0");
                lines.add(line);
            }

            ds.writer(PATH, (String[]) lines.toArray());

            return true;

        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static void main(String[] args) {

    }

}
