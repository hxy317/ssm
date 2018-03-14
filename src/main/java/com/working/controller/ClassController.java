
package com.working.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.entity.Class;
import com.working.service.ClassService;

/**
 * Class
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@RestController
@RequestMapping("/class/*")
public class ClassController {
    
    /** classService */
    @Autowired
    private ClassService classService;
    
    /**
     * 客服问题列表查询
     * 
     * @param pageSize 每页行数
     * @param pageNumber 第几页
     * @return JQPage 商品列表
     * @throws Exception e
     */
    @RequestMapping("/list")
    public Map<String, Object> classList(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Class> classLst = classService.selectList(new Class());
        resultMap.put("data", classLst);
        resultMap.put("msg", "查询成功");
        resultMap.put("state", "0");
        
        return resultMap;
        
    }
    
    public static void main(String[] args) {
		
    	String str = "abcdefg";
    	String str3 = exchange(str);
    	System.out.println(str3);
	}
    public static String exchange(String str) {
    	if(str!=null&&str.length()>0) {
    		return exchange(str.substring(1))+str.charAt(0);
    	}
    	return str;
    }
}
