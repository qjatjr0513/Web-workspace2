/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-11-03 16:31:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.notice.model.vo.Notice;
import com.kh.member.model.vo.Member;

public final class noticeDetailView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/notice/../common/menubar.jsp", Long.valueOf(1667378032277L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.notice.model.vo.Notice");
    _jspx_imports_classes.add("com.kh.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	Notice n = (Notice) request.getAttribute("n");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	.outer{\r\n");
      out.write("        background-color: black; /* 해당사이트의 고유한 색상으로 작성 */\r\n");
      out.write("        color: white;\r\n");
      out.write("        width: 1000px;\r\n");
      out.write("        height: 500px;\r\n");
      out.write("        margin: auto; /* 가운데 자동 정렬 */\r\n");
      out.write("        margin-top: 50px; /* 위로부터 50px 아래로 여백 만들기 */\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write('\r');
      out.write('\n');

    String contextPath = request.getContextPath();

	Member loginUser = (Member) session.getAttribute("loginUser");
	// 로그인전 or 로그인 실패 : null
	// 로그인 성공후 : 로그인한 회원의 정보가 담긴 member객체.
	
	String alertMsg = (String) session.getAttribute("alertMsg");
	// 서비스 요청전 : null
	// 서비스 요청성공후 : alert로 띄워줄 메시지 문구.

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>B CLASS</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("    #login-form , #user-info{\r\n");
      out.write("        float: right;\r\n");
      out.write("    }\r\n");
      out.write("    #user-info a{\r\n");
      out.write("    	text-decoration : none;\r\n");
      out.write("    	color : black;\r\n");
      out.write("    	font-size : 12px;\r\n");
      out.write("    }\r\n");
      out.write("    .nav-area{\r\n");
      out.write("        background-color: black;\r\n");
      out.write("    }\r\n");
      out.write("    .menu{\r\n");
      out.write("        display: table-cell; /* 인라인 요소처럼 배치(일자로) */\r\n");
      out.write("        width: 150px;\r\n");
      out.write("        height: 50px;\r\n");
      out.write("    }\r\n");
      out.write("    .menu a{\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        color: white;\r\n");
      out.write("        font-size: 20px;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("        display: block; /* 한 영역 다차지하게 */\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("        line-height: 50px; /* 줄 간격 */\r\n");
      out.write("    }\r\n");
      out.write("    .menu a:hover{\r\n");
      out.write("        background-color: darkgrey;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<script>\r\n");
      out.write("		let msg = \"");
      out.print( alertMsg);
      out.write("\"; // let msg = 성공적으로 로그인이 되었습니다.\r\n");
      out.write("		\r\n");
      out.write("		if(msg != \"null\"){\r\n");
      out.write("			alert(msg);\r\n");
      out.write("			// 알림창을 띄워준후 session에 담긴 해당메세지는 지워줘야함.\r\n");
      out.write("			// 안그러면 menubar.jsp가 로딩될때마다 매번 alert가 계속 뜰것\r\n");
      out.write("			\r\n");
      out.write("			");
 session.removeAttribute("alertMsg");
      out.write("\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("    <h1 style = \"text-align:center;\">Welcome B Class</h1>\r\n");
      out.write("\r\n");
      out.write("<div class = \"login-area\">\r\n");
 if(loginUser == null) { 
      out.write("\r\n");
      out.write("    <form id = \"login-form\" action = \"");
      out.print(contextPath);
      out.write("/login.me\" method = \"post\">\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>아이디 : </th>\r\n");
      out.write("                <td><input type = \"text\" name = \"userId\" required></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>비밀번호 : </th>\r\n");
      out.write("                <td><input type = \"password\" name = \"userPwd\" required></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th colspan = \"2\">\r\n");
      out.write("                	<input type=\"checkbox\" id=\"saveId\"><label for=\"saveId\">아이디 저장</label>\r\n");
      out.write("                    <button type = \"button\" onclick=\"submitLogin();\">로그인</button>\r\n");
      out.write("                    <button type = \"button\" onclick = \"enrollPage();\">회원가입</button>\r\n");
      out.write("                </th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </form>\r\n");
      out.write("    <script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("        getCookie();\r\n");
      out.write("     });\r\n");
      out.write("        function enrollPage(){\r\n");
      out.write("			\r\n");
      out.write("        	// location.href = /jsp/views/member/memberEnrollForm.jsp\r\n");
      out.write("        	// 웹 애플리케이션의 디렉토리 구조가 url에 노출되면 보안에 취약하다.\r\n");
      out.write("        	\r\n");
      out.write("        	// 단순한 정적인 페이지라도 반드시 servlet을 거져가기.\r\n");
      out.write("        	location.href = \"");
      out.print(contextPath);
      out.write("/enrollFrom.me\";\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        function submitLogin(){\r\n");
      out.write("        	\r\n");
      out.write("        	let userId = $(\"input[name=userId]\").val();\r\n");
      out.write("        	\r\n");
      out.write("        	if($(\"#saveId\").is(\":checked\")){// true 체크된 상태\r\n");
      out.write("        		document.cookie = \"saveId=\"+userId+\"; path=/; max-age=\"+60*60*24*7;// 쿠키 최대시간 설정(7일) max-age-> 해당 쿠키의 지속시간 설정(expire보다 우선권이있다) expire-> 해당 쿠키의 파기시간\r\n");
      out.write("        	}else{// 체크 안된 상태\r\n");
      out.write("        		document.cookie = \"saveId=\"+userId+\"; path=/; max-age=\"+0;// 최대시간을 0으로 설정해서 해당 쿠키를 제거.\r\n");
      out.write("        	}\r\n");
      out.write("        	\r\n");
      out.write("        	let form = $(\"#login-form\");\r\n");
      out.write("        	form.submit();\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        function getCookie(){\r\n");
      out.write("            let value = \"\";\r\n");
      out.write("            if(document.cookie.length > 0){\r\n");
      out.write("               let index = document.cookie.indexOf(\"saveId=\"); // saveId=admin; path=/; max-age=5660;\r\n");
      out.write("               if(index != -1){\r\n");
      out.write("                  index += \"saveId=\".length;\r\n");
      out.write("                  let end = document.cookie.indexOf(\";\",index);\r\n");
      out.write("                  console.log(index , end);\r\n");
      out.write("                  if(end == -1){\r\n");
      out.write("                     value = document.cookie.substring(index);\r\n");
      out.write("                  }else{\r\n");
      out.write("                     value = document.cookie.substring(index , end);\r\n");
      out.write("                  }\r\n");
      out.write("                  $(\"input[name=userId]\").val(value);\r\n");
      out.write("                    $(\"#saveId\").attr(\"checked\",\"true\");\r\n");
      out.write("               }\r\n");
      out.write("            }\r\n");
      out.write("  \r\n");
      out.write("         }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("    ");
 } else { 
      out.write("\r\n");
      out.write("    	<!-- 로그인 성공 후 -->\r\n");
      out.write("    	<div id = \"user-info\">\r\n");
      out.write("    		<b>");
      out.print( loginUser.getUserName() );
      out.write("</b>님 환영합니다.<br><br>\r\n");
      out.write("    		<div align=\"center\">\r\n");
      out.write("    			<a href = \"");
      out.print(contextPath);
      out.write("/myPage.me\">마이페이지</a>\r\n");
      out.write("    			<a href = \"");
      out.print(contextPath);
      out.write("/logout.me\">로그아웃</a>\r\n");
      out.write("    		</div>\r\n");
      out.write("    	</div>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("    \r\n");
      out.write("    <br clear = \"both\"> <!-- float 속성 해제 -->\r\n");
      out.write("    <br>\r\n");
      out.write("\r\n");
      out.write("    <div class = \"nav-area\" align = \"center\">\r\n");
      out.write("        <div class = \"menu\"><a href = \"");
      out.print(contextPath);
      out.write("\">HOME</a></div>\r\n");
      out.write("        <div class = \"menu\"><a href = \"");
      out.print(contextPath);
      out.write("/list.no\">공지사항</a></div>\r\n");
      out.write("        <div class = \"menu\"><a href = \"");
      out.print(contextPath);
      out.write("/board/list.bo?currentPage=1\">일반게시판</a></div>\r\n");
      out.write("        <div class = \"menu\"><a href = \"");
      out.print(contextPath);
      out.write("/thumb/list.th\">사진게시판</a></div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	<div class=\"outer\">\r\n");
      out.write("		<br><h2 style=\"text-align:center;\">공지사항 상세보기</h2><br>\r\n");
      out.write("		\r\n");
      out.write("		<table id = \"detail-area\" align = \"center\" border = \"1\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th width = \"70\">제목</th>\r\n");
      out.write("				<td width = \"350\" colspan = \"3\">");
      out.print(n.getNoticeTitle() );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>작성자</th>\r\n");
      out.write("				<td>");
      out.print(n.getNoticeWriter() );
      out.write("</td>\r\n");
      out.write("				<th>작성일</th>\r\n");
      out.write("				<td>");
      out.print(n.getCreateDate() );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<th>내용</th>\r\n");
      out.write("				<td colspan = \"3\">\r\n");
      out.write("					<p style = \"height:150px\">");
      out.print(n.getNoticeContent() );
      out.write("</p>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		\r\n");
      out.write("		<br><br>\r\n");
      out.write("		\r\n");
      out.write("		<div align = \"center\">\r\n");
      out.write("			<a href = \"");
      out.print(contextPath );
      out.write("/list.no\" class = \"btn btn-secondary btn-sm\">목록으로가기</a>\r\n");
      out.write("			\r\n");
      out.write("			");
 if(loginUser != null && loginUser.getUserId().equals(n.getNoticeWriter())) { 
      out.write("\r\n");
      out.write("				<!-- 현재 로그인한 사용자가 해당 글을 작성한 작성자일 경우에만 보여진다. -->\r\n");
      out.write("				<a href = \"");
      out.print(contextPath );
      out.write("/updateForm.no?nno=");
      out.print(n.getNoticeNo() );
      out.write("\" class = \"btn btn-warning btn-sm\">수정하기</a>\r\n");
      out.write("				<a href = \"");
      out.print(contextPath );
      out.write("/delete.no?nno=");
      out.print(n.getNoticeNo() );
      out.write("\" class = \"btn btn-danger btn-sm\">삭제하기</a>\r\n");
      out.write("			");
 } 
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
