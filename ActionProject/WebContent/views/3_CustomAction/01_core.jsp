<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.kh.model.vo.Person"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL Core Library</h1>
	<pre>
* 변수 선언(&lt;c:set var="변수명" value="리터럴" scope="스코프영역지정(생략가능)" &gt;)
- 변수를 선언하고 초기값을 대입해두는 기능을 제공
- 해당 변수를 어떤 scope에 담아둘껀지 지정 가능함(생략시 기본적으로 pageScope에 담김)
=> 즉, 해당 scope영역에 setAttribute라는 메소드를 이용해서 key+value형태로 데이터를 담아놓는 형태임.
=> c:set을 통해 선언된 변수는 EL로 접근해서 사용가능.

* 주의사항
- 변수의 타입을 별도로 지정하지 않음
- 반드시 해당 변수의 담아두고자하는 초기값(value)속성을 무조건 추가시켜줘야함(선언과 동시에 초기화해줘야함)
</pre>

	<c:set var="num1" value="10" />
	<!-- pageScope에 담김 -->
	<!-- requestScope에 담김 -->
	<c:set var="num2" scope="request"> 
20
</c:set>
	<!-- request.setAttribute("num2",20); -->

	num1 변수값 : ${pageScope.num1 }
	<br> num2 변수값 : ${requestScope.num2 }
	<br>

	<c:set var="result" value="${num1+num2 }" scope="session" />

	result 변수값 : ${result }
	<br>
	<br>

	<!-- 변수명만 제시하면 공유범위가 가장 작은곳부터 큰곳으로 순차적으로 찾아지게됨.
티가 나지는 않지만 속도가 조금 느려질수있다. 따라서 스코프영역.변수명을 작성하는것을 권장
 -->
	${num1 }
	<br> ${num2 }
	<br> ${result }
	<br>
	<br>

	<hr>

	<pre>
* 변수 삭제(&lt;c:remove var="제거하고자하는 변수명" scope="스코프영역지정(생략가능)"&gt;)
- 해당 변수를 scope에서 찾아서 제거하는 태그
- scope지정 생략시 모든 scope에서 해당 변수를 다 찾아서 제거함
=> 즉, 해당 scope에 .removeAttribute라는 메서드를 이용해서 제거하는것이라고 생각하면 됨.
</pre>

	삭제전 result : ${result }
	<br>
	<br> 1) 특정 scope 지정해서 삭제하기
	<br>
	<c:remove var="result" scope="request" />
	request에 삭제후 result:${result }
	<br>
	<br> 2) 모든 scope에서 삭제
	<br>
	<c:remove var="result" />
	삭제후 result: ${result }
	<br>
	<br>

	<hr>

	<pre>
* 변수(데이터) 출력 : (&lt;c:out value="출력하고자하는 값" default="기본값(생략가능)" escapeXml="true/false(기본값true, 생략가능)" &gt;)
- 데이터를 출력하고자할때 사용하는 태그
- 기본값 : value에 출력하고자 하는 값이 없을 경우 기본값으로 출력할 내용물을 기술(생략가능)
- excapeXml : 태그로써 해석해서 출력할지 여부(생략가능, 기본값 true)
</pre>

	result :
	<c:out value="${result}" />
	<br> default 설정시 result 값 :
	<c:out value="${result }" default="값이 없음" />
	<br>

	<!-- escapeXml 테스트 -->
	<c:set var="outTest" value="<b>출력테스트</b>" />
	<c:out value="${outTest }" />
	<br>
	<!-- escapeXml 생략시 기본값은 true == 태그 해석안됨(문자열로 취급) -->
	<c:out value="${outTest }" escapeXml="false" />
	<br>

	<hr>

	<h3>2. 조건문 - if(&lt;c:if test="조건식"&gt;)</h3>
	<pre>
-JAVA의 단일 IF문과 비슷한 역할을 하는 태그
- 조건식을 test라는 속성에 속성값으로 작성(*** 단, 무조건 el구문으로 작성해야함 ***)
</pre>

	<c:if test="${num1 gt num2 }">
		<b>num1이 num2보다 큽니다.</b>
	</c:if>
	<c:if test="${num1 le num2 }">
		<b>num2이 num2보다 작거나 갇습니다.</b>
	</c:if>

	<c:set var="str" value="안녕" />

	<br>

	<c:if test="${str eq '안녕하세요' }">
		<mark>Hello world!</mark>
	</c:if>

	<c:if test="${str ne '안녕하세요' }">
		<mark>안녕히가세요</mark>
	</c:if>

	<br>

	<h3>3. 조건문 - choose(&lt;c:choose&gt;, &lt;c:when&gt;,
		&lt;c:otherwise&gt;)</h3>
	<pre>
