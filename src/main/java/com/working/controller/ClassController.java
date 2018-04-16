
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
import com.working.entity.Class;
import com.working.service.ClassService;
import com.working.util.TableData;

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
     * 所有班级
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
     * 班级列表查询 分页表单显示
     * 
     * @param request
     * @return
     * @throws Exception e
     */
    @RequestMapping("/queryClassList")
    @ResponseBody
    public TableData<Class> queryClassList(HttpServletRequest request) {
        try {
            // 查询条件
            Class clazz = new Class();
            String className = request.getParameter("className");
            if (className != null) {
                clazz.setClassName(className);
            }
            String teacherNum = request.getParameter("teacherNum");
            if (teacherNum != null) {
                clazz.setTeacherNum(teacherNum);
            }
            String teacherName = request.getParameter("teacherName");
            if (teacherName != null) {
                // 教师姓名
            }
            // 分页信息
            int pageNumber = NumberUtils.toInt(request.getParameter("pageNumber"), 1);
            int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 10);
            PageHelper.startPage(pageNumber, pageSize);
            PageHelper.orderBy("class_num desc");
            List<Class> clazzList = classService.selectList(clazz);
            PageInfo<Class> pageInfo = new PageInfo<Class>(clazzList);
            return TableData.bulid(pageInfo.getTotal(), clazzList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TableData.bulid(0, null);
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
