package cn.tx.servlet;

import cn.tx.model.User;
import cn.tx.service.UserService;
import cn.tx.service.impl.UserServiceImpl;

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
 * @date 2019/6/2621:21
 */
public class UserLoginServlet extends HttpServlet {
    // 注入一个UserService对象
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取前台传递的用户名和密码参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 校验用户名和密码
        User user = userService.getUser(username, password);
        // 用户存在
        if(user != null){
            // 把用户存入session
            request.getSession().setAttribute("user",user);
            // 跳转到后台管理页面
            request.getRequestDispatcher("pages/home.jsp").forward(request,response);
        }else{
            // 用户不存在  表示用户名或密码错误   跳回登陆页面 并且展示错误信息
            request.setAttribute("errorMsg","用户名或密码错误");
            // 转发回登陆页面
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
