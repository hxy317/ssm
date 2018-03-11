
package com.working.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.dao.TeacherDAO;
import com.working.entity.Teacher;
import com.working.util.UUIDUtil;

/**
 * TeacherService
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@Service
public class TeacherService {
    
    /** teacherMapper接口 */
    @Autowired
    private TeacherDAO teacherMapper;
    
    /**
     * 保存
     * 
     * @param teacher
     */
    public void insert(Teacher teacher) throws Exception {
        teacher.setId(UUIDUtil.generateUUID());
        teacherMapper.insert(teacher);
    }
    
    /**
     * 批量保存
     * 
     * @param teacher
     */
    public void insertList(List<Teacher> teacherList) throws Exception {
        teacherMapper.insertList(teacherList);
    }
    
    /**
     * 通过主键删除单条记录
     * 
     * @param id 主键ID
     * @throws Exception 出错抛出异常
     */
    public void delete(String id) throws Exception {
        teacherMapper.delete(id);
    }
    
    /**
     * 更新
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param teacher
     * @throws Exception 出错抛出异常
     */
    public void update(Teacher teacher) throws Exception {
        teacherMapper.update(teacher);
    }
    
    /**
     * 更新非空字段
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param teacher
     * @throws Exception 出错抛出异常
     */
    public void updateIfNotNull(Teacher teacher) throws Exception {
        teacherMapper.updateIfNotNull(teacher);
    }
    
    /**
     * 通过主键获取单条记录
     * 
     * @param id 主键ID
     * @return 单条记录
     */
    public Teacher selectByPrimaryKey(String id) {
        return teacherMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 通过自定义非空字段获取记录集
     * 
     * @param teacher
     */
    public List<Teacher> selectList(Teacher teacher) {
        return teacherMapper.selectList(teacher);
    }
    
}
