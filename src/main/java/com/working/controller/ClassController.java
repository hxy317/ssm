
package com.working.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.entity.Class;
import com.working.service.ClassService;

/**
 * Class
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@RestController
@RequestMapping("/class/*")
public class ClassController {
    
    /** classService */
    @Autowired
    private ClassService classService;
    
    /**
     * 班级列表查询
     * 
     * @param request request
     * @throws Exception e
     */
    @RequestMapping("/list")
    public Map<String, Object> classList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Class> classLst = classService.selectList(new Class());
        resultMap.put("data", classLst);
        resultMap.put("msg", "查询成功");
        resultMap.put("state", "0");
        
        return resultMap;
        
    }
    /**
     * 根据教师id查询代课班级信息
     * 
     * @param request request
     * @throws Exception e
     */
    @RequestMapping("/queryClassByTeaId")
    public Map<String, Object> queryClassByTeaId(String teacherNum) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Class clazz = new Class();
        clazz.setTeacherNum(teacherNum);
        List<Class> classLst = classService.selectList(clazz);
        resultMap.put("data", classLst);
        resultMap.put("msg", "查询成功");
        resultMap.put("state", "0");
        
        return resultMap;
        
    }
}
