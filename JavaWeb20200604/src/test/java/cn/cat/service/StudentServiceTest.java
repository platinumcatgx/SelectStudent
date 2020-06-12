package cn.cat.service;

import cn.cat.domain.Student;
import cn.cat.domain.StudentData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentServiceTest {
    @Autowired
    StudentService studentService;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void select() {
        List<StudentData> select = studentService.select();
        for (StudentData studentData  : select) {
            System.out.println(studentData);
        }
    }

    @Test
    public void selectByName() {
        List<StudentData> java = studentService.selectByName("java");
        for (StudentData studentData  : java) {
            System.out.println(studentData);
        }
    }

    @Test
    public void login() {
        Student java = studentService.login(1, "java");
        System.out.println(java);
    }
}