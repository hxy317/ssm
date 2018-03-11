<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/SSMall/js/jquery.min.js"></script>
</head>
<body>
BBBBBBBBBBBBBB
</body>
<script type="text/javascript">
$(function() {
	//按状态查询
	moreInfo(id)

});


function moreInfo(id){
	$.ajax({
		url : ctx + '/opr/pointsShop/shopOrder/queryItemInfo',
		data : {
			id:id
		},
		dataType : "JSON",
		type : "POST",
		traditional : true,
		success : function(resultData) {
			if(resultData.state=="0"){
				renderInfo(resultData.data);
			}else{
				layer.msg("订单详情获取失败!", {
        			icon : 0
        		});
			}
		}
	});
}
//渲染订单详情页面
function renderInfo(orderInfo){
	$("#orderModal ").modal();
	var html='';
	for(var i = 0;i<orderInfo.length;i++){
		//var skuName = orderInfo[i].skuName;
		html += '<div class="row" style="margin-top:10px;border-bottom:1px solid #d1d7d2;">'
					 	+'<div class="col-md-6">'
					 		+'<div class="form-group">'
						 			+'<label class="col-md-4 control-label">商品名称：</label>'
						 			+'<div class="col-md-8 control-label" style="text-align:left">'
						 				+''+orderInfo[i].skuName+''
						 			+'</div></div>'
					 		+'<div class="form-group">'
						 			+'<label class="col-md-4 control-label">商品价格：</label>'
						 			+'<div class="col-md-8 control-label" style="text-align:left">'
						 				+''+orderInfo[i].skuPrice+''
						 			+'</div></div>'
					 		+'<div class="form-group">'
						 			+'<label class="col-md-4 control-label">店铺名称：</label>'
						 			+'<div class="col-md-8 control-label" style="text-align:left">'
						 				+''+orderInfo[i].storeName+''
						 			+'</div></div>'
						 	+'<div class="form-group">'
							 		+'<label class="col-md-4 control-label">商品图片：</label>'
							 		+'<div class="col-md-8 control-label" style="text-align:left">'
							 		+'<img src="'+orderInfo[i].imgUrl+'" alt="商品图片" width="200" height="150">'
							 		+'</div></div></div>'
						 +'<div class="col-md-6 ">'
						 		+'<div class="form-group">'
						 			+'<label class="col-md-3 control-label">创建时间：</label>'
						 			+'<div class="col-md-7 control-label" style="text-align:left">'
						 				+''+orderInfo[i].createTime+''
						 			+'</div></div>'
							 	+'<div class="form-group">'
							 		+'<label class="col-md-3 control-label">商品积分：</label>'
							 		+'<div class="col-md-7 control-label" style="text-align:left">'
							 			+''+orderInfo[i].skuEarnings+''
							 		+'</div></div>'
							 	+'<div class="form-group">'
							 		+'<label class="col-md-3 control-label">交易数量：</label>'
							 		+'<div class="col-md-7 control-label" style="text-align:left">'
							 			+''+orderInfo[i].buyAmt+''
							 		+'</div></div>'
							 	+'<div class="form-group">'
							 		+'<label class="col-md-3 control-label">品牌名称：</label>'
							 		+'<div class="col-md-7 control-label" style="text-align:left">'
							 			+''+orderInfo[i].brandName+''
							 		+'</div></div></div></div>'
	}
	$("#orderForm").html(html)
	
}

</script>
</html>