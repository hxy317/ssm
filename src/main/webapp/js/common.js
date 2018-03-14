function checkUrl(bidUrl) {
	var urlRegExp = /^((https|http)?:\/\/)+[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
	if (!urlRegExp.test(bidUrl)) {
		// alert("链接不规范,请重新填写!");
		return false;
	}
	return true;
}
Date.prototype.format = function(format) {
	var o = {
			"M+": this.getMonth() + 1,
			// month
			"d+": this.getDate(),
			// day
			"H+": this.getHours(),
			// hour
			"m+": this.getMinutes(),
			// minute
			"s+": this.getSeconds(),
			// second
			"q+": Math.floor((this.getMonth() + 3) / 3),
			// quarter
			"S": this.getMilliseconds()
			// millisecond
			};
	if (/(y+)/.test(format) || /(Y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};
//时间戳转换格式为"yyyy-MM-dd HH:mm:ss"的字符串
function timestampformat(timestamp) {
	return (new Date(timestamp)).format("yyyy-MM-dd HH:mm:ss");
}

function getRootPath(){  
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp  
    var curWwwPath=window.document.location.href;  
    //获取主机地址之后的目录，如： /uimcardprj/share/meun.jsp  
    var pathName=window.document.location.pathname;  
    var pos=curWwwPath.indexOf(pathName);  
    //获取主机地址，如： http://localhost:8083  
    var localhostPaht=curWwwPath.substring(0,pos);  
    //获取带"/"的项目名，如：/uimcardprj  
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
    return(localhostPaht+projectName);  
}

//bootstrap-table表单查询条件
function queryParams(params) {
	var query = $("#searchForm").serializeJSON();
	query["pageNumber"] = params.pageNumber;
	query["pageSize"] = params.pageSize;
	if (params.sortName) {
		query["sortName"] = params.sortName;
		query["sortOrder"] = params.sortOrder;
	}
	return query;
}

/**
 * 表单属性转json
 * <p>
 * 去除空字段
 */
$.fn.serializeJSON = function() {
	var json = {};
	var form = this.serializeArray();
	$.each(form, function() {
		if (this.value) {
			if (json[this.name]) {
				if (!json[this.name].push) {
					json[this.name] = [ json[this.name] ];
				}
				json[this.name].push(this.value);
			} else {
				json[this.name] = this.value.trim();
			}
		}
	});
	return json;
}

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

$(function(){
	
	// 后退
	$(".back").click(function() {
		history.back();
		return;
	});
	
	$(window).resize(function() {
		$('[data-toggle="table"]').bootstrapTable('resetView');
	});
	
})
