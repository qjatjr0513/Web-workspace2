<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

<input type="text" id="sender" size="10" placeholder="보내는 이름">
<input type="text" id="receiver" size="10" placeholder="받는 사람 이름">
<input type="text" id="msg" placeholder="전송할 메시지 입력">
<button onclick="sendMsg();">전송</button>
<div id="msgContainer">

</div>

<script>
	//웹소켓 서버에 연결하기
	//WebSocket객체를 생성하기
	//const socket = new WebSocket("ws://192.168.120.84:8001/<%=request.getContextPath()%>/chatting.do");
	const socket = new WebSocket("ws://192.168.120.84:8001/<%=request.getContextPath()%>/chatting2.do");
	// https://localhost:8001/~~
	// http -> ws:주소
	// https -> wss:주소
	
	//socket 설저아기
	//1. 접속후 실행되는 이벤트 핸들러 등록하기
	socket.onopen = function(e){
		console.log("웹 소켓에 접속 성공.");
		console.log(e);
	}
	//2. 웹소켓 서버에서 sendText, sendObject메소드를 실행하면 실행되는 함수
	socket.onmessage = function(e){
		console.log("메세지 수신");
		//수신된 데이터를 받으려면 이벤트 객체(e)의 data 속성을 이용함.
		console.log(e);
		console.log(e.data);
		// Object 형태의 String데이터를 객체로 변환해주기.
		//JSON.parse(e.data);
		console.log(JSON.parse(e.data));
		
		let msg = JSON.parse(e.data);
		if(msg["sender"] == $("#sender").val()){
			$("#msgContainer").append($("<p>").text("<"+msg["sender"]+">"+msg["msg"]).css("text-align", "left"));
		} else{
			$("#msgContainer").append($("<p>").text("<"+msg["sender"]+">"+msg["msg"]).css("text-align", "right"));
		}
		
		
		
// 		let msg = e.data.split(",");
// 		if(msg[0] == $("#sender").val()){
// 			$("#msgContainer").append($("<p>").text("<"+msg[0]+">"+msg[2]).css("text-align", "left"));//msg[0]: 발송자, msg[2]: 메세지
// 		}else{
// 			$("#msgContainer").append($("<p>").text("<"+msg[1]+">"+msg[2]).css("text-align", "right"));//msg[1]: 수신자, msg[2]: 메세지
// 		}
	}
	
	//3. 웹소켓 서버에서 메세지를 전송하는 함수.
	const sendMsg = () => {
		// 전송할 메세지 전처리
		// 전처리한 메세지를 전송하는 방법 : socket.send(데이터);
		// 발송자, 수신자, 메세지 내용
		//socket.send($("#sender").val()+","+$("#receiver").val()+","+$("#msg").val()); -> 1번 방법
// 		{sender : $("#sender").val(),
// 		 receiver : $("#receiver").val(),,
// 		 msg 	: $("#msg").val()}

		let msg = new Message($("#sender").val(), $("#receiver").val(), $("#msg").val());
		console.log(msg);
		
		// JSION.stringify(Object)함수를 이용해서 객체를 JSON오브젝트로 변환시킴
		console.log(JSON.stringify(msg));
		socket.send(JSON.stringify(msg));
	};
	
	function Message(sender, receiver, msg){
		// this = {}
		
		
		this.sender = sender;
		this.receiver = receiver;
		this.msg = msg;
		
		// return this
	}
		
	
	
	
</script>
















</body>
</html>