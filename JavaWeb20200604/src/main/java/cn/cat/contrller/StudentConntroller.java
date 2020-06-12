package cn.cat.contrller;

import cn.cat.domain.Student;
import cn.cat.domain.StudentData;
import cn.cat.service.StudentService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("student")
@CrossOrigin//支持跨域
public class StudentConntroller {
    @Autowired
    private StudentService studentService;
    JSONObject jsonObject;

    @RequestMapping("select")
    public @ResponseBody
    String selectStudent(@RequestParam(name = "name", required = false) String name,
                         HttpServletRequest request,
                         HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        //判断是否登录
//        if (request.getSession().getAttribute("loginStudent") == null) {
//            return "{\"msg\":\"未登录\"}";
//        }

        jsonObject = new JSONObject();
        List<StudentData> studentData = null;
        //查询数据
        try {
            System.out.println("NAME = \t" + name);
            if (name == null) {
                studentData = studentService.select();
            } else {
                studentData = studentService.selectByName(name);
            }
            jsonObject.put("msg", "数据正常");
            jsonObject.put("student", studentData);
        } catch (Exception e) {
            jsonObject.put("msg", "数据查询异常");
            throw new RuntimeException("数据查询异常");
        }
        //添加到域
        request.getSession().setAttribute("student", studentData);
        request.getSession().setAttribute("JSON", jsonObject.toJSONString());
        return jsonObject.toJSONString();
    }

    @RequestMapping("login")
    public @ResponseBody
    String login(int id,
                 String name,
                 HttpServletRequest request,
                 HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        jsonObject = new JSONObject();
        //判断参数
        try {
            if (id < 1 || name.equals(null))
                return "{\"msg\":\"输入异常\"}";
            //执行查询
            Student login = studentService.login(id, name);
            //
            if (login == null) {
                return "{\"msg\":\"查询用户为空\"}";
            }
            request.setAttribute("student", login);
            request.getSession().setAttribute("loginStudent", login);
            jsonObject.put("msg","用户"+name+"登录");
            jsonObject.put("student", login);
            request.getSession().setAttribute("JSON", jsonObject.toJSONString());
        } catch (Exception e) {
            throw new RuntimeException("登录异常");
        }
        return jsonObject.toJSONString();
    }
}
