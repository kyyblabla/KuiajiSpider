/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.data.server;

import com.fml.spider.kuaiji.model.User;
import java.util.List;

/**
 *
 * @author ky
 */
public interface UserServer {

    public List<User> getUsers();

    public boolean setUsers(List<User>users);

}
