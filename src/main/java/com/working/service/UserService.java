package com.working.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.dao.UserDAO;
import com.working.entity.Student;
import com.working.entity.Teacher;

/**
 * 商品业务接口
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	/**
     * 商品列表查询
     * 
     * @param student 学生信息
     */
	public void saveByStu(Student student) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		student.setId(uuid);
		userDAO.saveByStu(student);
	}
	/**
     * 商品列表查询
     * 
     * @param teacher 教师信息
     */
	public void saveByTea(Teacher teacher) {
		userDAO.saveByTea(teacher);
	}
}
