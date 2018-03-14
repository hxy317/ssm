package com.working.util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 表格显示数据
 * bootstrap Table 数据格式
 * 
 * @author  曾令鹏
 * @since   jdk1.8
 * @version 2017年12月26日 曾令鹏
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableData<T> {

	/**
	 * 总记录数
	 */
	Long total;
	
	/**
	 * 显示数据
	 */
	List<T> rows;
	
	private TableData(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	/**
	 * 客户端分页返回数据
	 * @param rows 显示数据
	 * @return
	 */
	public static <T> TableData<T> bulid(List<T> rows){
		return new TableData<>(null, rows);
	}
	
	/**
	 * 服务端分页返回数据
	 * @param total 总记录数
	 * @param rows  显示数据
	 * @return
	 */
	public static <T> TableData<T> bulid(long total, List<T> rows){
		return new TableData<>(total, rows);
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
