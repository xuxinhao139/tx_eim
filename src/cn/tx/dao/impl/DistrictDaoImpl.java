package cn.tx.dao.impl;

import cn.tx.dao.DistrictDao;
import cn.tx.model.District;
import cn.tx.model.User;
import cn.tx.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @title: DistrictDaoImpl
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2820:19
 */
public class DistrictDaoImpl implements DistrictDao {
    @Override
    public List<District> listDistricts() {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        // 创建一个集合
        List<District> list =  new ArrayList<>();
        try{
            // 获取数据库链接
            conn = JdbcUtils.getConnection();
            // sql语句
            String sql = "select * FROM t_district where pid=1";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
                District district = new District(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4));
                list.add(district);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,statement,rs);
        }
        return list;
    }
}
