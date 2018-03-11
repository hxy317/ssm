
package com.working.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.service.StudentService;

/**
 * Student
 *
 * @author 惠新宇
 * @since 1.8
 * @version 2018年03月05日 惠新宇
 */
@RestController
@RequestMapping("/student/*")
public class StudentController {
    
    /** studentService */
    @Autowired
    private StudentService studentService;
    
    /**
     * 商品列表查询
     * 
     * @param pageSize 每页行数
     * @param pageNumber 第几页
     * @return JQPage 商品列表
     * @throws Exception e
     */
    @RequestMapping("/test")
    public Map<String, Object> queryOrderList() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", "");
        return resultMap;
    }
    
}
