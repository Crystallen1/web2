package sql;

import org.testng.annotations.Test;

import java.sql.*;

/**
 * Created on 2022/7/28.
 *
 * @author Crystallen
 */
public class queryData {

    public static ResultSet queryData(String sqlString, Connection conn) {
        ResultSet resultSet = null;
        try {
            //执行SQL
            Statement stmt = conn.createStatement();
            //受影响的行数
            resultSet = stmt.executeQuery(sqlString);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    @Test
    public static ResultSet prepareDQL(String sqlString, Connection conn ,String a,String b ,String c)  {

        ResultSet rs_ = null;
        try {
            //获取pstmt对象
            PreparedStatement pstmt = conn.prepareStatement(sqlString);
            //设置？的值
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, c);
            //执行sql
            rs_ = pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs_;
    }

    @Test
    public static ResultSet prepareDQL(String sqlString, Connection conn , String a, String b )   {

        ResultSet rs_ = null;
        try {
            //获取pstmt对象
            PreparedStatement pstmt = conn.prepareStatement(sqlString);
            //设置？的值
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            //执行sql
            rs_ = pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs_;
    }
}
