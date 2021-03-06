
package com.working.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.entity.Student;
import com.working.entity.Teacher;
import com.working.service.StudentService;
import com.working.service.TeacherService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private TeacherService teacherService;
    
    /**
     * 登陆
     * 
     * @param username 用户名
     * @param password 密码
     * @return Map 保存结果
     */
    @RequestMapping("/login")
    public Map<String, Object> login(String username, String password) {
        
        Map<String, Object> resultMap = new HashMap<String, Object>();
        // 判断是否为管理员
        if ("root".equals(username) && "root".equals(password)) {
            resultMap.put("data", "root");
            resultMap.put("state", 0);
            resultMap.put("message", "查询成功");
            return resultMap;
        }
        
        Student student = new Student();
        student.setNum(username);
        // student.setPassword(password);
        List<Student> students = studentService.selectList(student);
        if (students.isEmpty()) {// 该账号不是学生
            Teacher teacher = new Teacher();
            teacher.setNum(username);
            // teacher.setPassword(password);
            List<Teacher> teachers = teacherService.selectList(teacher);
            if (teachers.isEmpty()) {// 该账号不是教师
                resultMap.put("data", "");
                resultMap.put("state", -1);
                resultMap.put("message", "该用户不存在，请先注册");
            } else {
                if (password.equals(teachers.get(0).getPassword())) {
                    resultMap.put("data", "teacher");
                    resultMap.put("state", 0);
                    resultMap.put("message", "查询成功");
                } else {
                    resultMap.put("data", "");
                    resultMap.put("state", -1);
                    resultMap.put("message", "密码错误,请重新输入密码");
                }
            }
        } else {
            if (password.equals(students.get(0).getPassword())) {
                resultMap.put("data", "student");
                resultMap.put("state", 0);
                resultMap.put("message", "查询成功");
            } else {
                resultMap.put("data", "");
                resultMap.put("state", -1);
                resultMap.put("message", "密码错误,请输入密码");
            }
        }
        
        return resultMap;
    }
    
    /**
     * 保存学生信息
     * 
     * @param teacher 学生信息
     * @return Map 保存结果
     */
    @RequestMapping("/stuRegister")
    public Map<String, Object> stuRegister(Student student) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", "");
        try {
            studentService.insert(student);
            resultMap.put("state", 0);
            resultMap.put("message", "保存成功");
        } catch (Exception e) {
            resultMap.put("state", -1);
            resultMap.put("message", "保存失败");
        }
        
        return resultMap;
    }
    
    /**
     * 保存教师信息
     * 
     * @param teacher 教师信息
     * @return Map 保存结果
     */
    @RequestMapping("/teaRegister")
    public Map<String, Object> teaRegister(Teacher teacher) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            teacherService.insert(teacher);
            resultMap.put("state", 0);
            resultMap.put("message", "保存成功");
        } catch (Exception e) {
            resultMap.put("state", -1);
            resultMap.put("message", "保存失败");
        }
        resultMap.put("data", "");
        return resultMap;
    }
}
