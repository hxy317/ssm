
package com.working.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.dao.StudentDAO;
import com.working.entity.Student;
import com.working.util.UUIDUtil;

/**
 * StudentService
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@Service
public class StudentService {
    
    /** studentMapper接口 */
    @Autowired
    private StudentDAO studentMapper;
    
    /**
     * 保存
     * 
     * @param student
     */
    public void insert(Student student) throws Exception {
        student.setId(UUIDUtil.generateUUID());
        studentMapper.insert(student);
    }
    
    /**
     * 批量保存
     * 
     * @param student
     */
    public void insertList(List<Student> studentList) throws Exception {
        studentMapper.insertList(studentList);
    }
    
    /**
     * 通过主键删除单条记录
     * 
     * @param id 主键ID
     * @throws Exception 出错抛出异常
     */
    public void delete(String id) throws Exception {
        studentMapper.delete(id);
    }
    
    /**
     * 更新
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param student
     * @throws Exception 出错抛出异常
     */
    public void update(Student student) throws Exception {
        studentMapper.update(student);
    }
    
    /**
     * 更新非空字段
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param student
     * @throws Exception 出错抛出异常
     */
    public void updateIfNotNull(Student student) throws Exception {
        studentMapper.updateIfNotNull(student);
    }
    
    /**
     * 通过主键获取单条记录
     * 
     * @param id 主键ID
     * @return 单条记录
     */
    public Student selectByPrimaryKey(String id) {
        return studentMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 通过自定义非空字段获取记录集
     * 
     * @param student
     */
    public List<Student> selectList(Student student) {
        return studentMapper.selectList(student);
    }
    
    /**
     * 通过自定义非空字段获取记录集
     * 
     * @param work
     */
    public List<Student> queryStudents(Map<String, String> paramMap) {
        return studentMapper.queryStudents(paramMap);
    }
}
