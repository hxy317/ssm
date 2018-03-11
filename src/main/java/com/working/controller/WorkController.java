package com.working.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.service.WorkService;


/**
 * Work 
 *
 * @author  惠新宇
 * @since   1.8
 * @version 2018年03月05日 惠新宇
 */
@RestController
@RequestMapping("/api/v1/work/*")
public class WorkController{

	/** workService  */
	@Autowired
	private WorkService workService;

	
}
	

