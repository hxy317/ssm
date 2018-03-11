
package com.working.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.working.dao.GoodsDAO;
import com.working.entity.Goods;

/**
 * 商品业务接口
 *
 */
@Service
public class GoodsService {
    
    @Autowired
    private GoodsDAO goodsDAO;
    
    public List<Goods> queryOrderList(String id) {
        return goodsDAO.queryOrderList();
    }
}
