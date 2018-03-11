package com.working.dao;

import java.util.List;

import com.working.entity.Subject;

/**
 * SubjectMapper 
 *
 * @author  惠新宇
 * @since   1.8
 * @version 2018年03月05日 惠新宇
 */
public interface SubjectDAO{
	
	/**
	 * 保存
	 * 
	 * @param subject 
	 */
	void insert(Subject subject);

	/**
	 * 批量保存
	 * 
	 * @param subject 
	 */
	void insertList(List<Subject> subjectList);

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
	 * @param subject 
	 */
	void update(Subject subject);

	/**
	 * 更新非空字段
	 * <p>通过主键更新记录</p>
	 * 
	 * @param subject 
	 */
	void updateIfNotNull(Subject subject);
	
	/**
	 * 通过主键获取单条记录
	 * 
	 * @param id  主键ID
	 * @return  单条记录
	 */
	Subject selectByPrimaryKey(String id);

	/**
	 * 通过自定义非空字段获取记录集
	 * 
	 * @param subject 
	 * @return  记录集
	 */
	List<Subject> selectList(Subject subject);

}