package com.working.dao;

import java.util.List;
import java.util.Map;

import com.working.entity.Student;

/**
 * StudentMapper 
 *
 * @author  惠新宇
 * @since   1.8
 * @version 2018年03月05日 惠新宇
 */
public interface StudentDAO{
	
	/**
	 * 保存
	 * 
	 * @param student 
	 */
	void insert(Student student);

	/**
	 * 批量保存
	 * 
	 * @param student 
	 */
	void insertList(List<Student> studentList);

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
	 * @param student 
	 */
	void update(Student student);

	/**
	 * 更新非空字段
	 * <p>通过主键更新记录</p>
	 * 
	 * @param student 
	 */
	void updateIfNotNull(Student student);
	
	/**
	 * 通过主键获取单条记录
	 * 
	 * @param id  主键ID
	 * @return  单条记录
	 */
	Student selectByPrimaryKey(String id);

	/**
	 * 通过自定义非空字段获取记录集
	 * 
	 * @param student 
	 * @return  记录集
	 */
	List<Student> selectList(Student student);

	/**
     * 通过自定义非空字段获取记录集
     * 
     * @param work
     */
	List<Student> queryStudents(Map<String, String> paramMap);
}