- JAVA의 if-else, if-else if 또는 switch문과 비슷한 역할을 하는 태그
- 각 조건들을 c:choose의 하위요소로 c:when을 통해서 작성
</pre>

	<c:choose>
		<c:when test="${num1 eq 20 }">
			<b>num1은 20과 일치합니다.</b>
		</c:when>
		<c:when test="${num1 eq 10 }">
			<b>num1은 10과 일치합니다</b>
		</c:when>
		<c:otherwise>
			<b>num1은 10혹은 20과 일치하지 않습니다.</b>
		</c:otherwise>
	</c:choose>

	<hr>

	<h3>4. 반복문 - forEach</h3>
	<pre>
for loop문 - (&lt;c:forEach var="변수명" begin="초기값" end="끝값" step="증가시킬값(생략가능)"&gt;)
향상된 for문 - (&lt;c:forEach var="변수명" items="순차적으로 접근할 배열 컬렉션" varStatus="현재접근된요소의 상태값을 보관할 변수명(생략가능)"&gt;)
=> step : 지정하지 않을시 기본값은 1
=> varStatus : 현재 접근된 요소의 상세값을 보관할 변수명(생략가능)
</pre>

	<!-- for loop문 -->
	<%
		for (int i = 1; i <= 10; i++) {
	%>

	<%
		}
	%>

	<c:forEach var="i" begin="1" end="10">
	반복확인 : ${i}<br>
	</c:forEach>

	<br>
	<%
		for (int i = 1; i <= 10; i += 2) {
	%>

	<%
		}
	%>

	<c:forEach var="i" begin="1" end="10" step="2">
	반복확인2 : ${i}<br>
	</c:forEach>

	<!-- 태그 안에서도 사용해보기 -->
	<c:forEach var="i" begin="1" end="6">
		<h ${i}>태그안에서도 됩니까?</h${i}>
	</c:forEach>

	<br>

	<%
		ArrayList<Person> list = new ArrayList<>();
	list.add(new Person("홍길동", 20, "남자"));
	list.add(new Person("김길동", 30, "남자"));
	list.add(new Person("덕배", 15, "남자"));

	request.setAttribute("pList", list);
	%>
	<table border="1">
		<thead>
			<tr>
				<th>순번</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
			</tr>
		</thead>
		<tbody>
			<%-- 			<% if(!pList.isEmpty()) {%> --%>
			<%-- 				<% for(Person p : pList) {%> --%>

			<%-- 				<% } %> --%>
			<%-- 			<% } %> --%>
			<c:choose>
				<c:when test="${ empty pList }">
					<tr>
						<td colspan="4">조회결과가 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="p" items="${requestScope.pList }"
						varStatus="status">
						<tr align="center">
							<td>${status.count}</td>
							<!-- index: 0부터시작, count : 1부터 시작 -->
							<td>${p.name }</td>
							<td>${p.age }</td>
							<td>${p.gender }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>

	<hr>

	<h3>5. 반복문 - forTokens</h3>
	<pre>
	&lt;c:forTokens var="각값을 보관할 변수" items ="분리시키고자하는 문자열"delims="구분자"&gt;
	
	- 구분자를 통해서 분리된 각각으 문자열에 순차적으로 접근하면서 반복 수행
	- Java의 split("구분자") 또는 StringTokenizer와 비스산 역할
	</pre>

	<c:set var="device" value="컴퓨터,핸드폰,TV,에어컨,냉장고.세탁기/비데" />

	<ul>
		<c:forTokens var="d" items="${device }" delims=",./">
			<li>${d }</li>
		</c:forTokens>
	</ul>

	<hr>

	<h3>6. 쿼리스트링 관련 - url, param</h3>
	<pre>
	&lt;c:url var="" value="요청할url"&gt;
		&lt;c:param name="키값" value="벨류값"/&gt;
		&lt;c:param name="키값" value="벨류값"/&gt;
	&lt;/c:url&gt;
	- url 경로를 생성하고, 쿼리스트링을 정의할 수 있는 태그.
	- 넘겨야할 쿼리스트링이 길경우 사용하면 편리함.
	</pre>

	<a href="<%=request.getContextPath()%>/list.do?currentPage=1&num=2">기존방식</a>
	<br>

	<c:url var="query" value="list.do">
		<c:param name="currentPage" value="1" />
		<c:param name="num" value="2" />
	</c:url>

	<a href="${query }">c:url을 이용한 방식</a>

	

</body>
</html>