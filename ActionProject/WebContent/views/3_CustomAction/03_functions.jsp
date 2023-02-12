<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Functions Library</h1>
	
	<c:set var="str" value=" How are you? "/>
	
	str : ${str } <br>
	문자열의 길이? : ${fn:length(str) }글자입니다. <br>
	문자열의 길이 : ${str.length() } 글자입니다. <br>
	<!-- 문자열의 길이뿐만 아니라, ArrayList도 매개변수로 제시하면 사이즈 값이 리턴된다. -->
	
	모두~ 대문자로 출력 : ${fn:toUpperCase(str) }<br>
	모두~ 소문자로 출력 : ${fn:toLowerCase(str) }<br>
	
	are의 시작 인덱스 : ${fn: indexOf(str,"are") } <br>
	문자열 변환 : ${fn:replace(str, "are", "were") }<br>
	
	str : ${str } <br>
	<!-- 원본값은 아예 바뀌지 않음.  -->
	
	str에 "are"이라는 문자열이 포함되어있나? : ${fn:contains(str,'are') ? '응 포함되어있지' : '아니 없는데?' } 
	<c:if test="${!fn:contains(str, 'are') }">
		응~포함되어있어~
	</c:if>
	<br>
	문자열 앞, 뒤 공백제거 :${fn:trim(str)}<br>
	문자열 잘라주기 : ${fn:substring(str, 0, 4) }<br>
	문자열 잘라주기2 : ${fn:substringAfter(str , "are") }<br>
	문자열 나누기 : 
	<c:forEach var="s" items="${fn:split(str, ' ') }">
		${s }<br>
	</c:forEach>
	배열 합치기 : ${fn:join(fn:split(str,' ') , ',')  }<br>
	
	<c:set var="htmlStr" value="a > b || a < b"/>
	
	<c:set var="htmlStr" value="<p>여기는 p태그 안입니다만</p>"/> 
	태그를 문자열로 바꿔주는 함수 : ${fn:escapeXml(htmlStr) }
	${htmlStr }
</body>
</html>