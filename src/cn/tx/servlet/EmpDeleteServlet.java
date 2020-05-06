package cn.tx.servlet;

import cn.tx.service.EmpService;
import cn.tx.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Administrator
 * @title: ${NAME}
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2822:39
 */
public class EmpDeleteServlet extends HttpServlet {

    EmpService empService = new EmpServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        Integer id = Integer.parseInt(sid);
        // 调用service删除员工
        empService.delEmp(id);
        // 跳转回列表页面
        response.sendRedirect("empListServlet?pageCode=1&pageSize=5");
    }
}
