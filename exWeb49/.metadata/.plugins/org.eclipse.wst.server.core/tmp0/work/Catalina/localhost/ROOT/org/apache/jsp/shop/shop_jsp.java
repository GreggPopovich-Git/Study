/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.68
 * Generated at: 2021-08-17 05:18:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/include/footer.jsp", Long.valueOf(1629016737629L));
    _jspx_dependants.put("/include/header.jsp", Long.valueOf(1629177491990L));
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>장수하늘소</title>\r\n");
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
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"header\">\r\n");
      out.write("		<header>\r\n");
      out.write("			<div class=\"topnav\">\r\n");
      out.write("				<ul>\r\n");
      out.write("					<li><a href=\"member/login.jsp\">로그인</a></li>\r\n");
      out.write("					<li><a href=\"member/member.jsp\">회원가입</a></li>\r\n");
      out.write("					<li><a href=\"javascript:void(0)\" class=\"sitemap\">사이트맵</a></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"navigation\">\r\n");
      out.write("				<h1 class=\"logo\"><a href=\"/index.jsp\">LOGO</a></h1>\r\n");
      out.write("				<div class=\"nav\">\r\n");
      out.write("					<nav>\r\n");
      out.write("						<ul class=\"navi\">\r\n");
      out.write("							<li><a href=\"/about/about.jsp\">내소개</a>\r\n");
      out.write("								<ul class=\"navi2\">\r\n");
      out.write("									<li><a href=\"#\">이력서</a></li>\r\n");
      out.write("									<li><a href=\"#\">자기소개서</a></li>\r\n");
      out.write("									<li><a href=\"#\">자격증</a></li>\r\n");
      out.write("								</ul>\r\n");
      out.write("							</li>\r\n");
      out.write("							<li><a href=\"/gallery/gallery.jsp\">갤러리</a>\r\n");
      out.write("								<ul class=\"navi2\">\r\n");
      out.write("									<li><a href=\"#\">포토샵</a></li>\r\n");
      out.write("									<li><a href=\"#\">일러스트</a></li>\r\n");
      out.write("									<li><a href=\"#\">개인작품</a></li>\r\n");
      out.write("									<li><a href=\"#\">웹갤러리</a></li>\r\n");
      out.write("								</ul>\r\n");
      out.write("							</li>\r\n");
      out.write("							<li><a href=\"/portfolio/portfolio.jsp\">포트폴리오</a>\r\n");
      out.write("								<ul class=\"navi2\">\r\n");
      out.write("									<li><a href=\"#\">앱개발</a></li>\r\n");
      out.write("									<li><a href=\"#\">웹개발</a></li>\r\n");
      out.write("									<li><a href=\"#\">UI디자인</a></li>\r\n");
      out.write("								</ul>\r\n");
      out.write("							</li>\r\n");
      out.write("							<li><a href=\"/qa/qa.jsp\">질문답변</a>\r\n");
      out.write("								<ul class=\"navi2\">\r\n");
      out.write("									<li><a href=\"#\">JAVA</a></li>\r\n");
      out.write("									<li><a href=\"#\">DB</a></li>\r\n");
      out.write("									<li><a href=\"#\">JSP</a></li>\r\n");
      out.write("									<li><a href=\"#\">PHP</a></li>\r\n");
      out.write("								</ul>\r\n");
      out.write("							</li>\r\n");
      out.write("							<li><a href=\"/notice/notice.jsp\">공지사항</a></li>\r\n");
      out.write("							<li><a href=\"/shop/shop.jsp\">쇼핑몰</a></li>\r\n");
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
      out.write("			<span class=\"map\">내소개</span>\r\n");
      out.write("			<span class=\"map\">갤러리</span>\r\n");
      out.write("			<span class=\"map\">포트폴리오</span>\r\n");
      out.write("			<span class=\"map\">질문답변</span>\r\n");
      out.write("			<span class=\"map\">공지사항</span>\r\n");
      out.write("			<span class=\"map\">쇼핑몰</span>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"contain\">\r\n");
      out.write("	<div class=\"sub-topcontent\">\r\n");
      out.write("		<h2 class=\"sub-title\">장수하늘소 쇼핑몰</h2>\r\n");
      out.write("		<div class=\"sub-search\">\r\n");
      out.write("			<form name=\"my\" method=\"post\" action=\"gallery-search.jsp\" onsubmit=\"return check()\">\r\n");
      out.write("				<input type=\"text\" name=\"cont\" class=\"text\">\r\n");
      out.write("				<button class=\"btn\">검색</button>\r\n");
      out.write("			</form>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("		<ul class=\"sub-content\">\r\n");
      out.write("			<li>\r\n");
      out.write("				<a href=\"shopview.do\">\r\n");
      out.write("					<img src=\"/images/shop1.jpg\" alt=\"\">\r\n");
      out.write("					<p class=\"p26\">\r\n");
      out.write("							<span class=\"shop-title\">상품제목</span>\r\n");
      out.write("							<span class=\"price\">74,800 원</span>\r\n");
      out.write("					</p>\r\n");
      out.write("				</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li>\r\n");
      out.write("				<a href=\"shopview.do\">\r\n");
      out.write("					<img src=\"/images/shop2.jpg\" alt=\"\">\r\n");
      out.write("					<p class=\"p26\">\r\n");
      out.write("						\r\n");
      out.write("							<span class=\"gallery-title\">상품제목</span>\r\n");
      out.write("							<span class=\"price\">74,800 원</span>\r\n");
      out.write("					</p>\r\n");
      out.write("				</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li>\r\n");
      out.write("				<a href=\"shopview.do\">\r\n");
      out.write("					<img src=\"/images/shop3.jpg\" alt=\"\">\r\n");
      out.write("					<p class=\"p26\">\r\n");
      out.write("						\r\n");
      out.write("							<span class=\"gallery-title\">상품제목</span>\r\n");
      out.write("							<span class=\"price\">74,800 원</span>\r\n");
      out.write("					</p>\r\n");
      out.write("				</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li>\r\n");
      out.write("				<a href=\"shopview.do\">\r\n");
      out.write("					<img src=\"/images/shop4.jpg\" alt=\"\">\r\n");
      out.write("					<p class=\"p26\">\r\n");
      out.write("						\r\n");
      out.write("							<span class=\"gallery-title\">상품제목</span>\r\n");
      out.write("							<span class=\"price\">74,800 원</span>\r\n");
      out.write("					</p>\r\n");
      out.write("				</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li>\r\n");
      out.write("				<a href=\"shopview.do\">\r\n");
      out.write("					<img src=\"/images/shop5.jpg\" alt=\"\">\r\n");
      out.write("					<p class=\"p26\">\r\n");
      out.write("						\r\n");
      out.write("							<span class=\"gallery-title\">상품제목</span>\r\n");
      out.write("							<span class=\"price\">74,800 원</span>\r\n");
      out.write("					</p>\r\n");
      out.write("				</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li>\r\n");
      out.write("				<a href=\"shopview.do\">\r\n");
      out.write("					<img src=\"/images/shop6.jpg\" alt=\"\">\r\n");
      out.write("					<p class=\"p26\">\r\n");
      out.write("						\r\n");
      out.write("							<span class=\"gallery-title\">상품제목</span>\r\n");
      out.write("							<span class=\"price\">74,800 원</span>\r\n");
      out.write("					</p>\r\n");
      out.write("				</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li>\r\n");
      out.write("				<a href=\"shopview.do\">\r\n");
      out.write("					<img src=\"/images/shop7.jpg\" alt=\"\">\r\n");
      out.write("					<p class=\"p26\">\r\n");
      out.write("						\r\n");
      out.write("							<span class=\"gallery-title\">상품제목</span>\r\n");
      out.write("							<span class=\"price\">74,800 원</span>\r\n");
      out.write("					</p>\r\n");
      out.write("				</a>\r\n");
      out.write("			</li>\r\n");
      out.write("			<li>\r\n");
      out.write("				<a href=\"shopview.do\">\r\n");
      out.write("					<img src=\"/images/shop8.jpg\" alt=\"\">\r\n");
      out.write("					<p class=\"p26\">\r\n");
      out.write("						\r\n");
      out.write("							<span class=\"gallery-title\">상품제목</span>\r\n");
      out.write("							<span class=\"price\">74,800 원</span>\r\n");
      out.write("					</p>\r\n");
      out.write("				</a>\r\n");
      out.write("			</li>\r\n");
      out.write("		</ul>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"paging\">\r\n");
      out.write("			\r\n");
      out.write("			<a href=\"gallery-write.jsp\" class=\"btn-write\">글쓰기</a>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("	function check() {\r\n");
      out.write("		if(my.cont.value==\"\") {\r\n");
      out.write("			alert(\"검색단어입력하세요\");\r\n");
      out.write("			my.cont.focus;\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("		return true;\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("		<footer>\r\n");
      out.write("			<p>&copy; JANGSU. All &nbsp;&nbsp;&nbsp;Rights Reserved.</p>\r\n");
      out.write("		</footer>\r\n");
      out.write("		<!-- &copy; &nbsp; &gt; > &lt;< -->\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
}
