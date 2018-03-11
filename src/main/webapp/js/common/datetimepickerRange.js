$(function() {
	var today =new Date();
	$(".form_datetime").datetimepicker({
		language:'zh-CN',
		format: 'yyyy-mm-dd',
		minView:"month",
		autoclose:true,
		todayBtn:true,
		endDate:today
		});
	$('#startId').datetimepicker({
		language:'zh-CN',
		format: 'yyyy-mm-dd',
		minView:"month",
		todayBtn :"linked",
		autoclose:true,
		todayHighlight :true
	}).on('changeDate',function(e){
		var startTime =e.date;
		if(!startTime) $('#endId').datetimepicker('setStartDate','');
		$('#endId').datetimepicker('setStartDate',startTime);
	});
	$('#endId').datetimepicker({
		language:'zh-CN',
		format: 'yyyy-mm-dd',
		minView:"month",
		todayBtn :"linked",
		autoclose:true,
		todayHighlight :true
	}).on('changeDate',function(e){
		var endTime =e.date;
		if(!endTime) $('#startId').datetimepicker('setEndDate',today);
		$('#startId').datetimepicker('setEndDate',endTime);
	});
});