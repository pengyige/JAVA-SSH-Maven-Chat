package cn.pengyi.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSONObject;



@ServerEndpoint("/websocket")
public class ChatWebSocket {
	//保存所有客户端session
	private static CopyOnWriteArraySet<ChatWebSocket> webSockets = new CopyOnWriteArraySet<ChatWebSocket>();
	private static int Count = 0;
	
	//客户连接时 的session
	private Session session;
	
	
	/*防止多线程对静态成员访问*/
	public static synchronized void addCount(){
		ChatWebSocket.Count++;
	}
	
	public static synchronized void subCount(){
		ChatWebSocket.Count--;
	}
	
	public static synchronized int getCount(){
		return ChatWebSocket.Count;
	}
	
	/*
	 * 连接成功时
	 * */
	@OnOpen
	public void onOpen(Session session){
		this.session = session;
		webSockets.add(this);
		System.out.println("有人连接了");
		this.addCount();
		
	}
	
	
	/*
	 * 连接关闭时
	 * */
	@OnClose
	public void close(){
		webSockets.remove(this);
		System.out.println("有人退出了");
		this.subCount();
	}
	
	/*
	 * 收到消息时
	 * message 传过来是标准的json格式数据
	 * */
	@OnMessage
	public void onMessage(String message,Session session){
		
		
		//获取客户端数据
		JSONObject messageJson = JSONObject.parseObject(message);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		messageJson.put("date",df.format(new Date()));

		//向所有session发送数据
		Iterator<ChatWebSocket> it = ChatWebSocket.webSockets.iterator(); 
		while(it.hasNext()){
			ChatWebSocket cw = it.next();
			cw.session.getAsyncRemote().sendText(messageJson.toJSONString());
		}
	}
	
	/*
	 * 发送错误时
	 * */
	@OnError
	public void onError(Session session,Throwable error){
		error.printStackTrace();
	}
}
