package sql;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
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
    public static void getConnection() throws Exception {
        System.out.println(System.getProperty("user.dir"));
        //读取配置文件中的数据库信息
        Properties pros = new Properties();
        pros.load(new FileInputStream("D:/java/project1/src/jdbc.properties"));

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);

        //获取数据库连接
        conn = dataSource.getConnection();

        System.out.println(conn);




    }
}
