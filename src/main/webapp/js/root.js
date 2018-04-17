//封装班级列表参数
function queryClassParams(params) {
	var query = $("#searchClassForm").serializeJSON();
	query["pageNumber"] = params.pageNumber;
	query["pageSize"] = params.pageSize;
	if (params.sortName) {
		query["sortName"] = params.sortName;
		query["sortOrder"] = params.sortOrder;
	}
	return query;
}
//封装课程列表参数
function querySubjectParams(params) {
	var query = $("#searchSubjectForm").serializeJSON();
	query["pageNumber"] = params.pageNumber;
	query["pageSize"] = params.pageSize;
	if (params.sortName) {
		query["sortName"] = params.sortName;
		query["sortOrder"] = params.sortOrder;
	}
	return query;
}
//封装班级列表参数
function queryStudentParams(params) {
	var query = $("#searchStudentForm").serializeJSON();
	query["pageNumber"] = params.pageNumber;
	query["pageSize"] = params.pageSize;
	if (params.sortName) {
		query["sortName"] = params.sortName;
		query["sortOrder"] = params.sortOrder;
	}
	return query;
}
//封装班级列表参数
function queryTeacherParams(params) {
	var query = $("#searchTeacherForm").serializeJSON();
	query["pageNumber"] = params.pageNumber;
	query["pageSize"] = params.pageSize;
	if (params.sortName) {
		query["sortName"] = params.sortName;
		query["sortOrder"] = params.sortOrder;
	}
	return query;
}

/*//表单提交前再进行一次验证
function classSubmitFn() {
  	var bootstrapValidator = $("#classForm").data("bootstrapValidator");
  	bootstrapValidator.validate();
  	return bootstrapValidator.isValid();
}
//表单验证
function classValidate(){
	$("#classForm").bootstrapValidator({
	    message: 'This value is not valid',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	        classNum: {
	        	message: "班级编号校验失败",
	        	validators: {
	        		notEmpty: {
	        			message: "班级编号不能为空"
	        		}
	        	}
	        },
	        className: {
	        	message: "班级名称校验失败",
	        	validators: {
	        		notEmpty: {
	        			message: "班级名称不能为空"
	        		}
	        	}
	        },
	        teacherNum: {
	        	message: "教师编号校验失败",
	        	validators: {
	        		notEmpty: {
	        			message: "教师编号不能为空"
	        		}
	        	}
	        }
	    }
	});
}


//表单提交前再进行一次验证
function subjectSubmitFn() {
	var bootstrapValidator = $("#subjectForm").data("bootstrapValidator");
	bootstrapValidator.validate();
	return bootstrapValidator.isValid();
}
//表单验证
function subjectValidate(){
	$("#subjectForm").bootstrapValidator({
	    message: 'This value is not valid',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	    	subjectNum: {
	        	message: "课程编号校验失败",
	        	validators: {
	        		notEmpty: {
	        			message: "课程编号不能为空"
	        		}
	        	}
	        },
	        subjectName: {
	        	message: "课程名称校验失败",
	        	validators: {
	        		notEmpty: {
	        			message: "课程名称不能为空"
	        		}
	        	}
	        },
	        teacherNum: {
	        	message: "教师编号校验失败",
	        	validators: {
	        		notEmpty: {
	        			message: "教师编号不能为空"
	        		}
	        	}
	        }
	    }
	});
}*/