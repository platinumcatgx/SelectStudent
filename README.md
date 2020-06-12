# SelectStudent
JavaWeb考试作品--学生管理系统登录/查询部分,  分为前端和后台分别开发, 数据库为MySQL ,后端采用Maven+SSM框架开发,  前端使用JQuery AJAX请求数据,  测试时Tomcat服务器端口为80,  前后端单独运行,  后台测试软件为Postman

当前系统任有很多不足之处

http://localhost/JavaWeb/
接口API:
student/login     

| KEY  | VALUE           | 说明     |
| ---- | --------------- | -------- |
| id   | 学生的学号:1    | 必要参数 |
| name | 学生的名称:java | 必要参数 |

返回数据示例:

```json
{
    "msg": "用户java登录",
    "student": {
        "id": 1,
        "name": "java"
    }
}
```

student/select

| KEY  | VALUE                  | 说明       |
| ---- | ---------------------- | ---------- |
| name | 查询的名称(模糊查询):j | 非必要参数 |

返回数据示例:

```json
{
    "msg": "数据正常",
    "student": [
        {
            "credit": 100,
            "curriculum_name": "顺风耳",
            "final_grade": 100,
            "final_resutl": 100,
            "id": 1,
            "name": "java",
            "qutting_time": "2020-06-03 12:43:30",
            "schooltime": "2020-02-06 12:43:18",
            "teacher_name": "谛听",
            "usal_performmance": 100
        },
        {
            "credit": 0,
            "final_grade": 0,
            "final_resutl": 0,
            "id": 2,
            "name": "jak",
            "usal_performmance": 0
        },
        {
            "credit": 0,
            "final_grade": 0,
            "final_resutl": 0,
            "id": 4,
            "name": "j",
            "usal_performmance": 0
        }
    ]
}
```


