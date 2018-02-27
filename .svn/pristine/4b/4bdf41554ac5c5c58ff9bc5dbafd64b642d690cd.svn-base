$(function (){
	
	/*阻止表单默认提交*/
/*	$('#login_form').on("submit",function(event){
		return false;
	});*/
	
	/*验证登入表单*/
	$('#login_form').bootstrapValidator({
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
         			}
         		}
         	},
        },
     /*  submitHandler: function(validator, form, submitButton){
       			alert("五熊");
      	 };*/
       });
	
	/*ajax提交数据*/
	$('#submit_btn').click(function (){
		/*再次验证，避免保存了用户名和密码点击时的bug*/
		$('#login_form').data('bootstrapValidator').validate();
		var bootstrapValidator = $('#login_form').data('bootstrapValidator');
		if(bootstrapValidator.isValid()){
			var username = $('#username').val();
			var password = $('#password').val();
			
			$.ajax({
				url : '/SSH_Maven/user_login.action',
				type : 'post',
				data : {
					username : username,
					password : password
				},
				success : function(data){
					
				   if(data.result == "1")
					{
					   window.location.reload();
					}
				   else
					 {
					   alert('用户名或密码不正确！'); 
					   //使提交按钮可用
					   $('#login_form').bootstrapValidator('disableSubmitButtons', false);
					  }
				},
				error : function(){
					alert('请求失败');
					$('#login_form').bootstrapValidator('disableSubmitButtons', false);
					/*$('#submit_btn').attr("disabled",true);*/
				}
			});
		
		}

			
	});



});