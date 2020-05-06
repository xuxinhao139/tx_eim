package cn.tx.dao.impl;

import cn.tx.dao.UserDao;
import cn.tx.model.User;
import cn.tx.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator
 * @title: UserDaoImpl
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2621:37
 */
public class UserDaoImpl implements UserDao{
    @Override
    public User getUser(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 创建一个user对象
        User user = null;
        try{
            // 获取数据库链接
            conn = JdbcUtils.getConnection();
            // sql语句
            String sql = "SELECT * FROM t_user where username=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                // 如果存在结果集 则拼装user对象
                user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return user;
    }
}
