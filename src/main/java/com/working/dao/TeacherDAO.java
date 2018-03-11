package com.working.dao;

import java.util.List;

import com.working.entity.Teacher;

/**
 * TeacherMapper 
 *
 * @author  惠新宇
 * @since   1.8
 * @version 2018年03月05日 惠新宇
 */
public interface TeacherDAO{
	
	/**
	 * 保存
	 * 
	 * @param teacher 
	 */
	void insert(Teacher teacher);

	/**
	 * 批量保存
	 * 
	 * @param teacher 
	 */
	void insertList(List<Teacher> teacherList);

	/**
	 * 通过主键删除单条记录
	 * 
	 * @param id  主键ID
	 */
	void delete(String id);
	
	/**
	 * 更新
	 * <p>通过主键更新记录</p>
	 * 
	 * @param teacher 
	 */
	void update(Teacher teacher);

	/**
	 * 更新非空字段
	 * <p>通过主键更新记录</p>
	 * 
	 * @param teacher 
	 */
	void updateIfNotNull(Teacher teacher);
	
	/**
	 * 通过主键获取单条记录
	 * 
	 * @param id  主键ID
	 * @return  单条记录
	 */
	Teacher selectByPrimaryKey(String id);

	/**
	 * 通过自定义非空字段获取记录集
	 * 
	 * @param teacher 
	 * @return  记录集
	 */
	List<Teacher> selectList(Teacher teacher);

}