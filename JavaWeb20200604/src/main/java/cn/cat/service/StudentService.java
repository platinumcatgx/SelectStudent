package cn.cat.service;

import cn.cat.dao.IStudentDao;
import cn.cat.domain.Student;
import cn.cat.domain.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    IStudentDao studentDao;

    public List<StudentData> select(){
        return studentDao.select();
    }

    public List<StudentData> selectByName(String selectByName){
        return studentDao.selectByName(selectByName);
    }

    public Student login(int id , String name){
        return studentDao.login(id,name);
    }
}
