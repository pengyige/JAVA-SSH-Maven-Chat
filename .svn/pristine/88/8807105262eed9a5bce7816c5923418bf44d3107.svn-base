package cn.pengyi.web.interceptor;



import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.pengyi.web.action.UserAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserLoginInterceptor extends MethodFilterInterceptor{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1.判断是否登入
		Map map = ActionContext.getContext().getSession();
		if(!map.containsKey("user")){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");  
			PrintWriter out = response.getWriter();
			String userjson = "{\"result\":\"-1\"}";
			out.println(userjson);
			out.flush();
			out.close();
			return null;
		}
		
		//2.进行下次拦截
		return invocation.invoke();
		
	}

}
