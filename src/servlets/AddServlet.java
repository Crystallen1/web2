package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static sql.loadDB.conn;

/**
 * Created on 2022/7/26.
 *
 * @author Crystallen
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        //设置文字编码
        req.setCharacterEncoding("UTF-8");
        //读取html中传来的信息
        String fname = req.getParameter("fname");
        String agestr = req.getParameter("age");
        Integer age = Integer.parseInt(agestr);
        String major= req.getParameter("major");

        //生成sql语句
        String sqlstr = "INSERT INTO test VALUES ('" +fname+ "'," + agestr+ ",'" +major+ "')";
        //连接数据库
        sql.loadDB.getConnection();

        //添加记录
        try {
            sql.AddRecord.addRecord(sqlstr,conn);
            System.out.println("添加成功");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("major = " + major);
        System.out.println("age = " + age);
        System.out.println("fname = " + fname);

    }
}
