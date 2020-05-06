package cn.tx.service;

import cn.tx.model.User;

/**
 * @author Administrator
 * @title: UserService
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2621:25
 */
public interface UserService {
    /**
     * 根据前台传递的参数 获取用户  如果获取不到 则返回null
     * @param username
     * @param password
     * @return
     */
    User getUser(String username,String password);
}
