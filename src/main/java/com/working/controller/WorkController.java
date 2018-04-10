
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
import com.working.entity.Teacher;
import com.working.entity.Work;
import com.working.service.StudentService;
import com.working.service.SubjectService;
import com.working.service.TeacherService;
import com.working.service.WorkService;
import com.working.util.DateTimeUtils;
import com.working.util.MapAndBeanTransform;
import com.working.util.TableData;

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
    
    @Autowired
    private TeacherService teacherService;
    
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
            if (state != null) {
                work.setState(state);
            }
            String grade = request.getParameter("grade");
            if (grade != null) {
                work.setClassNum(grade);
            }
            String subject = request.getParameter("subject");
            if (subject != null) {
                work.setSubNum(subject);
            }
            String stuName = request.getParameter("stuName");
            if (stuName != null) {
                work.setStuName(stuName);
            }
            String stuNum = request.getParameter("stuNum");
            if (stuNum != null) {
                work.setStuNum(stuNum);
            }
            String teacherNum = request.getParameter("teacherNum");
            if (teacherNum != null) {
                work.setTeacherNum(teacherNum);
            }
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
                    if (workList2.getUpdateTime() != null) {
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
        String title = request.getParameter("title");
        String questions = request.getParameter("questions");
        String subNum = request.getParameter("subNum");// 科目
        String classNum = request.getParameter("classNum");// 班级
        String teacherNum = request.getParameter("teacherNum");
        Teacher teacher = new Teacher();
        teacher.setNum(teacherNum);
        String teacherName = teacherService.selectList(teacher).get(0).getName();
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("teacherNum", teacherNum);
        paramMap.put("classNum", classNum);
        try {
            List<Student> students = studentService.queryStudents(paramMap);
            if ("".equals(subNum)) {// 该教师代的所有科目
                Subject subject = new Subject();
                subject.setTeacherNum(teacherNum);
                List<Subject> subjects = subjectService.selectList(subject);
                for (Subject subject2 : subjects) {
                    for (Student student : students) {
                        Work work = new Work();
                        work.setClassNum(student.getGrade());
                        work.setState("1");
                        work.setStuNum(student.getNum());
                        work.setStuName(student.getName());
                        work.setSubNum(subject2.getSubNum());
                        work.setSubName(subject2.getSubName());
                        work.setTeacherNum(teacherNum);
                        work.setTeacherName(teacherName);
                        work.setTitle(title);
                        work.setPublishUrl(questions);
                        work.setUpdateTime(new Timestamp(new Date().getTime()));
                        workService.insert(work);
                    }
                }
            } else {
                for (Student student : students) {
                    Work work = new Work();
                    work.setClassNum(student.getGrade());
                    work.setState("1");
                    work.setStuNum(student.getNum());
                    work.setStuName(student.getName());
                    work.setSubNum(subNum);
                    work.setTeacherNum(teacherNum);
                    work.setTeacherName(teacherName);
                    work.setTitle(title);
                    work.setPublishUrl(questions);
                    work.setUpdateTime(new Timestamp(new Date().getTime()));
                    workService.insert(work);
                }
            }
            
            // 保存作业
            resultMap.put("state", 0);
            resultMap.put("msg", "作业保存成功");
        } catch (Exception e) {
            resultMap.put("state", -1);
            resultMap.put("msg", "作业保存失败");
        }
        return resultMap;
    }
}
