
package com.working.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.util.StringUtil;
import com.working.entity.Student;
import com.working.service.StudentService;

/**
 * Student
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@RestController
@RequestMapping("/student/*")
public class StudentController {
    
    /** studentService */
    @Autowired
    private StudentService studentService;
    
    /**
     * 商品列表查询
     * 
     * @param pageSize 每页行数
     * @param pageNumber 第几页
     * @return JQPage 商品列表
     * @throws Exception e
     */
    @RequestMapping("/queryUserByStuNum")
    public Map<String, Object> queryUserByStuNum(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", "");
        resultMap.put("data", "查询失败");
        Student student = new Student();
        String stuNum = request.getParameter("stuNum");
        if (stuNum == null || StringUtil.isEmpty(stuNum)) {
            resultMap.put("state", -1);
            resultMap.put("message", "参数错误，无学生账号");
            return resultMap;
        }
        student.setNum(stuNum);
        List<Student> students = studentService.selectList(student);
        if (!students.isEmpty()) {
            resultMap.put("state", 0);
            resultMap.put("data", students.get(0));
            resultMap.put("message", "查询成功");
        }
        return resultMap;
    }
    
}
