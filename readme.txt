							SSH_Maven
1.	�����
1.1	������
Struts2 2.3.16
Spring 3.1.2
Hibernate 4.1.7
Mysql-connector-java-5.1.21
Fastjosn-1.1.24
C3p0-0.9.5
Javaee-api-7.0
   1.2 Maven���̽ṹ
		1.2.1 ���ṹ
			 Cn.pengyi.domain
			 Cn.pengyi.dao
			 Cn.pengyi.dao.impl
			 Cn.pengyi.service
			 Cn.pengyi.web.action
			 Cn.pengyi.web.socket
		1.2.2 webapp�ṹ
			Css
			Image
			Js
			WEB-INF
				Web.xml
			Index.jsp
			Register.jsp
			Success.jsp
         1.2.3 ��ԴĿ¼
		     Src/main/resources
   				Beans.xml
				Hibernate.cfg.xml
				Struts.xml
2.	���ݿ�
Create databases chat;
//����Hibernateӳ���Զ�����
�û���
User(userId,username,password,sex,email,date);
3.	ϵͳ�ӿ�
3.1	�û�ģ��
3.1.1	�û����� 
 url: user_login.action 
method:post
param:{username:username,password,password}
return:{result:flag}
//˵��:flag=0ʧ��,flag=1�ɹ� 	
        3.1.2  �û��Ƿ����
			 url: user_userExist.aciton
			 method:post
			 param:{username:username}
			 return:{result:flag}
		     //˵��flag=0������,flag=1����

3.1.3	�û�ע��
url:user_register.action
method:post
param:username,password,confirmpassword,sex,email
result:�û���Ϣ����session���ض�����ҳ

3.1.4	�޸��û�
url:user_update.action
method:post
param:user����(����userId��)
result:{result:flag}
//˵��:flag=0�޸�ʧ��;flag=1�޸ĳɹ�;flag=-1δ����
3.1.5	��ѯ�û�
url:user_find.action
method:post
param:userId
result:{
	username:����;
	password:����;
  sex:����;
  email:����;
  date:����;
	result:{flag};
}
//˵��flag=-1 û�д��û�;flag=0,������쳣;flag=1,���ҳɹ�;��flag=-1��δ����;

3.1.5   ע���û�
url:user_logout.action
method:post
param:��
result:{result:flag}
//˵��flag=0ע��ʧ�� flag=1ע���ɹ�
3.1.6	�û���ѯ���û��޸Ľ��е�����֤
