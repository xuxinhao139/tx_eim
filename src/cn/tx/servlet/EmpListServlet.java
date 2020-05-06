package cn.tx.servlet;

import cn.tx.model.Emp;
import cn.tx.service.EmpService;
import cn.tx.service.impl.EmpServiceImpl;
import cn.tx.utils.Page;
import cn.tx.utils.TxBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @title: ${NAME}
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2820:09
 */
public class EmpListServlet extends HttpServlet {
    EmpService empService = new EmpServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取浏览器传递的所有参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 参数列表
        Map<String,Object> params = new HashMap<>();
        TxBeanUtils.copyProperties(params,parameterMap);
        // 调用service 获取分页对象
        Page<Emp> page = empService.listEmps(params);
        // 向request作用域内存入数据
        request.setAttribute("page",page);
        request.setAttribute("district",params.get("qdistrict"));
        request.setAttribute("ename",params.get("qename"));

        // 跳转页面
        request.getRequestDispatcher("pages/emplist.jsp").forward(request,response);
    }
}
