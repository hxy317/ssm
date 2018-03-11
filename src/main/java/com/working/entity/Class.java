package com.working.entity;

/**
 * class-->Class 
 *
 * @author  惠新宇
 * @since   1.8
 * @version 2018年03月05日 惠新宇
 */
public class Class{
	
	/** 主键 */
	private String id;

	/** 班级编号 */
	private String classNum;

	/** 班级名称 */
	private String className;

	/** 教师工号 */
	private String teacherNum;

	/**
	 * 主键
	 * @param id 设置 id 属性值为参数值 id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	/**
	 * 主键
     * @return 获取id属性值
     */
	public String getId() {
		return this.id;	
	}
	
	/**
	 * 班级编号
	 * @param classNum 设置 classNum 属性值为参数值 classNum
	 */
	public void setClassNum(String classNum) {
		this.classNum = classNum == null ? null : classNum.trim();
	}
	/**
	 * 班级编号
     * @return 获取classNum属性值
     */
	public String getClassNum() {
		return this.classNum;	
	}
	
	/**
	 * 班级名称
	 * @param className 设置 className 属性值为参数值 className
	 */
	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}
	/**
	 * 班级名称
     * @return 获取className属性值
     */
	public String getClassName() {
		return this.className;	
	}
	
	/**
	 * 教师工号
	 * @param teacherNum 设置 teacherNum 属性值为参数值 teacherNum
	 */
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum == null ? null : teacherNum.trim();
	}
	/**
	 * 教师工号
     * @return 获取teacherNum属性值
     */
	public String getTeacherNum() {
		return this.teacherNum;	
	}
	
	
}
	

	
