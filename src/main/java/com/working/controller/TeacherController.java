
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
import com.working.entity.Teacher;
import com.working.service.TeacherService;
import com.working.util.TableData;

/**
 * Teacher
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@RestController
@RequestMapping("/teacher/*")
public class TeacherController {
    
    /** teacherService */
    @Autowired
    private TeacherService teacherService;
    
    /**
     * 查询教师信息
     * 
     * @param request request参数
     * @return Map 教师信息
     */
    @RequestMapping("/queryTeacherByTeaNum")
    public Map<String, Object> queryTeacherByTeaNum(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", "");
        resultMap.put("data", "查询失败");
        Teacher teacher = new Teacher();
        String teaNum = request.getParameter("teaNum");
        if (teaNum == null || StringUtil.isEmpty(teaNum)) {
            resultMap.put("state", -1);
            resultMap.put("message", "参数错误，无教师账号");
            return resultMap;
        }
        teacher.setNum(teaNum);
        List<Teacher> teachers = teacherService.selectList(teacher);
        if (!teachers.isEmpty()) {
            resultMap.put("state", 0);
            resultMap.put("data", teachers.get(0));
            resultMap.put("message", "查询成功");
        }
        return resultMap;
    }
    
    /**
     * 更新信息
     * 
     * @param request teacher教师信息
     * @param request request参数
     * @return Map 成功信息
     */
    @RequestMapping("/update")
    public Map<String, Object> update(Teacher teacher, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            teacherService.updateIfNotNull(teacher);
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
     * 教师列表查询 分页表单显示
     * 
     * @param request
     * @return
     * @throws Exception e
     */
    @RequestMapping("/queryTeacherList")
    @ResponseBody
    public TableData<Teacher> queryTeacherList(HttpServletRequest request) {
        try {
            // 查询条件
        	Teacher teacher = new Teacher();
            String num = request.getParameter("num");
            if (num != null) {
            	teacher.setNum(num);
            }
            String name = request.getParameter("name");
            if (name != null) {
            	teacher.setName(name);
            }
            String phone = request.getParameter("phone");
            if (phone != null) {
            	teacher.setPhone(phone);
            }
            // 分页信息
            int pageNumber = NumberUtils.toInt(request.getParameter("pageNumber"), 1);
            int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 10);
            PageHelper.startPage(pageNumber, pageSize);
            PageHelper.orderBy("num desc");
            List<Teacher> teacherList = teacherService.selectList(teacher);
            PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(teacherList);
            return TableData.bulid(pageInfo.getTotal(), teacherList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TableData.bulid(0, null);
    }
    
    
}
