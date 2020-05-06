package cn.tx.dao;

import cn.tx.model.User;

/**
 * @author Administrator
 * @title: UserDao
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2621:36
 */
public interface UserDao {
    /**
     * 根据用户名和密码获取用户
     * @param username
     * @param password
     * @return
     */
    User getUser(String username,String password);
}
