package cn.cat.dao;

import cn.cat.domain.Student;

import java.sql.*;

public class BaseDao {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
     * 获取连接
     */
    public static java.sql.Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb_20200604", "root", "1234");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接
     *
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 添加数据方法
     */
    public int insert(String tableName, String... values) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //初始化对象
            connection = BaseDao.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO ? VALUES(?,?)");
            if (tableName != null && !tableName.equals(""))
                preparedStatement.setString(1, tableName);
            //添加参数
            if (values != null)
                for (int i = 0; i < values.length; i++)
                    preparedStatement.setObject(i + 2, values[i]);
            else
                new NullPointerException("添加数据为空");
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeAll(connection, preparedStatement, null);
        }
        return -1;
    }

    /**
     * 查询
     * @param tableName 要查询的表
     * @return
     */
    public ResultSet select(String tableName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //初始化对象
            connection = BaseDao.getConnection();
            preparedStatement = connection.prepareStatement("select * from ?  ");
            if (tableName != null && !tableName.equals(""))
                preparedStatement.setString(1, tableName);
            else
                new NullPointerException("表明为空");
            return preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeAll(connection, preparedStatement, null);
        }
        return null;
    }
}
