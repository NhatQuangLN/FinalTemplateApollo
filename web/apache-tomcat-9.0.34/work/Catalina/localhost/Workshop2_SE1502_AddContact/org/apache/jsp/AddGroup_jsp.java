/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.34
 * Generated at: 2021-07-06 05:49:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddGroup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/F:/prj/Workshop2_SE1502_AddContact/build/web/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.4.jar!/META-INF/c.tld", Long.valueOf(1420530628000L));
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.4.jar", Long.valueOf(1625417070338L));
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n");
      out.write("    <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\" />\r\n");
      out.write("    <title>Adding Group</title>\r\n");
      out.write("    <!-- MDB icon -->\r\n");
      out.write("    <!-- <link rel=\"icon\" href=\"img/mdb-favicon.ico\" type=\"image/x-icon\" /> -->\r\n");
      out.write("    <!-- Font Awesome -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.15.2/css/all.css\" />\r\n");
      out.write("    <!-- Google Fonts Roboto -->\r\n");
      out.write("    <link rel=\"stylesheet\"\r\n");
      out.write("        href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap\" />\r\n");
      out.write("     <!-- MDB -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/mdb.min.css\" />\r\n");
      out.write("        <!--Sweet alert-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"swal-package/dist/sweetalert2.min.css\">\r\n");
      out.write("        <!--JQuery-->\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- Start your project here-->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row d-flex justify-content-center\">\r\n");
      out.write("            <h1 style=\"text-align:center;\" class=\"mt-5 mb-4\">Add a Group!</h1>\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("                <form action=\"AddGroupControl\">\r\n");
      out.write("                    <!-- Group Name input -->\r\n");
      out.write("                    <div class=\"form-outline mb-4\">\r\n");
      out.write("                        <input type=\"text\" id=\"groupName\" name=\"groupName\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lastInputGroup.groupName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required />\r\n");
      out.write("                        <label class=\"form-label\" for=\"groupName\">Name</label>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <!--Description input -->\r\n");
      out.write("                    <div class=\"form-outline mb-4\">\r\n");
      out.write("                        <input type=\"text\" id=\"groupDescription\" name=\"groupDescription\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lastInputGroup.groupDescription}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required />\r\n");
      out.write("                        <label class=\"form-label\" for=\"groupDescription\">Description</label>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col\">\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary btn-block mb-4\">Add</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col\">\r\n");
      out.write("                            <a href=\"ShowListGroups\"><button type=\"button\" class=\"btn btn-light btn-block mb-4\">Return to Group\r\n");
      out.write("                                    List</button></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- End your project here-->\r\n");
      out.write("        ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("     <!-- MDB -->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/mdb.min.js\"></script>\r\n");
      out.write("        <!-- Custom scripts -->\r\n");
      out.write("        <script type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"swal-package/dist/sweetalert2.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
      // /AddGroup.jsp(59,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addMess == 'true'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("            <script>\r\n");
          out.write("                $(window).on('load', function () {\r\n");
          out.write("                    Swal.fire({\r\n");
          out.write("                        title: 'Add Successfully',\r\n");
          out.write("                        icon: 'success',\r\n");
          out.write("                        showConfirmButton: false,\r\n");
          out.write("\r\n");
          out.write("                    });                    \r\n");
          out.write("                    setTimeout(function(){\r\n");
          out.write("                     $(document).ready(function () {\r\n");
          out.write("                        $(location).attr('href', \"ShowListGroups\");\r\n");
          out.write("                    });\r\n");
          out.write("                    },1200);                    \r\n");
          out.write("                });\r\n");
          out.write("            </script>\r\n");
          out.write("        ");
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
      // /AddGroup.jsp(76,8) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addMess == 'false'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("            <script type=\"text/javascript\">\r\n");
          out.write("                $(window).on('load', function () {\r\n");
          out.write("                    Swal.fire({\r\n");
          out.write("                        title: 'Oops...',\r\n");
          out.write("                        text: 'Something went wrong!',\r\n");
          out.write("    //                    html: '<div>Something went wrong! </div> <div> First Name and Last Name must be less or equal than 100 character. </div>Phone must be numeric and less or equal than 20 digits.',\r\n");
          out.write("\r\n");
          out.write("                        icon: 'error',\r\n");
          out.write("                        showConfirmButton: true,\r\n");
          out.write("    //                    footer: '<a href=\"\">Why do I have this issue?</a>'\r\n");
          out.write("                        footer: '<a id=\"show\" href=\"#\">\\n\\\r\n");
          out.write("                                Why do I have this issue?</a>\\n\\\r\n");
          out.write("                                   <div id=\"whyError\" style=\"display:none; text-align: center\">\\n\\\r\n");
          out.write("                                         <div>Group Name must at most 100 character. </div>\\n\\\r\n");
          out.write("                                        <div>Group description must at most 500 character.</div>\\n\\\r\n");
          out.write("                                    </div>\\n\\\r\n");
          out.write("                                '\r\n");
          out.write("    //                    footer: '<p>\\n\\abc</p>'\r\n");
          out.write("                    });\r\n");
          out.write("                    $(document).ready(function () {\r\n");
          out.write("                        $(\"#show\").click(function () {\r\n");
          out.write("                            $(\"#whyError\").show();\r\n");
          out.write("                            $(\"#show\").hide();\r\n");
          out.write("                        });\r\n");
          out.write("                    });\r\n");
          out.write("                });\r\n");
          out.write("\r\n");
          out.write("            </script>\r\n");
          out.write("        ");
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
}
