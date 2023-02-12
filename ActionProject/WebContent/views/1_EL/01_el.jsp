<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1. 기존방식대로 스크립틀릿과 표현식을 이용해서 각 영역에 담겨있는 값을 뽑아서 화면에 출력</h3>
	<%
		// requestScope에 담긴 값을 뽑기
		String classRoom = (String) request.getAttribute("classRoom");
	
		// sessionScope에 담긴 값을 뽑기
		String academy = (String) session.getAttribute("academy");
	%>

	<p>
		학원명 : <%=academy %> <br>
		강의장 : <%=classRoom %>
	</p>

	<h3>2. EL을 이용해서 보다 쉽게 해당 Scope에 저장된 값들 출력하기</h3>
	<p>	
		EL은 getXXX을 통해 값을 빼올 필요 없이 키값만 제시하면 바로~접근가능.<br>
		내부적으로 해당 scope 영역에 해당 키값의 밸류값을 가져올 수 있음<br>
		기본적으로 EL은 jsp내장객체를 구분하지 않고 자동적으로 모든 내장객체에
		키값을 검색해서 존재하는 경우 값을 가져옴.
	</p>

	<p>
		학원명 : ${ academy } <br>
		강의장 : ${ classRoom } <br>
		강사정보 : ${ teacher.name } , ${ teacher.age }, ${ teacher.gender } <br>
		<%--
			teacher에 접근했을 때 밸류값은 Person객체임.
			해당 Person 객체의 각 필드에 담긴 값을 출력하고자 한다면 .필드명으로 접근하면 됨.
			내부적으로 getter메소드를 찾아서 실행됨(즉, getter메소드는 항상 만들어야함.)
		 --%>
		 수강생 정보
		 <ul>
		 	<li>이름 : ${student.name}</li>
		 	<li>나이 : ${student.age}</li>
		 	<li>성별 : ${student.gender}</li>
		 </ul>
	</p>
	
	 <hr>
	 
	 <h3>3. 단, EL사용시 내장객체들에 저장된 키값이 동일할 경우</h3>
	 scope 값 : ${scope} <br>
	 <!--  
	 	EL은 공유범위가 제일 작은 Scope에서부터 해당 키값을 검색함.
	 	Page => request => session => application순으로 속성을 찾음.
	 	
	 	만약에 모든 영역에서 못찾을 경우 ? => 아무것도 출력안됨(오류안남)
	  -->
	  
	  <hr>
	  
	  <h3>4. 직접 Scope영역을 지정해서 접근하기</h3>
	  
	  <%
	  	// pageScope 담기
	  	pageContext.setAttribute("scope", "page");
	  %>
	  
	  pageScope에 담긴 값 : ${scope} 또는 ${pageScope.scope} <br>
	  requestScope에 담긴 값 : ${requestScope.scope} <br>
	  sessionScope에 담긴 값 : ${sessionScope.scope} <br>
	  applicationScope에 담긴 값 : ${applicationScope.scope} <br>
	  
	  잘못된 접근시 (session의 classRoom) : ${sessionScope.classRoom} <br>
	  => 결과는? 에러는 안나고, 아무것도 출력되지 않는다.

</body>
</html>