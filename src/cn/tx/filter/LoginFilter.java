package cn.tx.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Administrator
 * @title: ${NAME}
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2822:47
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 把请求对象强转为http请求对象
        HttpServletRequest request = (HttpServletRequest) req;
        // 判断静态资源  如果是静态资源则直接放行
        String uri = request.getRequestURI();
//        System.out.println(uri);
        if(uri.equals("/") || uri.contains("/js/")
                || uri.contains("/images/")
                || uri.contains("/css/")){
            chain.doFilter(request,resp);
            return;
        }

        // 放行用户的登陆请求
        if(uri.contains("userLoginServlet") || uri.contains("userExistServlet") || uri.contains("login.jsp")){
            chain.doFilter(request,resp);
            return;
        }
        // 获取session
        Object user = request.getSession().getAttribute("user");
        // 判断user是否存在
        if(user == null){
            request.setAttribute("errorMsg","您还没有登陆,请重新登陆!");
            request.getRequestDispatcher("login.jsp").forward(request,resp);
        }else{
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
