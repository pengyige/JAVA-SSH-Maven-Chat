							SSH_Maven
1.	搭建环境
1.1	开发包
Struts2 2.3.16
Spring 3.1.2
Hibernate 4.1.7
Mysql-connector-java-5.1.21
Fastjosn-1.1.24
C3p0-0.9.5
Javaee-api-7.0
   1.2 Maven工程结构
		1.2.1 包结构
			 Cn.pengyi.domain
			 Cn.pengyi.dao
			 Cn.pengyi.dao.impl
			 Cn.pengyi.service
			 Cn.pengyi.web.action
			 Cn.pengyi.web.socket
		1.2.2 webapp结构
			Css
			Image
			Js
			WEB-INF
				Web.xml
			Index.jsp
			Register.jsp
			Success.jsp
         1.2.3 资源目录
		     Src/main/resources
   				Beans.xml
				Hibernate.cfg.xml
				Struts.xml
2.	数据库
Create databases chat;
//采用Hibernate映射自动建表
用户表
User(userId,username,password,sex,email,date);
3.	系统接口
3.1	用户模块
3.1.1	用户登入 
 url: user_login.action 
method:post
param:{username:username,password,password}
return:{result:flag}
//说明:flag=0失败,flag=1成功 	
        3.1.2  用户是否存在
			 url: user_userExist.aciton
			 method:post
			 param:{username:username}
			 return:{result:flag}
		     //说明flag=0不存在,flag=1存在

3.1.3	用户注册
url:user_register.action
method:post
param:username,password,confirmpassword,sex,email
result:用户信息存入session，重定向到首页

3.1.4	修改用户
url:user_update.action
method:post
param:user对象(包含userId的)
result:{result:flag}
//说明:flag=0修改失败;flag=1修改成功;flag=-1未登入
3.1.5	查询用户
url:user_find.action
method:post
param:userId
result:{
	username:””;
	password:””;
  sex:””;
  email:””;
  date:””;
	result:{flag};
}
//说明flag=-1 没有此用户;flag=0,服务端异常;flag=1,查找成功;若flag=-1，未登入;

3.1.5   注销用户
url:user_logout.action
method:post
param:无
result:{result:flag}
//说明flag=0注销失败 flag=1注销成功
3.1.6	用户查询，用户修改进行登入验证
