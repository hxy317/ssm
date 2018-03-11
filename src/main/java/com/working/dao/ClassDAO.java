
package com.working.dao;

import java.util.List;

import com.working.entity.Class;

/**
 * ClassMapper
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
public interface ClassDAO {
    
    /**
     * 保存
     * 
     * @param clazz
     */
    void insert(Class clazz);
    
    /**
     * 批量保存
     * 
     * @param clazz
     */
    void insertList(List<Class> classList);
    
    /**
     * 通过主键删除单条记录
     * 
     * @param id 主键ID
     */
    void delete(String id);
    
    /**
     * 更新
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param clazz
     */
    void update(Class clazz);
    
    /**
     * 更新非空字段
     * <p>
     * 通过主键更新记录
     * </p>
     * 
     * @param clazz
     */
    void updateIfNotNull(Class clazz);
    
    /**
     * 通过主键获取单条记录
     * 
     * @param id 主键ID
     * @return 单条记录
     */
    Class selectByPrimaryKey(String id);
    
    /**
     * 通过自定义非空字段获取记录集
     * 
     * @param clazz
     * @return 记录集
     */
    List<Class> selectList(Class clazz);
    
}
