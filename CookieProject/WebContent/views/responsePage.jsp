<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>쿠키 저장 완료.</p>

<button onclick="location.href = '<%=request.getContextPath()%>/checkCookie.do' ">저장된쿠키확인</button>

</body>
</html>