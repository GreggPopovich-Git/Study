/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.68
 * Generated at: 2021-09-09 07:25:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class member_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/include/footer.jsp", Long.valueOf(1630485041690L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1628495422710L));
    _jspx_dependants.put("jar:file:/C:/Users/ilove/eclipse-workspace/exWeb49/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/MyProject/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("/include/header.jsp", Long.valueOf(1631089105303L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>JSL 인재개발원</title>\r\n");
      out.write("	<link href=\"/css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css\">\r\n");
      out.write("	<link href=\"/css/common.css\" rel=\"stylesheet\">\r\n");
      out.write("	<link href=\"/css/mystyle.css\" rel=\"stylesheet\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("    	\r\n");
      out.write("      $('.slider').bxSlider({\r\n");
      out.write("    	  mode: 'fade',\r\n");
      out.write("    	  captions: true\r\n");
      out.write("      });\r\n");
      out.write("      \r\n");
      out.write("      $(\".sitemap\").click(function() {\r\n");
      out.write("			$(\".sitewrap\").slideDown();\r\n");
      out.write("		})\r\n");
      out.write("	  $(\"#close\").click(function() {\r\n");
      out.write("			$(\".sitewrap\").slideUp();\r\n");
      out.write("		})\r\n");
      out.write("		\r\n");
      out.write("	  $(\".nav > nav > .navi > li\").hover(function() {\r\n");
      out.write("		  $(this).children(\".navi2\").stop().slideDown();\r\n");
      out.write("	  }, function() {\r\n");
      out.write("		  $(this).children(\".navi2\").stop().slideUp();\r\n");
      out.write("	  });\r\n");
      out.write("		\r\n");
      out.write("    });\r\n");
      out.write("	function log_out() {\r\n");
      out.write("		if(confirm(\"로그아웃 하시겠습니까?\")) {\r\n");
      out.write("			location.href = \"logout.do\";\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"header\">\r\n");
      out.write("		<header>\r\n");
      out.write("			<div class=\"topnav\">\r\n");
      out.write("				<ul>\r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("				");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("					<li><a href=\"javascript:void(0)\" class=\"sitemap\">사이트맵</a></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"navigation\">\r\n");
      out.write("				<h1 class=\"logo\"><a href=\"/index.do\"><img src=\"http://m.jslhrd.com/img_up/shop_pds/jslcom/build/option/jsl-in-jae-gae-bal-won_-ro-go1622616169.png\" alt=\"\" title=\"logo\" width=\"50\" height=\"30\"></a></h1>\r\n");
      out.write("				<div class=\"nav\">\r\n");
      out.write("					<nav>\r\n");
      out.write("						<ul class=\"navi\">\r\n");
      out.write("							<li><a href=\"board.do\">게시판</a>\r\n");
      out.write("								<ul class=\"navi2\">\r\n");
      out.write("									<li><a href=\"board.do\">자유게시판</a></li>\r\n");
      out.write("									<li><a href=\"mboard.do\">회원게시판</a></li>\r\n");
      out.write("									<li><a href=\"pds.do\">자료실</a></li>\r\n");
      out.write("								</ul>\r\n");
      out.write("							</li>\r\n");
      out.write("							<li><a href=\"gallery.do\">갤러리</a>\r\n");
      out.write("								<ul class=\"navi2\">\r\n");
      out.write("									<li><a href=\"gallery.do\">전체보기</a></li>\r\n");
      out.write("									<li><a href=\"gallery.do?type=국내여행\">국내여행</a></li>\r\n");
      out.write("									<li><a href=\"gallery.do?type=해외여행\">해외여행</a></li>\r\n");
      out.write("									<li><a href=\"gallery.do?type=맛집사진\">맛집사진</a></li>\r\n");
      out.write("								</ul>\r\n");
      out.write("							</li>\r\n");
      out.write("							<li><a href=\"qa.do\">질문답변</a></li>\r\n");
      out.write("							<li><a href=\"notice.do\">공지사항</a></li>\r\n");
      out.write("							");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("						</ul>\r\n");
      out.write("					</nav>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</header>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"line\"></div>\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"sitewrap\">\r\n");
      out.write("		<span class=\"fa fa-close\" id=\"close\" style=\"cursor:pointer\"></span>\r\n");
      out.write("		<div class=\"inner\">\r\n");
      out.write("			<span class=\"map\"><a href=\"board.do\"><font color=\"white\">자유게시판</font></a></span>\r\n");
      out.write("			<span class=\"map\"><a href=\"gallery.do\"><font color=\"white\">갤러리</font></a></span>\r\n");
      out.write("			<span class=\"map\"><a href=\"qa.do\"><font color=\"white\">질문답변</font></a></span>\r\n");
      out.write("			<span class=\"map\"><a href=\"notice.do\"><font color=\"white\">공지사항</font></a></span>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f4(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<div class=\"contain\">\r\n");
      out.write("	<div class=\"sub-topcontent\">\r\n");
      out.write("		<h2 class=\"sub-title\">회원가입</h2>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"write-form\">\r\n");
      out.write("	<form name=\"my\" method=\"post\" action=\"member_pro.do\" onsubmit=\"return formcheck();\">\r\n");
      out.write("		<table summery=\"회원가입 글쓰기 테이블 입니다\">\r\n");
      out.write("			<caption class=\"readonly\">회원가입 입력폼</caption>			\r\n");
      out.write("			<colgroup>\r\n");
      out.write("				<col width=\"20%\">\r\n");
      out.write("				<col width=\"80%\">\r\n");
      out.write("			</colgroup>\r\n");
      out.write("			<tbody>\r\n");
      out.write("				<fieldset>\r\n");
      out.write("					<legend class=\"readonly\">입력폼</legend>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th scope=\"row\">\r\n");
      out.write("							<label for=\"id\">아이디</label>\r\n");
      out.write("						</th>\r\n");
      out.write("						<td>\r\n");
      out.write("							<input type=\"text\" name=\"userid\" id=\"id\" class=\"minput\" placeholder=\"중복확인을 해주세요\" readonly> \r\n");
      out.write("							<a href=\"javascript:idcheck()\" class=\"btn-write\">중복확인</a>\r\n");
      out.write("						</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th scope=\"row\"><lavel for=\"pass1\">패스워드</lavel></th>\r\n");
      out.write("						<td><input type=\"password\" name=\"pass\" id=\"pass1\" class=\"minput\"></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th scope=\"row\">패스워드 확인</th>\r\n");
      out.write("						<td><input type=\"password\" name=\"repass\" class=\"minput\"></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th scope=\"row\">이름</th>\r\n");
      out.write("						<td><input type=\"text\" name=\"name\" class=\"minput\"></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th scope=\"row\">이메일</th>\r\n");
      out.write("						<td>\r\n");
      out.write("							<input type=\"text\" name=\"email1\" class=\"email\"> @\r\n");
      out.write("							<input type=\"text\" name=\"email2\" class=\"email\" disabled>\r\n");
      out.write("							<select name=\"domain\" style=\"height:40px;\" onChange=\"email_change()\">\r\n");
      out.write("								<option value=\"0\">선택하세요</option>\r\n");
      out.write("								<option value=\"9\">직접입력</option>\r\n");
      out.write("								<option value=\"gmail.com\">gmail.com</option>\r\n");
      out.write("								<option value=\"naver.com\">naver.com</option>\r\n");
      out.write("								<option value=\"hanmail.net\">hanmail.net</option>\r\n");
      out.write("								<option value=\"yahoo.co.kr\">yahoo.co.kr</option>\r\n");
      out.write("								<option value=\"nate.com\">nate.com</option>\r\n");
      out.write("							</select>\r\n");
      out.write("						</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th scope=\"row\">전화번호</th>\r\n");
      out.write("						<td><input type=\"text\" name=\"tel1\" maxlength=\"3\" style=\"width:90px\"> - <input type=\"text\" name=\"tel2\" maxlength=\"4\" style=\"width:110px\"> - <input type=\"text\" name=\"tel3\" maxlength=\"4\" style=\"width:110px\"></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td colspan=\"2\">\r\n");
      out.write("							<input type=\"button\" value=\"전송\" class=\"btn-write\" style=\"cursor:pointer;\" onClick=\"formcheck()\">\r\n");
      out.write("							<input type=\"button\" value=\"취소\" class=\"btn-reset\" style=\"cursor:pointer;\" onClick=\"history.back()\">\r\n");
      out.write("						</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					</fieldset>\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("		\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	function formcheck() {\r\n");
      out.write("		if(my.id.value==\"\") {\r\n");
      out.write("			alert(\"아이디를 입력하세요\");\r\n");
      out.write("			my.id.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if(my.pass.value==\"\") {\r\n");
      out.write("			alert(\"패스워드를 입력하세요\");\r\n");
      out.write("			my.pass.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if(my.repass.value==\"\") {\r\n");
      out.write("			alert(\"패스워드를 다시 한번 더 입력하세요\");\r\n");
      out.write("			my.repass.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if(my.pass.value != my.repass.value) {\r\n");
      out.write("			alert(\"패스워드를 확인하세요\");\r\n");
      out.write("			my.repass.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if(my.name.value == \"\") {\r\n");
      out.write("			alert(\"이름을 입력하세요\");\r\n");
      out.write("			my.name.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if(my.email1.value == \"\") {\r\n");
      out.write("			alert(\"이메일을 입력하세요\");\r\n");
      out.write("			my.email1.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if(my.email2.value == \"\") {\r\n");
      out.write("			alert(\"이메일을 입력하세요\");\r\n");
      out.write("			my.email1.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if(my.email2.value == \"\") {\r\n");
      out.write("			alert(\"이메일을 입력하세요\");\r\n");
      out.write("			my.email2.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		if(my.tel1.value == \"\" || my.tel2.value == \"\" || my.tel3.value == \"\") {\r\n");
      out.write("			alert(\"전화번호를 입력하세요\");\r\n");
      out.write("			my.tel1.focus();\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		my.submit();\r\n");
      out.write("	}\r\n");
      out.write("    function email_change(){\r\n");
      out.write("    	if(document.my.domain.options[document.my.domain.selectedIndex].value == \"0\") {\r\n");
      out.write("			document.my.email2.disabled = true;\r\n");
      out.write("    	 	document.my.email2.value = \"\";\r\n");
      out.write("    	} else if(document.my.domain.options[document.my.domain.selectedIndex].value == \"9\") {\r\n");
      out.write("    	 	document.my.email2.disabled = false;\r\n");
      out.write("    	 	document.my.email2.value = \"\";\r\n");
      out.write("    	 	document.my.email2.focus();\r\n");
      out.write("    	} else {\r\n");
      out.write("    	 	document.my.email2.disabled = true;\r\n");
      out.write("    	 	document.my.email2.value = document.my.domain.options[document.my.domain.selectedIndex].value;\r\n");
      out.write("    	}\r\n");
      out.write("    }\r\n");
      out.write(" 	// 아이디 중복검사 스크립트\r\n");
      out.write("	function idcheck() {\r\n");
      out.write("		window.open(\"idcheck.do\", \"아이디 중복체크\", \"width=600, height=220\");\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("		<footer>\r\n");
      out.write("			<p>&copy; JSL. All &nbsp;&nbsp;&nbsp;Rights Reserved.</p>\r\n");
      out.write("		</footer>\r\n");
      out.write("		<!-- &copy; &nbsp; &gt; > &lt;< -->\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /include/header.jsp(52,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionvo}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<li><a href=\"login.do\">로그인</a></li>\r\n");
          out.write("					<li><a href=\"member.do\">회원가입</a></li>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /include/header.jsp(56,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${!empty sessionvo}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("					<li><a href=\"javascript:log_out()\">로그아웃</a></li>\r\n");
          out.write("					<li><a href=\"member_info.do\">회원정보</a></li>\r\n");
          out.write("				");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /include/header.jsp(85,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionvo.rank == 0 || sessionvo.rank == 1}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("								<li><a href=\"member_list.do\">관리페이지</a></li>\r\n");
          out.write("							");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f3_reused = false;
    try {
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent(null);
      // /member/member.jsp(6,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row==1}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("	<script>\r\n");
          out.write("		location.href = \"login.do\";\r\n");
          out.write("	</script>\r\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      _jspx_th_c_005fif_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f3_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f4_reused = false;
    try {
      _jspx_th_c_005fif_005f4.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f4.setParent(null);
      // /member/member.jsp(11,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${row==0}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f4 = _jspx_th_c_005fif_005f4.doStartTag();
      if (_jspx_eval_c_005fif_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("	<script>\r\n");
          out.write("		alert(\"회원가입에 실패 했습니다. 다시 시도 해 주세요.\");\r\n");
          out.write("		history.back();\r\n");
          out.write("	</script>\r\n");
          int evalDoAfterBody = _jspx_th_c_005fif_005f4.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f4);
      _jspx_th_c_005fif_005f4_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f4, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f4_reused);
    }
    return false;
  }
}
