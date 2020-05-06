package cn.tx.servlet;

import cn.tx.service.DistrictService;
import cn.tx.service.impl.DistrictServiceImpl;
import com.alibaba.fastjson.JSONArray;

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
 * @date 2019/6/2820:17
 */
public class DistrictListServlet extends HttpServlet {
    DistrictService districtService = new DistrictServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray jsonArray = districtService.listDistricts();
        // 设置响应类型
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonArray.toJSONString());
    }
}
