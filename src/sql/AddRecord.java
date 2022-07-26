package sql;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created on 2022/7/26.
 *
 * @author Crystallen
 */
public class AddRecord {

    @Test
    public static void addRecord(String sqlString, Connection conn) throws SQLException {

        try{
            //开启事务
            conn.setAutoCommit(false);
            //执行SQL
            Statement stmt = conn.createStatement();
            //受影响的行数
            int count =stmt.executeUpdate(sqlString);
            System.out.println(count);
            //提交事务
            conn.commit();
            stmt.close();
        }catch (Exception e){
            //回滚事务
            conn.rollback();
            e.printStackTrace();
        }


    }
}
