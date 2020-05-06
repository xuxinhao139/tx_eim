package cn.tx.service.impl;

import cn.tx.dao.EmpDao;
import cn.tx.dao.impl.EmpDaoImpl;
import cn.tx.model.Emp;
import cn.tx.service.EmpService;
import cn.tx.utils.Page;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @title: EmpServiceImpl
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2821:08
 */
public class EmpServiceImpl implements EmpService {
    EmpDao empDao = new EmpDaoImpl();
    @Override
    public Page<Emp> listEmps(Map<String, Object> params) {
        // 获取页码
        Integer pageCode = Integer.parseInt(params.get("pageCode").toString());
        // 获取分页大小
        Integer pageSize = Integer.parseInt(params.get("pageSize").toString());
        // 计算分页起始位置
        Integer start = (pageCode -1)*pageSize;
        params.put("start",start);
        // 获取所有符合条件的员工数量
        Integer count  = empDao.countEmps(params);
        // 获取所有符合条件的员工列表
        List<Emp> emps = empDao.listEmps(params);
        // 封装Page对象
        Page<Emp> page = new Page<>(pageCode,count,pageSize,emps);
        return page;
    }

    @Override
    public void saveEmp(Emp emp) {
        // 参数内无id者表示 新增
        if(emp.getId() == null){
            empDao.saveEmp(emp);
        }else{
            // 参数内有id者 表示修改
            empDao.updateEmp(emp);
        }
    }

    @Override
    public Emp getEmpById(int id) {
        return empDao.getEmpById(id);
    }

    @Override
    public void delEmp(Integer id) {
        empDao.delEmp(id);
    }
}
