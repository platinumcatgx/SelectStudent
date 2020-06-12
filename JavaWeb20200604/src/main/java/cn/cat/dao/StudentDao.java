package cn.cat.dao;

import cn.cat.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
   public int insert(Student student) {
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       try {
           //初始化对象
           connection = BaseDao.getConnection();
           preparedStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?)");
           //添加参数
           preparedStatement.setInt(1,student.getId());
           preparedStatement.setString(2,student.getName());

           return preparedStatement.executeUpdate();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }finally {
           BaseDao.closeAll(connection,preparedStatement,null);
       }
       return -1;
   }

}
