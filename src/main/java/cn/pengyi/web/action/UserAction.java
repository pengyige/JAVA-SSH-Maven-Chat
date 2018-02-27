package cn.pengyi.web.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.pengyi.domain.User;
import cn.pengyi.service.UserService;
import cn.pengyi.utils.BeanToMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private User user;
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

/*	//IOC方式注入session,request
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}*/
	
	
	
	//用于json数据封装
	private Map dataMap;
	public Map getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}

	//用于数据验证
	private String userId;
	private String username;
	private String password;
	private String confirmpassword;
	private int sex;
	private String email;
	private Date date;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	//用户注册
	public String register(){
		//1.表单校验
		
		//封装数据
		user = new User(username,password,sex,email,date);
		
		//2.业务逻辑,保存数据
		userService.save(user);
		
		//3.视图转发
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession();  
        session.put("user",user); 
		return SUCCESS;
	}
	
	
	//用户登入
	public String login(){
		user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		user = userService.findUser(user);
		
		//保存到session
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession();  
        session.put("user",user); 
		
        dataMap = new HashMap<String,Object>();
        if(user != null)
        {
        	dataMap.put("result", "1");
        }else{
        	dataMap.put("result", "0");
        }
        
        return "userjson";
	}
	

	
	//用户是否存在
	public String userExists(){
		//1.封装数据
			
				
		//2.业务逻辑
		boolean flag = userService.findUserIsExist(username);
				
		//3.视图转发
		dataMap = new HashMap<String,Object>();
		if(flag){
			dataMap.put("result", "1");
		}else{
			dataMap.put("result", "0");
		}
				
		return "userjson";
	}
	
	//注销用户
	public String logout(){
		dataMap = new HashMap<String,Object>();
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession();  
		if(session.containsKey("user")){
			session.remove("user");
			dataMap.put("result", "1");
		}else{
			dataMap.put("result", "0");
		}
        
		return "userjson";
	}

	//修改用户页面
	public  String update(){
		//1.获取数据
		user = new User(userId,username,password,sex,email,date);
		dataMap = new HashMap<String,Object>();
		
		try{
			userService.updateUser(user);
			dataMap.put("result", "1");
		}catch(Exception e){
			dataMap.put("result", "0");
		}
		
		return "userjson";
	}
	
	//查询用户
	public String find(){
		
		dataMap = new HashMap<String,Object>();
		User user = userService.findUserById(userId);
		if(user != null){
			try {
				BeanToMap.transformBeanToMap(user, dataMap);
				dataMap.put("result","1");
			} catch (Exception e) {
				dataMap.put("result","0");
			}finally{
				return "userjson";
			}
		}else{
			dataMap.put("result", "-1");
			return "userjson";
		}
		
		
	}
	
	
	//自定义验证
/*	public void validateRegister() {
	    if (username == null || "".equals(username.trim())) {
	        addFieldError("username", "用户名不能为空");
	    }
	    if (password == null || !password.matches("\\d{3,6}")) {
	        addFieldError("password", "密码不能为空且必须是3~6位的数字");
	    }
	}*/

}
