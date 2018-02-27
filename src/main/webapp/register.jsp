<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>chat</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=yes">

    <!-- 引入css -->
   	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!--    	<link rel="stylesheet" type="text/css" href="css/index.css"> -->
   	<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css">
    <!-- 引入js -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript" src="js/register.js"></script>


    <style type="text/css">
      #reg_form{
        text-align: center;
      }

      #reg_form  > div{
        margin-top: 25px;
      }

      body{
        background: url(image/bg/form_bg.jpg) no-repeat center fixed;
      -webkit-background-size: cover;
       -moz-background-size: cover;
      -o-background-size: cover;
      background-size: cover;
      }
      
      .row{
      	margin-top:20px;
      }
    </style>
   
</head>
<body >
   <div style="width: 400px;margin:0 auto;margin-top:120px;  border:1px solid #ffcc00;background:#fffff7;opacity: 0.9;" >
        <form id="reg_form" class="form-horizontal" action="${pageContext.request.contextPath }/user_register.action" method="post">
            <h3 class="form-title">快速注册</h3>
            <hr />
       		<div>
       			<s:fielderror></s:fielderror>
       		</div>
            <div  class="form-group">
              <div class="row">
	                <label for="username" class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4 "  >用户名:</label>
	                <div class="col-xs-4 col-sm-4 col-md-6 col-lg-6 ">
	               		 <input id="username" class="form-control required" type="text" name="username" placeholder="请输入用户名" autofocus="autofocus" >
             		</div>
              </div>

              <div class="row">
                <label for="password" class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4" >密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                <div class="col-xs-4 col-sm-4 col-md-6 col-lg-6 ">
                	<input id="password" class="form-control required" type="password" name="password" placeholder="请输入密码"
                	/>
                </div>
              </div>

              <div class="row">
                <label for="again_password" class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4" >确认密码:</label>
                <div class="col-xs-4 col-sm-4 col-md-6 col-lg-6 ">
               	 <input id="again_password" class="form-control required" type="password" name="confirmpassword" placeholder="请再次输入密码"
               	 />
               	 </div>
               </div>
            

              <div class="row">
                <label for="sex"  class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4">性&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
                 <div class="col-xs-4 col-sm-4 col-md-6 col-lg-6 ">
                  <input id="sex" type="radio" name="sex" value="0"  >男&nbsp;&nbsp;
                   <input type="radio" name="sex" value="1"  >女  
                 </div>
              </div>

              <div class="row">
                 <label for="email" class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4" >邮&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>
                	<div class="col-xs-4 col-sm-4 col-md-6 col-lg-6 ">
                 <input id="email" type="text" name="email" class="form-control required " > 
             	</div>
              </div>


              
              <div class="row">
                     <label for="date" class="control-label col-xs-4 col-sm-4 col-md-4 col-lg-4">出生日期:</label>
                     <div class="col-xs-4 col-sm-4 col-md-6 col-lg-6 ">
                      <input type="text" class="form-control  date" id="datetimepicker" name="date" data-date-format="yyyy-mm-dd"  readonly 
                  		    />
                  	</div>
              </div>
                      
                   
                       <!--  <span class="input-group-addon">  
                            <span class="glyphicon glyphicon-calendar" style="margin-left: 0px"></span>  
                        </span>   -->
              </div> 

              
            
              <div style="margin-bottom: 20px">
              		
                     <button id="reg_btn" class="btn btn-primary" style="width: 40%;">注册</button>
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <button class="btn btn-danger " type="reset" style="width: 40%;">清空</button>
              </div>
              	

        </form>
      
   </div>
    
</body>
</html>