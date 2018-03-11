
package com.working.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.dao.SubjectDAO;
import com.working.entity.Subject;
import com.working.util.UUIDUtil;

/**
 * SubjectService
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@Service
public class SubjectService {
    
    /** subjectMapper接口 */
    @Autowired
    private SubjectDAO subjectMapper;
    
    /**
     * 保存
     * 
     * @param subject
     */
    public void insert(Subject subject) throws Exception {
        subject.setId(UUIDUtil.generateUUID());
        subjectMapper.insert(subject);
    }
    
    /**
     * 批量保存
     * 
     * @param subject
     */
    public void insertList(List<Subject> subjectList) throws Exception {
        subjectMapper.insertList(subjectList);
    }
    
    /**
     * 通过主键删除单条记录
     * 
     * @param id 主键ID
     * @throws Exception 出错抛出异常
     */
    public void delete(String id) throws Exception {
        subjectMapper.delete(id);
    }
    
    /**
     * 更新
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param subject
     * @throws Exception 出错抛出异常
     */
    public void update(Subject subject) throws Exception {
        subjectMapper.update(subject);
    }
    
    /**
     * 更新非空字段
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param subject
     * @throws Exception 出错抛出异常
     */
    public void updateIfNotNull(Subject subject) throws Exception {
        subjectMapper.updateIfNotNull(subject);
    }
    
    /**
     * 通过主键获取单条记录
     * 
     * @param id 主键ID
     * @return 单条记录
     */
    public Subject selectByPrimaryKey(String id) {
        return subjectMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 通过自定义非空字段获取记录集
     * 
     * @param subject
     */
    public List<Subject> selectList(Subject subject) {
        return subjectMapper.selectList(subject);
    }
    
}
