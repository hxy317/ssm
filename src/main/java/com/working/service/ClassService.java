
package com.working.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.dao.ClassDAO;
import com.working.entity.Class;
import com.working.util.UUIDUtil;

/**
 * ClassService
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@Service
public class ClassService {
    
    /** classMapper接口 */
    @Autowired
    private ClassDAO classDAO;
    
    /**
     * 保存
     * 
     * @param clazz
     */
    public void insert(Class clazz) throws Exception {
        clazz.setId(UUIDUtil.generateUUID());
        classDAO.insert(clazz);
    }
    
    /**
     * 批量保存
     * 
     * @param clazz
     */
    public void insertList(List<Class> classList) throws Exception {
        classDAO.insertList(classList);
    }
    
    /**
     * 通过主键删除单条记录
     * 
     * @param id 主键ID
     * @throws Exception 出错抛出异常
     */
    public void delete(String id) throws Exception {
        classDAO.delete(id);
    }
    
    /**
     * 更新
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param clazz
     * @throws Exception 出错抛出异常
     */
    public void update(Class clazz) throws Exception {
        classDAO.update(clazz);
    }
    
    /**
     * 更新非空字段
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param clazz
     * @throws Exception 出错抛出异常
     */
    public void updateIfNotNull(Class clazz) throws Exception {
        classDAO.updateIfNotNull(clazz);
    }
    
    /**
     * 通过主键获取单条记录
     * 
     * @param id 主键ID
     * @return 单条记录
     */
    public Class selectByPrimaryKey(String id) {
        return classDAO.selectByPrimaryKey(id);
    }
    
    /**
     * 通过自定义非空字段获取记录集
     * 
     * @param clazz
     */
    public List<Class> selectList(Class clazz) {
        return classDAO.selectList(clazz);
    }
    
}
