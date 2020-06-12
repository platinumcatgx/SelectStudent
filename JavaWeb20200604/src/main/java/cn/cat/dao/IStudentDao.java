package cn.cat.dao;

import cn.cat.domain.Student;
import cn.cat.domain.StudentData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentDao {

    List<StudentData> select();

    List<StudentData> selectByName(@Param("name") String selectByName);

    Student login(@Param("id") Integer id, @Param("name") String name);
}
