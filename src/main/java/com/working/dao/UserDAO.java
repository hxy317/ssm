package com.working.dao;

import com.working.entity.Student;
import com.working.entity.Teacher;

public interface UserDAO {

	/**
     * 商品列表查询
     * 
     * @param student 学生信息
     */
	 void saveByStu(Student student);
	 
	 /**
	     * 商品列表查询
	     * 
	     * @param teacher 教师信息
	     */
	 void saveByTea(Teacher teacher);
}
