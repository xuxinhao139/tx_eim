package cn.tx.servlet;

import cn.tx.model.Emp;
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
 * @date 2019/6/2822:18
 */
public class EmpUpdateuiServlet extends HttpServlet {
    EmpService empService = new EmpServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        // 根据员工id获取员工信息
        Emp emp = empService.getEmpById(id);
        // 跳转到更新页面
        request.setAttribute("emp",emp);
        request.getRequestDispatcher("pages/empupdate.jsp").forward(request,response);
    }
}
