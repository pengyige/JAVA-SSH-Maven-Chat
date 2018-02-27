$(function (){
    /*日期控件*/
	  $('#datetimepicker').datetimepicker({
	    language:'zh-CN',
	    format:'yyyy-mm-dd',
	    autoclose:true,
	     minView:2
	  }).on('hide',function(e) {  
          $('#reg_form').data('bootstrapValidator')
          .updateStatus('date', 'NOT_VALIDATED',null) 
          .validateField('date');  //刷新后再次进行校验
  });
	  
	  
	  /*注册校验*/
	  $('#reg_form').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons: {
	                　　　　valid: 'glyphicon glyphicon-ok',
	                　　　　invalid: 'glyphicon glyphicon-remove',
	                　　　　validating: 'glyphicon glyphicon-refresh'
	         },
	         fields:{
	         	username: {
	         		validators:{
	         			notEmpty:{
	         				message: '用户名不能为空'
	         			},
	         			stringLength:{
	         				min:2,
	         				max:12,
	         				message:'用户名必须在2-12个字符之间'
	         			}
	         		}
	         	},
	         	password:{
	            	validators:{
	         			notEmpty:{
	         				message:'密码不能为空'
	         			},
	         			stringLength:{
	         				min:6,
	         				max:15,
	         				message:'密码长度必须在6-12个字符之间'	
	         			},
	         			identical:{
	         				field: 'confirmpassword',
	         				message:'两次密码不一致'
	         			}
	         		}
	         	},
	         	confirmpassword:{
	         		validators:{
	         			notEmpty:{
	         				message:'确认密码不能为空'
	         			},
	         			stringLength:{
	         				min:6,
	         				max:15,
	         				message:'密码长度必须在6-12个字符之间'	
	         			},
	         			identical:{
	         				field: 'password',
	         				message:'两次密码不一致'
	         			}
	         		}
	         	},
	         	sex:{
	         		validators:{
	         			notEmpty:{
	         				message:'性别不能为空'
	         			}
	         			
	         		}
	         	},
	         	email: {
	                validators: {
	                	notEmpty:{
	                		message:'邮箱不能为空'
	                	},
	                    emailAddress: {
	                        message: '邮箱格式有误'
	                    }
	                }
	            },
	        	date:{
	        		validators: {
	        			notEmpty:{
	        				message:'出生日期不能为空'
	        			},
	        			date:{
	        				format : 'YYYY-MM-DD',
	        				message:'日期格式有误'
	        			}
	        		}
	         	}
	         	
	         }
	         	
	        });
	  
	  /*ajax提交表单*/
	  $('#reg_btn').click(function (){
			/*再次验证，防止进来点击时的bug*/
			$('#reg_form').data('bootstrapValidator').validate();
			var bootstrapValidator = $('#reg_form').data('bootstrapValidator');
			if(bootstrapValidator.isValid()){
				/*alert('验证成功,开始提交');*/
				//JQuery在这里失效
			/*	$("form").submit();*/
				//采用原生提交
				document.getElementById("reg_form").submit();
				/*$("#reg_btn").attr("disabled",true);*/
			}
		/*	else{
				alert('失败');
			}*/
			
	
		
	  });
	  
	  
	
});