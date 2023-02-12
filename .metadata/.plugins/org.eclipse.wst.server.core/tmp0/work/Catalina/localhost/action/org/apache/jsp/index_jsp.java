/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-11-03 06:54:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>* EL (Expression Language) 표현언어</h1>\r\n");
      out.write("	\r\n");
      out.write("	<p>\r\n");
      out.write("		기존에 사용했던 표현식(출력식) &lt;%= name %&gt;와 같이<br>\r\n");
      out.write("		JSP상에서 표현하고자 하는 값을 ${name}의 형식으로 표현해서 작성하는 것 ");
      out.write("\r\n");
      out.write("	</p>\r\n");
      out.write("	\r\n");
      out.write("	<h3>1. EL 기본 구문에 대해서 배우기</h3>\r\n");
      out.write("	<a href=\"/action/el.do\">01_EL</a>\r\n");
      out.write("	\r\n");
      out.write("	<h3>2. EL의 연산자에 대해서 배우기</h3>\r\n");
      out.write("	<a href=\"/action/operation.do\">02_EL의 연산자</a>\r\n");
      out.write("	\r\n");
      out.write("	<!-- \r\n");
      out.write("		* JSP를 이루는 구성인자 \r\n");
      out.write("		\r\n");
      out.write("		1. JSP 스크립트원소 : JSP페이지에서 자바코드를 직접기술할수 있게 하는 기술.\r\n");
      out.write("			EX) 선언문, 스크립틀릿, 표현식\r\n");
      out.write("		2. 지시어 : JSP페이지 정보에 대한 내용을 표현한다거나 또다른 페이지를 포함할때 사용\r\n");
      out.write("		 	EX) page 지시어, include 지시어, taglib 지시어(라이브러리 추가시 사용)\r\n");
      out.write("		 	\r\n");
      out.write("		 	3. JSP 액션 태그 : XML 기술을 이용해서 기존의jsp 문법을 확장하는기술을 제공하는 태그\r\n");
      out.write("		 			- 표준액션태그(Standard Action Tag) : JSP페이지에서 바로사용가능(별도의 연동X)\r\n");
      out.write("		 											   표준액션태그는 모든 태그명앞에 jsp: 라는 접두어가 붙음.\r\n");
      out.write("		 			- 커스텀액션태그(Custom Action Tag) : JSP페이지에서 바로사용불가능(별도의 연동이 필요)	\r\n");
      out.write("		 											   커스텀액션태그는 모든 태그명안에 jsp:외의 다른 접두어가 붙음(c, fn, fmt)\r\n");
      out.write("		 											   제공되고있는 대표적인 유용한 라이브러리가 있음(JSTL)\r\n");
      out.write("	 -->\r\n");
      out.write("\r\n");
      out.write("	<h1>* JSP Action Tag</h1>\r\n");
      out.write("	<p>XML기술을 이용해서 기존의 JSP문법을 확장시키는 기술을 제공하는 태그들.</p>\r\n");
      out.write("	<h3>1. 표준 액션 태그</h3>\r\n");
      out.write("	<p>\r\n");
      out.write("		JSP페이지에서 별도의 라이브러리 연동없이 바로사용 가능함<br> 태그앞에 jsp : 접두어가 붙음\r\n");
      out.write("	</p>\r\n");
      out.write("\r\n");
      out.write("	<a href=\"views/2_StandardAction/01_include.jsp\">01_jsp:include</a> <br>\r\n");
      out.write("	\r\n");
      out.write("	<a href=\"views/2_StandardAction/02_forward.jsp\">02_jsp:forward</a>\r\n");
      out.write("	\r\n");
      out.write("	<h3>2. 커스텀 액션 태그</h3>\r\n");
      out.write("	<a href=\"views/3_CustomAction/jstl.jsp\">JSTL</a>\r\n");
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