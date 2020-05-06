package cn.tx.servlet;

import cn.tx.model.Emp;
import cn.tx.service.EmpService;
import cn.tx.service.impl.EmpServiceImpl;
import cn.tx.utils.TxBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Administrator
 * @title: ${NAME}
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2821:49
 */
public class EmpAddServlet extends HttpServlet {
    EmpService empService = new EmpServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先获取所有前台传递的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 创建一个接收参数的emp对象
        Emp emp = new Emp();
        // 把参数复制进emp对象
        TxBeanUtils.copyProperties(emp,parameterMap);
        // 调用EmpService方法存入数据
        empService.saveEmp(emp);
        // 返回查询页面
        response.sendRedirect("empListServlet?pageCode=1&pageSize=5");
    }
}
