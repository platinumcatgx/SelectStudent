package cn.cat.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class StudentData {
    private int id;//学号
    private String name;//姓名
    private String teacher_name;//任课老师
    private String curriculum_name;//课程名称
    private int credit;//学分
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date schooltime;//上课时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date qutting_time;//下课时间
    private int usal_performmance;//平时成绩
    private int final_grade;//期末成绩
    private int final_resutl;//最终成绩

    @Override
    public String toString() {
        return "StudentData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", curriculum_name='" + curriculum_name + '\'' +
                ", credit=" + credit +
                ", schooltime=" + schooltime +
                ", qutting_time=" + qutting_time +
                ", usal_performmance=" + usal_performmance +
                ", final_grade=" + final_grade +
                ", final_resutl=" + final_resutl +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getCurriculum_name() {
        return curriculum_name;
    }

    public void setCurriculum_name(String curriculum_name) {
        this.curriculum_name = curriculum_name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Date getSchooltime() {
        return schooltime;
    }

    public void setSchooltime(Date schooltime) {
        this.schooltime = schooltime;
    }

    public Date getQutting_time() {
        return qutting_time;
    }

    public void setQutting_time(Date qutting_time) {
        this.qutting_time = qutting_time;
    }

    public int getUsal_performmance() {
        return usal_performmance;
    }

    public void setUsal_performmance(int usal_performmance) {
        this.usal_performmance = usal_performmance;
    }

    public int getFinal_grade() {
        return final_grade;
    }

    public void setFinal_grade(int final_grade) {
        this.final_grade = final_grade;
    }

    public int getFinal_resutl() {
        return final_resutl;
    }

    public void setFinal_resutl(int final_resutl) {
        this.final_resutl = final_resutl;
    }
}
