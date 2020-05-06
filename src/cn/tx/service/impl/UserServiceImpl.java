package cn.tx.service.impl;

import cn.tx.dao.UserDao;
import cn.tx.dao.impl.UserDaoImpl;
import cn.tx.model.User;
import cn.tx.service.UserService;
import cn.tx.utils.MD5Utils;

/**
 * @author Administrator
 * @title: UserServiceImpl
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2621:32
 */
public class UserServiceImpl implements UserService {
    // 注入一个Dao对象
    UserDao userDao = new UserDaoImpl();
    @Override
    public User getUser(String username, String password) {
        // 把密码进行md5加密
        password = MD5Utils.encrypt(password);
        return userDao.getUser(username,password);
    }
}
