<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<%
    String contextPath = request.getContextPath();

	Member loginUser = (Member) session.getAttribute("loginUser");
	// 로그인전 or 로그인 실패 : null
	// 로그인 성공후 : 로그인한 회원의 정보가 담긴 member객체.
	
	String alertMsg = (String) session.getAttribute("alertMsg");
	// 서비스 요청전 : null
	// 서비스 요청성공후 : alert로 띄워줄 메시지 문구.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B CLASS</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<style>
    #login-form , #user-info{
        float: right;
    }
    #user-info a{
    	text-decoration : none;
    	color : black;
    	font-size : 12px;
    }
    .nav-area{
        background-color: black;
    }
    .menu{
        display: table-cell; /* 인라인 요소처럼 배치(일자로) */
        width: 150px;
        height: 50px;
    }
    .menu a{
        text-decoration: none;
        color: white;
        font-size: 20px;
        font-weight: bold;
        display: block; /* 한 영역 다차지하게 */
        width: 100%;
        height: 100%;
        line-height: 50px; /* 줄 간격 */
    }
    .menu a:hover{
        background-color: darkgrey;
    }
</style>
</head>
<body>
	<script>
		let msg = "<%= alertMsg%>"; // let msg = 성공적으로 로그인이 되었습니다.
		
		if(msg != "null"){
			alert(msg);
			// 알림창을 띄워준후 session에 담긴 해당메세지는 지워줘야함.
			// 안그러면 menubar.jsp가 로딩될때마다 매번 alert가 계속 뜰것
			
			<% session.removeAttribute("alertMsg");%>
		}
	</script>
    <h1 style = "text-align:center;">Welcome B Class</h1>

<div class = "login-area">
<% if(loginUser == null) { %>
    <form id = "login-form" action = "<%=contextPath%>/login.me" method = "post">
        <table>
            <tr>
                <th>아이디 : </th>
                <td><input type = "text" name = "userId" required></td>
            </tr>
            <tr>
                <th>비밀번호 : </th>
                <td><input type = "password" name = "userPwd" required></td>
            </tr>
            <tr>
                <th colspan = "2">
                    <button type = "submit">로그인</button>
                    <button type = "button" onclick = "enrollPage();">회원가입</button>
                </th>
            </tr>
        </table>
    </form>
    <script>
        function enrollPage(){
			
        	// location.href = /jsp/views/member/memberEnrollForm.jsp
        	// 웹 애플리케이션의 디렉토리 구조가 url에 노출되면 보안에 취약하다.
        	
        	// 단순한 정적인 페이지라도 반드시 servlet을 거져가기.
        	location.href = "<%=contextPath%>/enrollFrom.me";
        }
    </script>
    <% } else { %>
    	<!-- 로그인 성공 후 -->
    	<div id = "user-info">
    		<b><%= loginUser.getUserName() %></b>님 환영합니다.<br><br>
    		<div align="center">
    			<a href = "<%=contextPath%>/myPage.me">마이페이지</a>
    			<a href = "<%=contextPath%>/logout.me">로그아웃</a>
    		</div>
    	</div>
    <% } %>
    
</div>
    
    <br clear = "both"> <!-- float 속성 해제 -->
    <br>

    <div class = "nav-area" align = "center">
        <div class = "menu"><a href = "<%=contextPath%>">HOME</a></div>
        <div class = "menu"><a href = "<%=contextPath%>/list.no">공지사항</a></div>
        <div class = "menu"><a href = "<%=contextPath%>/list.bo?currentPage=1">일반게시판</a></div>
        <div class = "menu"><a href = "<%=contextPath%>/list.th">사진게시판</a></div>
    </div>


</body>
</html>