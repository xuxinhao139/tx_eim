package cn.tx.dao;

import cn.tx.model.Emp;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @title: EmpDao
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2821:15
 */
public interface EmpDao {

    List<Emp> listEmps(Map<String,Object> params);

    Integer countEmps(Map<String,Object> params);

    void saveEmp(Emp emp);

    Emp getEmpById(int id);

    void updateEmp(Emp emp);

    void delEmp(Integer id);
}
