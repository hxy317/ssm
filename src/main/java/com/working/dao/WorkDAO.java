package com.working.dao;

import java.util.List;

import com.working.entity.Work;

/**
 * WorkMapper 
 *
 * @author  惠新宇
 * @since   1.8
 * @version 2018年03月05日 惠新宇
 */
public interface WorkDAO{
	
	/**
	 * 保存
	 * 
	 * @param work 
	 */
	void insert(Work work);

	/**
	 * 批量保存
	 * 
	 * @param work 
	 */
	void insertList(List<Work> workList);

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
	 * @param work 
	 */
	void update(Work work);

	/**
	 * 更新非空字段
	 * <p>通过主键更新记录</p>
	 * 
	 * @param work 
	 */
	void updateIfNotNull(Work work);
	
	/**
	 * 通过主键获取单条记录
	 * 
	 * @param id  主键ID
	 * @return  单条记录
	 */
	Work selectByPrimaryKey(String id);

	/**
	 * 通过自定义非空字段获取记录集
	 * 
	 * @param work 
	 * @return  记录集
	 */
	List<Work> selectList(Work work);

}