package com.csg.finance.service.core;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 商城微服务调用core
 * 
 * @author 刘恩希
 * 
 */
@Service
@FeignClient(name = "${shop.api.id}")
public interface ShopCore {
	
	/**
	 * 微服务调用测试商城
	 * 
	 * @return 测试结果
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/testFinanceShop")
	public String testFinanceShop();
	
	/** 微服务调用查询所有订单
	 * @param accountId   电融通ID
	 * @param state		     订单状态
	 * @return    map
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/selShopOrder",method=RequestMethod.POST)
	public Map<String, Object> selShopOrder(@RequestParam("accountId") String accountId,@RequestParam("state") String state);
	
	/** 微服务调用更新订单状态
	 * @param accountId    账户id
	 * @param id           订单id
	 * @param orderState   订单要修改的状态
	 * @return    map
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/updShopOrder",method=RequestMethod.POST)
	public Map<String, Object> updShopOrder(@RequestParam("accountId") String accountId,@RequestParam("id") String id,@RequestParam("orderState") String orderState);
	
	/** 微服务调用积分支付订单兑换
	 * @param accountId    账户id
	 * @param id           订单id
	 * @param orderNo      订单号
	 * @param totalMoney   花费积分
	 * @return    map
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/ensureExchange",method=RequestMethod.POST)
	public Map<String, Object> ensureExchange(@RequestParam("accountId") String accountId,@RequestParam("id") String id,@RequestParam("orderNo") String orderNo,@RequestParam("totalMoney") String totalMoney);

	
	
	/** ------------------------------新版商城微服务调用接口--------------------------------- */

	/** 微服务调用新版商城 查询订单列表
	 * @param accountId
	 * @param orderState
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/mall/order/orderList",method=RequestMethod.POST)
	public Map<String, Object> selectMallOrder(@RequestParam("accountId") String accountId,@RequestParam("orderState") String orderState,@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize);
	
	/** 微服务调用新版商城 订单确认接口
	 * @param accountId
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/mall/order/synReceiptConfrim",method=RequestMethod.POST)
	public Map<String, Object> confrimMallOrder(@RequestParam("accountId") String accountId,@RequestParam("orderId") String orderId);
	
	/** 微服务调用新版商城 取消订单
	 * @param accountId
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/mall/order/cancleOrder",method=RequestMethod.POST)
	public Map<String, Object> cancleOrder(@RequestParam("accountId") String accountId,@RequestParam("orderId") String orderId);
	
	/** 微服务调用新版商城 删除订单
	 * @param accountId
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/mall/order/deleteOrder",method=RequestMethod.POST)
	public Map<String, Object> deleteOrder(@RequestParam("accountId") String accountId,@RequestParam("orderId") String orderId);
	
	/** 微服务调用新版商城 兑换订单（可兑换多个订单）
	 * @param accountId
	 * @param orderIds
	 * @return
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/mall/order/exchangeOrder",method=RequestMethod.POST)
	public Map<String, Object> exchangeOrder(@RequestParam("accountId") String accountId,@RequestParam("orderIds") String orderIds);
	
	/** 微服务调用新版商城 商品详情
	 * @param accountId
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "${shop.ctx}/insApi/api/mall/order/queryOrderDetail",method=RequestMethod.POST)
	public Map<String, Object> queryOrderDetail(@RequestParam("accountId") String accountId,@RequestParam("orderId") String orderId);
	
}
