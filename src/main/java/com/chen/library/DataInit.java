package com.chen.library;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 运行Sql脚本
 * sql脚本放在resources下的sql文件夹下
 */
public final class DataInit {
    /**
     * <p>运行指定的sql脚本
     * @param sqlFileName 需要执行的sql脚本的名字
     */
    public static void run(String sqlFileName) {
        try {
            // 获取数据库相关配置信息
            Properties props = Resources.getResourceAsProperties("db.properties");

            // jdbc 连接信息: 注: 现在版本的JDBC不需要配置driver，因为不需要Class.forName手动加载驱动
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");

            // 建立连接
            Connection conn = DriverManager.getConnection(url, username, password);

            // 创建ScriptRunner，用于执行SQL脚本
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);
            // 执行SQL脚本
            Resources.setCharset(Charset.forName("UTF-8"));
            Resources.getResourceAsReader("sql/" + sqlFileName + ".sql");
            runner.runScript(Resources.getResourceAsReader("sql/" + sqlFileName + ".sql"));

            // 关闭连接
            conn.close();

            // 若成功，打印提示信息
            System.out.println("====== SUCCESS ======");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}