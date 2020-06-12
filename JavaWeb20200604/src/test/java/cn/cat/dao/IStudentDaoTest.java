package cn.cat.dao;

import cn.cat.domain.Student;
import cn.cat.domain.StudentData;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
public class IStudentDaoTest {
//    @Autowired
//    IStudentDao studentDao;
    SqlSession sqlSession=null;
    IStudentDao studentDao=null;

    @Before
    public void before(){
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybaties.xml")).openSession();
            studentDao = sqlSession.getMapper(IStudentDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void select() {
        List<StudentData> select = studentDao.select();
        for (StudentData s : select) {
            System.out.println(s);
        }
    }

    @Test
    public void selectByName() {
        List<StudentData> select = studentDao.selectByName("j");
        for (StudentData s : select) {
            System.out.println(s);
        }
    }

    @Test
    public void login(){
        Student var = studentDao.login(1, "java");
        System.out.println(var);
    }
}