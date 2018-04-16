
package com.working.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.working.entity.Student;
import com.working.entity.Subject;
import com.working.service.StudentService;
import com.working.util.TableData;

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
     * 查询学生信息
     * 
     * @param request request参数
     * @return Map 学生信息
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
    
    /**
     * 更新学生信息
     * 
     * @param request request参数
     * @return Map 学生信息
     */
    @RequestMapping("/update")
    public Map<String, Object> update(Student student, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            studentService.updateIfNotNull(student);
            resultMap.put("state", 0);
            resultMap.put("data", "");
            resultMap.put("message", "修改成功");
            
        } catch (Exception e) {
            resultMap.put("state", -1);
            resultMap.put("data", "");
            resultMap.put("message", "修改失败");
        }
        return resultMap;
    }
    
    /**
     * 学生列表查询 分页表单显示
     * 
     * @param request
     * @return
     * @throws Exception e
     */
    @RequestMapping("/queryStudentList")
    @ResponseBody
    public TableData<Student> queryStudentList(HttpServletRequest request) {
        try {
            // 查询条件
        	Student student = new Student();
            String grade = request.getParameter("grade");
            if (grade != null) {
            	student.setGrade(grade);
            }
            String num = request.getParameter("num");
            if (num != null) {
            	student.setNum(num);
            }
            String name = request.getParameter("name");
            if (name != null) {
            	student.setName(name);
            }
            String phone = request.getParameter("phone");
            if (phone != null) {
            	student.setPhone(phone);
            }
            // 分页信息
            int pageNumber = NumberUtils.toInt(request.getParameter("pageNumber"), 1);
            int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 10);
            PageHelper.startPage(pageNumber, pageSize);
            PageHelper.orderBy("num desc");
            List<Student> studentList = studentService.selectList(student);
            PageInfo<Student> pageInfo = new PageInfo<Student>(studentList);
            return TableData.bulid(pageInfo.getTotal(), studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TableData.bulid(0, null);
    }
}
