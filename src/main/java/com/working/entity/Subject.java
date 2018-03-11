package com.working.entity;

/**
 * subject-->Subject 
 *
 * @author  惠新宇
 * @since   1.8
 * @version 2018年03月05日 惠新宇
 */
public class Subject{
	
	/**  */
	private String id;

	/**  */
	private String subNum;

	/**  */
	private String subName;

	/**  */
	private String teacherNum;

	/**
	 * 
	 * @param id 设置 id 属性值为参数值 id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	/**
	 * 
     * @return 获取id属性值
     */
	public String getId() {
		return this.id;	
	}
	
	/**
	 * 
	 * @param subNum 设置 subNum 属性值为参数值 subNum
	 */
	public void setSubNum(String subNum) {
		this.subNum = subNum == null ? null : subNum.trim();
	}
	/**
	 * 
     * @return 获取subNum属性值
     */
	public String getSubNum() {
		return this.subNum;	
	}
	
	/**
	 * 
	 * @param subName 设置 subName 属性值为参数值 subName
	 */
	public void setSubName(String subName) {
		this.subName = subName == null ? null : subName.trim();
	}
	/**
	 * 
     * @return 获取subName属性值
     */
	public String getSubName() {
		return this.subName;	
	}
	
	/**
	 * 
	 * @param teacherNum 设置 teacherNum 属性值为参数值 teacherNum
	 */
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum == null ? null : teacherNum.trim();
	}
	/**
	 * 
     * @return 获取teacherNum属性值
     */
	public String getTeacherNum() {
		return this.teacherNum;	
	}
	
	
}
	

	
