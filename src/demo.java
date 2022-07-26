import org.testng.annotations.Test;
import sql.loadDB;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created on 2022/7/26.
 *
 * @author Crystallen
 */
public class demo {

    @Test
    public void testDML() throws Exception {
        loadDB.getConnection();

        //定义Sql
        String sql =  "INSERT INTO test VALUES ('lch',19,'市场营销')";

        Statement stmt = loadDB.conn.createStatement();

        int count =stmt.executeUpdate(sql);

        System.out.println(count);

        stmt.close();


    }
}
