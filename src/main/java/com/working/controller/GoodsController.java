
package com.working.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.working.entity.Goods;
import com.working.service.GoodsService;

@RestController
@RequestMapping("/user")
public class GoodsController {
    
    @Autowired
    private GoodsService goodsService;
    
    /**
     * 商品列表查询
     * 
     * @param pageSize 每页行数
     * @param pageNumber 第几页
     * @return JQPage 商品列表
     * @throws Exception e
     */
    @RequestMapping("/list")
    public Map<String, Object> queryOrderList(String id) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Goods> goodsLst = goodsService.queryOrderList(id);
        resultMap.put("data", goodsLst);
        return resultMap;
    }
    @RequestMapping("/test")
    public Map<String, Object> test(){
    	 Map<String, Object> resultMap = new HashMap<String, Object>();
         List<Goods> goodsLst = goodsService.queryOrderList("1");
         resultMap.put("data", goodsLst);
         return resultMap;
    }
}
