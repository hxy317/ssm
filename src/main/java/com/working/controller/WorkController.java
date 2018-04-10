
package com.working.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import com.working.entity.Student;
import com.working.entity.Subject;
import com.working.entity.Work;
import com.working.service.StudentService;
import com.working.service.SubjectService;
import com.working.service.WorkService;
import com.working.util.DateTimeUtils;
import com.working.util.MapAndBeanTransform;
import com.working.util.TableData;
import com.working.util.UUIDUtil;

/**
 * Work
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@RestController
@RequestMapping("/working/*")
public class WorkController {
    
    /** workService */
    @Autowired
    private WorkService workService;
    
    @Autowired
    private SubjectService subjectService;
    
    @Autowired
    private StudentService studentService;
    
    
    /**
     * 作业列表查询
     * 
     * @param request
     * @throws Exception e
     */
    @RequestMapping("/queryWorkList")
    @ResponseBody
    public TableData<Map<String, Object>> queryWorkList(HttpServletRequest request) {
        try {
            // 查询条件
            Work work = new Work();
            String state = request.getParameter("state");
            work.setState(state);
            String grade = request.getParameter("grade");
            work.setClassNum(grade);
            String subject = request.getParameter("subject");
            work.setSubNum(subject);
            String stuName = request.getParameter("stuName");
            work.setStuName(stuName);
            // 分页信息
            int pageNumber = NumberUtils.toInt(request.getParameter("pageNumber"), 1);
            int pageSize = NumberUtils.toInt(request.getParameter("pageSize"), 10);
            PageHelper.startPage(pageNumber, pageSize);
            PageHelper.orderBy("update_time desc");
            List<Work> workList = workService.selectList(work);
            PageInfo<Work> pageInfo = new PageInfo<Work>(workList);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            if (workList != null && workList.size() > 0) {
                for (Work workList2 : workList) {
                    Map<String, Object> map = MapAndBeanTransform.beanToMap(workList2);
                    String updateTime = "";
                    if(workList2.getUpdateTime()!=null) {
                    	updateTime = DateTimeUtils.converTimestampToString(workList2.getUpdateTime(),
                                "yyyy-MM-dd HH:mm");
                    }
                    map.put("updateTime", updateTime);
                    list.add(map);
                }
            }
            return TableData.bulid(pageInfo.getTotal(), list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TableData.bulid(0, null);
    }
    
    /**
     * 保存作业
     * 
     * @param teacher 学生信息
     * @return Map 保存结果
     */
    @RequestMapping("/save")
    public Map<String, Object> stuRegister(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", "");
     // 查询条件
        Work work = new Work();
        String title = request.getParameter("title");
        String questions = request.getParameter("questions");
        String subNum = request.getParameter("subNum");//科目
        String classNum = request.getParameter("classNum");//班级
        String teacherNum = request.getParameter("teacherNum");
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("teacherNum", teacherNum);
        //作业id
        String publishUrl = UUIDUtil.generateUUID();
        try {
        	if(!"999".equals(classNum)) {//该教师的所有班级 不是全选
            	paramMap.put("classNum", classNum);
            }
            List<Student> students = studentService.queryStudents(paramMap);
            if("999".equals(subNum)) {//该教师代的所有科目
            	Subject subject = new Subject();
            	subject.setTeacherNum(teacherNum);
            	List<Subject> subjects = subjectService.selectList(subject);
            	for (Subject subject2 : subjects) {
            		for (Student student : students) {
        				Work newWork = new Work();
        				newWork.setClassNum(student.getGrade());
        				newWork.setState("0");
        				newWork.setStuNum(student.getNum());
        				newWork.setStuName(student.getName());
        				newWork.setSubNum(subject2.getSubNum());
        				newWork.setSubName(subject2.getSubName());
        				newWork.setTeacherNum(teacherNum);
        				newWork.setTitle(title);
        				newWork.setPublishUrl(publishUrl);
        				 work.setUpdateTime(new Timestamp(new Date().getTime()));
        				workService.insert(newWork);
        			}
    			}
            }else {
            	for (Student student : students) {
    				Work newWork = new Work();
    				newWork.setClassNum(student.getGrade());
    				newWork.setState("0");
    				newWork.setStuNum(student.getNum());
    				newWork.setStuName(student.getName());
    				newWork.setSubNum(subNum);
    				newWork.setTeacherNum(teacherNum);
    				newWork.setTitle(title);
    				newWork.setPublishUrl(publishUrl);
    				newWork.setUpdateTime(new Timestamp(new Date().getTime()));
    				workService.insert(newWork);
    			}
            }
            
            
            //保存作业
            resultMap.put("state", 0);
            resultMap.put("msg", "作业保存成功");
        } catch (Exception e) {
            resultMap.put("state", -1);
            resultMap.put("msg", "作业保存失败");
        }
        return resultMap;
    }
}
