package com.working.entity;

/**
 * student-->Student 
 *
 * @author  惠新宇
 * @since   1.8
 * @version 2018年03月05日 惠新宇
 */
public class Student{
	
	/** 主键 */
	private String id;

	/** 学号 */
	private String num;
	
	/** 密码 */
	private String password;

	/** 姓名 */
	private String name;

	/** 性别 */
	private String sex;

	/** 电话 */
	private String phone;

	/** 邮箱 */
	private String mail;

	/** 专业班级 */
	private String grade;

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
	 * 学号
	 * @param num 设置 num 属性值为参数值 num
	 */
	public void setNum(String num) {
		this.num = num == null ? null : num.trim();
	}
	/**
	 * 学号
     * @return 获取num属性值
     */
	public String getNum() {
		return this.num;	
	}
	
	
	/**
	 * 密码
	 * @param password 设置 password 属性值为参数值 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 密码
     * @return 获取password属性值
     */
	public String getPassword() {
		return password;
	}
	/**
	 * 姓名
	 * @param name 设置 name 属性值为参数值 name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	/**
	 * 姓名
     * @return 获取name属性值
     */
	public String getName() {
		return this.name;	
	}
	
	/**
	 * 性别
	 * @param sex 设置 sex 属性值为参数值 sex
	 */
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}
	/**
	 * 性别
     * @return 获取sex属性值
     */
	public String getSex() {
		return this.sex;	
	}
	
	/**
	 * 电话
	 * @param phone 设置 phone 属性值为参数值 phone
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	/**
	 * 电话
     * @return 获取phone属性值
     */
	public String getPhone() {
		return this.phone;	
	}
	
	/**
	 * 邮箱
	 * @param mail 设置 mail 属性值为参数值 mail
	 */
	public void setMail(String mail) {
		this.mail = mail == null ? null : mail.trim();
	}
	/**
	 * 邮箱
     * @return 获取mail属性值
     */
	public String getMail() {
		return this.mail;	
	}
	
	/**
	 * 专业班级
	 * @param grade 设置 grade 属性值为参数值 grade
	 */
	public void setGrade(String grade) {
		this.grade = grade == null ? null : grade.trim();
	}
	/**
	 * 专业班级
     * @return 获取grade属性值
     */
	public String getGrade() {
		return this.grade;	
	}
	
	
}
	

	
