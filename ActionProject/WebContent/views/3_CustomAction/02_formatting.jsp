<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1. formatNumber</h1>
	<p>
		숫자데이터의 포맷(형식) 지정<br>
		- 표현하고자 하는 숫자데이터의 형식을 통화기호, %등 원하는 쓰임에 맞게 지정하는 태그<br><br>
		
		&lt;fmt:formatNumber value="출력할값" groupingUsed="true/false" type="percent/currency" currencySymboll="$"/&gt;<br>
	</p>
	
	<c:set var="num1" value="123456789"/>
	<c:set var="num2" value="0.75"/>
	<c:set var="num3" value="50000"/>
	
	그냥출력 : ${num1 } <br>
	세자리마다 구분혀여 출력 : <fmt:formatNumber value="${num1 }"/> <br>
	숫자 그대로 출력 : <fmt:formatNumber value="${num1}" groupingUsed="false"/> <br>
	<!-- 
		3자리수마다 ,가 찍혀있음.
		- groupingUsed 기본값 : true(,로 구분자가 찍힘)
		즉, groupingUsed는 숫자 단위의 구분자(,) 표시 지정 여부 
	 -->
	
	percent : <fmt:formatNumber value="${num2 }" type="percent"/><br>
	<!-- 
		type="percent" : 소숫점을 백분율로 변경해서 보여줌
	 -->
	 
	 currency : <fmt:formatNumber value="${num3 }" type="currency"/><br>
	 <!-- 
	 	type="currency" : 통화(돈)단위로 보여짐. 현재 내 컴퓨터의 로컬정보에따라 통화기호가 결정됨.
	 	(groupingUsed 기본값이 true이기 때문에 3자리마다 ,도 찍혀있다.)
	  -->
	  
	  currency $ : <fmt:formatNumber value="${num3}" type="currency" currencySymbol="$"/>
	  <!-- 
	  	currencySymbol : 통화기호의 문자의 종류를 지정
	   -->

	<h3>2. formatDate</h3>
	<p>
		날짜 및 시간 데이터의 포맷 지정<br> 
		단, java.util.Date 객체를 사용해야 한다.
	</p>

	<c:set var="current" value="<%= new java.util.Date() %>" />
	
	그냥 ~출력: ${current }
	
	<ul>
		<li>
			현재 날짜 : <fmt:formatDate value="${current }" type="date" />
			<!-- type속성은 생략 가능, 생략시 기본값 date : 날짜를 출력하겠다. -->
		</li>
		<li>
			현재 시간 <fmt:formatDate value="${current }" type="time"/>
			<!-- type="time" : 시간을 출력하겠다 ex) 오후 3:52:22 -->
		</li>
		<li>
			현재 날짜 및 시간 : <fmt:formatDate value="${current }" type="both"/>
		</li>
		<li>
			medium: <fmt:formatDate value="${current }" type="both" dateStyle="medium" timeStyle="medium" />
		</li>
		<li>
			long : <fmt:formatDate value="${current }" type="both" dateStyle="long" timeStyle="long" />
		</li>
		<li>
			full : <fmt:formatDate value="${current }" type="both" dateStyle="full" timeStyle="full"/>
		</li>
		<li>
			shor : <fmt:formatDate value="${current }" type="both" dateStyle="short" timeStyle="short"/>
		</li>
		<li>
			customizing : <fmt:formatDate value="${current }" type="both" pattern="yyyy-MM-dd(E) a HH:mm:ss" />
			<!--  
				- customizing시 의미하는 패턴
				yyyy : 년도
				dd : 일
				E : 요일
				a : 오전/오후
				HH : 시
				mm : 분
				ss : 초
			 -->
		</li>
		
	</ul>

</body>
</html>