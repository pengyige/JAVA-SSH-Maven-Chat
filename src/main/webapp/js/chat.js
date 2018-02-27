/*页面加载完调用*/
$(function (){
	var username = "";
	var webSocketUrl = "ws://127.0.0.1:8080/SSH_Maven/websocket";
	
	var imageUrl = "image/commonPicture/pic"+getPicIndex()+".jpg"
	var webSocket = null;


	/*开始连接*/
	createWebSocket();
	/*发送消息*/
	$("#btn_send").click(function (){

		if(webSocket == null){
			alert("还没有连接到服务器!无法发送！");
			return;
		}

		if(username == ""){
		  username = prompt("请输入一个临时ID:");
		}
		
		var content = $("#ta").val();
		if(content == ""){
			alert("内容不能为空!");
			return;
		}

		/*
			附加一个参数type：
			0:表达聊天的消息
			1:表示用户刚进入系统的信息
			2：表达用户离开系统，发送消息
		*/

		/*发送给服务器的JSON格式的String对象*/
		var messageJson = JSON.stringify({
			username : username,
			imageUrl : imageUrl,
			content : content,
			type : "0"
		});

		webSocket.send(messageJson);
		$("#ta").val("");

	});

	/*清空内容*/
	$("#btn_clean").click(function (){
		$("#ta").val("");
	});

	/*/*窗口关闭时执行*/
/*	$(window).unload(function (){
		alert("88");
	});*/


	/*用于创建webSocket*/
	function createWebSocket(){
		if("WebSocket" in window){
			webSocket = new WebSocket(webSocketUrl);
			
		}else if ('MozWebSocket' in window){
			webSocket = new MozWebSocket(webSocketUrl);
		}else {
			alert("您的浏览器不支持WebSocket!");
			return ;
		}
	
		webSocket.onopen = connWebSocketEvent;
		webSocket.onmessage = messWebSocketEvent;
		webSocket.onclose = closeWeBSocketEvent;
	}

	/*连接事件*/
	function connWebSocketEvent(){
		var messageJson = JSON.stringify({
			username : "游客",
			imageUrl : imageUrl,
			type : "1"
		});

		webSocket.send(messageJson);
	}

	/*收到消息事件*/
	function messWebSocketEvent(ev){
		var message = ev.data;
		/*alert("服务器返回的数据为:"+message);*/
		var messageJson = eval("("+message+")");
		//1:表达新用户连接到服务器,更新列表
		if(messageJson.type == "1")
		{
			addUserInfo(messageJson);
			return;
		}

		if(messageJson.type == "2"){
			alert("系统消息");
			sendLeaveMessage(messageJson);
			return;
		}

		addChatList(messageJson);
		

	}

	/*关闭事件*/
	function closeWeBSocketEvent(){
		/*alert("退出连接");*/
		/*var messageJson = JSON.stringify({
			username : username,
			type : "2"
		});

		webSocket.send(messageJson);*/
	}

	/*产生游客图片下标*/
	function getPicIndex(){
		return Math.round(Math.random()*3+1);
	}
	
	
	/*向聊天List中添加聊天消息*/
	function addChatList(messageJson){
		//将字符串对象转为JSON对象
		
		
		var tempLi = $(".my_li:first").clone();
		tempLi.show();
		tempLi.appendTo(".my_ul");
		//设置图像，内容，时间
		tempLi.find("img").attr("src",messageJson.imageUrl);
		tempLi.find("h6").html(messageJson.date);
		tempLi.find(".chat_content").html(messageJson.username+":"+messageJson.content);
		
		//滚动条移到到最下
		$("#chat_list_div").scrollTop(9999);
		
		
	}

	/*向聊天List添加离开消息*/
	function sendLeaveMessage(messageJson){

		var tempLi = $(".li_leave:first").clone();
		tempLi.show();
		tempLi.appendTo(".my_ul");
		/*设置离开的用户的姓名*/
		tempLi.find("span").html("系统信息:"+messageJson.username+"离开了系统!");
	}


	/*向列表中添加图片和名字*/
	function addUserInfo(messageJson){
		var tempLi = $(".my_li_right:first").clone();
		tempLi.show();
		tempLi.appendTo(".my_ul_right");
		//设置图像和名称
		tempLi.find("img").attr("src",messageJson.imageUrl);
		tempLi.find(".username_div").html(messageJson.username);
		$("#listuser_div").scrollTop(9999);
	
	}
	
})