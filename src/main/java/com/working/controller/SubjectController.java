
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
import com.working.entity.Subject;
import com.working.service.SubjectService;
import com.working.util.TableData;

/**
 * Subject
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@RestController
@RequestMapping("/subject/*")
public class SubjectController {
    
    /** subjectService */
    @Autowired
    private SubjectService subjectService;
    
    /**
     * 课程列表查询
     * 
     * @param request request
     * @throws Exception e
     */
    @RequestMapping("/list")
    public Map<String, Object> subjectList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Subject> subjectLst = subjectService.selectList(new Subject());
        resultMap.put("data", subjectLst);
        resultMap.put("msg", "查询成功");
        resultMap.put("state", "0");
        
        return resultMap;
        
    }
    /**
     * 课程列表查询
     * 
     * @param request request
     * @throws Exception e
     */
    @RequestMapping("/querySubjectByTeaId")
    public Map<String, Object> querySubjectByTeaId(String teacherNum) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Subject subject = new Subject();
        subject.setTeacherNum(teacherNum);
        List<Subject> subjectLst = subjectService.selectList(subject);
        resultMap.put("data", subjectLst);
        resultMap.put("msg", "查询成功");
        resultMap.put("state", "0");
        
        return resultMap;
        
    }
    
    /**
     * 课程列表查询 分页表单显示
     * 
     * @param request
     * @return
     * @throws Exception e
     */
    @RequestMapping("/querySubjectList")
    @ResponseBody
    public TableData<Subject> querySubjectList(HttpServletRequest request) {
        try {
            // 查询条件
            Subject subject = new Subject();
            String subName = request.getParameter("subName");
            if (subName != null) {
            	subject.setSubName(subName);
            }
            String teacherNum = request.getParameter("teacherNum");
            if (teacherNum != null) {
            	subject.setTeacherNum(teacherNum);
            }
            String teacherName = request.getParameter("teacherName");
            if (teacherName != null) {
                // 教师姓名
            }
            // 分页信息
            int pageNumber = NumberUtils.toInt(request.getParameter("pageNumber"), 1);
            int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 10);
            PageHelper.startPage(pageNumber, pageSize);
            PageHelper.orderBy("sub_num desc");
            List<Subject> subjectList = subjectService.selectList(subject);
            PageInfo<Subject> pageInfo = new PageInfo<Subject>(subjectList);
            return TableData.bulid(pageInfo.getTotal(), subjectList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TableData.bulid(0, null);
    }
    
}
