package cn.tx.dao.impl;

import cn.tx.dao.EmpDao;
import cn.tx.model.District;
import cn.tx.model.Emp;
import cn.tx.model.User;
import cn.tx.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @title: EmpDaoImpl
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2821:16
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Emp> listEmps(Map<String, Object> params) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        // 创建一个集合
        List<Emp> list =  new ArrayList<>();
        try{
            // 获取数据库链接
            conn = JdbcUtils.getConnection();
            // sql语句
            String sql = "SELECT * FROM t_emp e LEFT JOIN t_district d ON e.districtid=d.id where 1=1 ";
            // 判断前台是否传递qename
            if(params.get("qename") != null && !params.get("qename").equals("")){
                sql += " and e.ename LIKE '%"+params.get("qename")+"%'";
            }
            // 判断前台是否传递districtid
            if(params.get("qdistrict") != null && !params.get("qdistrict").equals("")){
                sql += " and e.districtid = " + params.get("qdistrict");
            }
            sql += " limit " + params.get("start") + "," + params.get("pageSize");
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()){
               Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),
                       rs.getInt(4),rs.getDouble(5),rs.getDate(6),
                       rs.getDate(7),rs.getInt(8));
               District district = new District(rs.getInt(9),rs.getInt(10),rs.getString(11),rs.getInt(12));
               emp.setDistrict(district);
               list.add(emp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,statement,rs);
        }
        return list;
    }

    @Override
    public Integer countEmps(Map<String, Object> params) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        // 创建一个结果
        Integer count = 0;
        try{
            // 获取数据库链接
            conn = JdbcUtils.getConnection();
            // sql语句
            String sql = "SELECT count(1) FROM t_emp e where 1=1 ";
            // 判断前台是否传递qename
            if(params.get("qename") != null && !params.get("qename").equals("")){
                sql += " and e.ename LIKE '%"+params.get("qename")+"%'";
            }
            // 判断前台是否传递districtid
            if(params.get("qdistrict") != null && !params.get("qdistrict").equals("")){
                sql += " and e.districtid = " + params.get("qdistrict");
            }

            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            if(rs.next()){
                count = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,statement,rs);
        }
        return count;
    }

    @Override
    public void saveEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            // 获取数据库链接
            conn = JdbcUtils.getConnection();
            // sql语句
            String sql = "INSERT INTO `t_emp` (`ename`, `age`, `sex`, `sal`, `birthday`, `edate`, `districtid`) VALUES (?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,emp.getEname());
            ps.setInt(2,emp.getAge());
            ps.setInt(3,emp.getSex());
            ps.setDouble(4,emp.getSal());
            ps.setDate(5,new java.sql.Date(emp.getBirthday().getTime()));
            ps.setDate(6,new java.sql.Date(emp.getEdate().getTime()));
            ps.setInt(7,emp.getDistrictId());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public Emp getEmpById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // 创建一个user对象
        Emp emp = null;
        try{
            // 获取数据库链接
            conn = JdbcUtils.getConnection();
            // sql语句
            String sql = "SELECT * FROM t_emp where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                // 如果存在结果集 则拼装Emp对象
                emp = new Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),
                        rs.getInt(4),rs.getDouble(5),rs.getDate(6),
                        rs.getDate(7),rs.getInt(8));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps,rs);
        }
        return emp;
    }

    @Override
    public void updateEmp(Emp emp) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            // 获取数据库链接
            conn = JdbcUtils.getConnection();
            // sql语句
            String sql = "UPDATE `t_emp` SET `ename`=?, `age`=?, `sex`=?, `sal`=?, `birthday`=?, `edate`=?, `districtid`=? WHERE (`id`=?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,emp.getEname());
            ps.setInt(2,emp.getAge());
            ps.setInt(3,emp.getSex());
            ps.setDouble(4,emp.getSal());
            ps.setDate(5,new java.sql.Date(emp.getBirthday().getTime()));
            ps.setDate(6,new java.sql.Date(emp.getEdate().getTime()));
            ps.setInt(7,emp.getDistrictId());
            ps.setInt(8,emp.getId());
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }

    @Override
    public void delEmp(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            // 获取数据库链接
            conn = JdbcUtils.getConnection();
            // sql语句
            String sql = "DELETE  FROM t_emp where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn,ps);
        }
    }
}
