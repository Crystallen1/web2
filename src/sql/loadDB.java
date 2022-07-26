package sql;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created on 2022/7/26.
 *
 * @author Crystallen
 */
public class loadDB {

    public static Connection conn;

    @Test
    public static void getConnection() {
        //读取配置文件中的数据库信息
        InputStream is = loadDB.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        try {
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //连接驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //连接数据库
        try {
            loadDB.conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
            System.out.println("连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
