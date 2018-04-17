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

//表单提交前再进行一次验证
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
}

//表单提交前再进行一次验证
function studentSubmitFn() {
	var bootstrapValidator = $("#studentForm").data("bootstrapValidator");
	bootstrapValidator.validate();
	return bootstrapValidator.isValid();
}
//表单验证
function studentValidate(){
	$("#studentForm").bootstrapValidator({
	    message: 'This value is not valid',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	    	num: {
	            message: "学号校验失败",
	            validators: {
	                notEmpty: {
	                    message: "学号不能为空"
	                },
	                stringLength: {//检测长度  
                        min: 4,  
                        max: 30,  
                        message: '学号必须在4-30之间'  
                    }
	            }
	        },
	        password: {
	        	message: "密码校验失败",
	        	validators: {
	        		notEmpty: {
	        			message: "学号不能为空"
	        		},
	        		stringLength: {//检测长度  
                        min: 4,  
                        max: 30,  
                        message: '密码长度必须在6-30之间'  
                    },
	        	}
	        },
	        name: {
	            message: "姓名校验失败",
	            validators: {
	                notEmpty: {
	                    message: "姓名不能为空"
	                }
	            }
	        },
	        phone: {
	            message: "手机号码校验失败",
	            validators: {
	            	notEmpty: {
	                    message: "手机号不能为空"
	                },
	                regexp: {//正则验证  
                        regexp: /^[1][3,4,5,7,8][0-9]{9}$/,  
                        message: '请输入正确的手机号码'  
                    }, 
	            }
	        },
	        mail: {
	            message: "邮箱校验失败",
	            validators: {
	            	notEmpty: {
	                    message: "邮箱不能为空"
	                },
	            	emailAddress: {//验证email地址  
                        message: '请输入正确的邮箱地址'  
                    },  
	            }
	        }
	    }
	});
}

//表单提交前再进行一次验证
function teacherSubmitFn() {
	var bootstrapValidator = $("#teacherForm").data("bootstrapValidator");
	bootstrapValidator.validate();
	return bootstrapValidator.isValid();
}
//表单验证
function teacherValidate(){
	$("#teacherForm").bootstrapValidator({
	    message: 'This value is not valid',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	    	num: {
	            message: "学号校验失败",
	            validators: {
	                notEmpty: {
	                    message: "学号不能为空"
	                },
	                stringLength: {//检测长度  
                        min: 4,  
                        max: 30,  
                        message: '学号必须在4-30之间'  
                    }
	            }
	        },
	        password: {
	        	message: "密码校验失败",
	        	validators: {
	        		notEmpty: {
	        			message: "学号不能为空"
	        		},
	        		stringLength: {//检测长度  
                        min: 4,  
                        max: 30,  
                        message: '密码长度必须在6-30之间'  
                    },
	        	}
	        },
	        name: {
	            message: "姓名校验失败",
	            validators: {
	                notEmpty: {
	                    message: "姓名不能为空"
	                }
	            }
	        },
	        phone: {
	            message: "手机号码校验失败",
	            validators: {
	            	notEmpty: {
	                    message: "手机号不能为空"
	                },
	                regexp: {//正则验证  
                        regexp: /^[1][3,4,5,7,8][0-9]{9}$/,  
                        message: '请输入正确的手机号码'  
                    }, 
	            }
	        },
	        mail: {
	            message: "邮箱校验失败",
	            validators: {
	            	notEmpty: {
	                    message: "邮箱不能为空"
	                },
	            	emailAddress: {//验证email地址  
                        message: '请输入正确的邮箱地址'  
                    },  
	            }
	        }
	    }
	});
}