package cn.tx.service;

import cn.tx.model.Emp;
import cn.tx.utils.Page;

import java.util.Map;

/**
 * @author Administrator
 * @title: EmpService
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2821:08
 */
public interface EmpService {

    Page<Emp> listEmps(Map<String,Object> params);

    void saveEmp(Emp emp);

    Emp getEmpById(int id);

    void delEmp(Integer id);
}
