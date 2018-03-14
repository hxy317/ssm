
package com.working.entity;

/**
 * work-->Work
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
public class Work {
    
    /** 主键 */
    private String id;
    
    /** 作业题目 */
    private String title;
    
    /** 提交人(老师编号) */
    private String teacherNum;
    
    /** 老师姓名 */
    private String teacherName;
    
    /** 提交url */
    private String publishUrl;
    
    /** 作业状态 */
    private String state;
    
    /** 班级编号 */
    private String classNum;
    
    /** 班级名称 */
    private String className;
    
    /** 科目编号 */
    private String subNum;
    
    /** 科目名称 */
    private String subName;
    
    /** 学生编号 */
    private String stuNum;
    
    /** 学生名称 */
    private String stuName;
    
    /** 提交url */
    private String submitUrl;
    
    /** 修改时间 */
    private java.sql.Timestamp updateTime;
    
    /**
     * 主键
     * 
     * @param id 设置 id 属性值为参数值 id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
    /**
     * 主键
     * 
     * @return 获取id属性值
     */
    public String getId() {
        return this.id;
    }
    
    /**
     * 作业题目
     * 
     * @param title 设置 title 属性值为参数值 title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
    /**
     * 作业题目
     * 
     * @return 获取title属性值
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * 提交人(老师编号)
     * 
     * @param teacherNum 设置 teacherNum 属性值为参数值 teacherNum
     */
    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum == null ? null : teacherNum.trim();
    }
    
    /**
     * 提交人(老师编号)
     * 
     * @return 获取teacherNum属性值
     */
    public String getTeacherNum() {
        return this.teacherNum;
    }
    
    /**
     * 老师姓名
     * 
     * @param teacherName 设置 teacherName 属性值为参数值 teacherName
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }
    
    /**
     * 老师姓名
     * 
     * @return 获取teacherName属性值
     */
    public String getTeacherName() {
        return this.teacherName;
    }
    
    /**
     * 提交url
     * 
     * @param publishUrl 设置 publishUrl 属性值为参数值 publishUrl
     */
    public void setPublishUrl(String publishUrl) {
        this.publishUrl = publishUrl == null ? null : publishUrl.trim();
    }
    
    /**
     * 提交url
     * 
     * @return 获取publishUrl属性值
     */
    public String getPublishUrl() {
        return this.publishUrl;
    }
    
    /**
     * 作业状态
     * 
     * @param state 设置 state 属性值为参数值 state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
    
    /**
     * 作业状态
     * 
     * @return 获取state属性值
     */
    public String getState() {
        return this.state;
    }
    
    /**
     * 班级编号
     * 
     * @param classNum 设置 classNum 属性值为参数值 classNum
     */
    public void setClassNum(String classNum) {
        this.classNum = classNum == null ? null : classNum.trim();
    }
    
    /**
     * 班级编号
     * 
     * @return 获取classNum属性值
     */
    public String getClassNum() {
        return this.classNum;
    }
    
    /**
     * 班级名称
     * 
     * @param className 设置 className 属性值为参数值 className
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
    
    /**
     * 班级名称
     * 
     * @return 获取className属性值
     */
    public String getClassName() {
        return this.className;
    }
    
    /**
     * 科目编号
     * 
     * @param subNum 设置 subNum 属性值为参数值 subNum
     */
    public void setSubNum(String subNum) {
        this.subNum = subNum == null ? null : subNum.trim();
    }
    
    /**
     * 科目编号
     * 
     * @return 获取subNum属性值
     */
    public String getSubNum() {
        return this.subNum;
    }
    
    /**
     * 科目名称
     * 
     * @param subName 设置 subName 属性值为参数值 subName
     */
    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }
    
    /**
     * 科目名称
     * 
     * @return 获取subName属性值
     */
    public String getSubName() {
        return this.subName;
    }
    
    /**
     * 学生编号
     * 
     * @param stuNum 设置 stuNum 属性值为参数值 stuNum
     */
    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }
    
    /**
     * 学生编号
     * 
     * @return 获取stuNum属性值
     */
    public String getStuNum() {
        return this.stuNum;
    }
    
    /**
     * 学生名称
     * 
     * @param stuName 设置 stuName 属性值为参数值 stuName
     */
    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }
    
    /**
     * 学生名称
     * 
     * @return 获取stuName属性值
     */
    public String getStuName() {
        return this.stuName;
    }
    
    /**
     * 提交url
     * 
     * @param submitUrl 设置 submitUrl 属性值为参数值 submitUrl
     */
    public void setSubmitUrl(String submitUrl) {
        this.submitUrl = submitUrl == null ? null : submitUrl.trim();
    }
    
    /**
     * 提交url
     * 
     * @return 获取submitUrl属性值
     */
    public String getSubmitUrl() {
        return this.submitUrl;
    }
    
    /**
     * 修改时间
     * 
     * @param updateTime 设置 updateTime 属性值为参数值 updateTime
     */
    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    
    /**
     * 修改时间
     * 
     * @return 获取updateTime属性值
     */
    public java.sql.Timestamp getUpdateTime() {
        return this.updateTime;
    }
    
}
