package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ec.itemDataBeans;
import ec.ecHelper;
import ec.UserDataDTO;
import ec.loginHelper;

public final class myDelete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=Shift_JIS");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

    ecHelper jumptop = ecHelper.getInstance();
    //�Z�b�V�����X�^�[�g
    session = request.getSession();
    //���O�C���ւ̃����N
    loginHelper login = new loginHelper();
     
    boolean LogStat = false;
    String loginName = ""; 
    UserDataDTO user = (UserDataDTO)session.getAttribute("LoginUser");
    
    if(user == null)
    {
        LogStat = false;
    }
    else
    {
        LogStat = true;
        loginName = user.getName();
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=Shift_JIS\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ID�F");
      out.print(user.getUserID() );
      out.write("<br>\n");
      out.write("        NAME�F");
      out.print(user.getName() );
      out.write("<br>\n");
      out.write("        PASS�F");
      out.print(user.getMail() );
      out.write("<br>\n");
      out.write("        ���[���A�h���X�F");
      out.print(user.getMail() );
      out.write("<br>\n");
      out.write("        �Z���F");
      out.print(user.getAddress() );
      out.write("<br>\n");
      out.write("        ���z�F");
      out.print(user.getTotal() );
      out.write("<br>\n");
      out.write("        ���̃��[�U�f�[�^���}�W�ō폜���܂����H<br>\n");
      out.write(" \n");
      out.write("        <a href=\"/kagoyume/myDeleteResult\">�͂�</a><br>\n");
      out.write("        <a href=\"top.jsp\">������</a><br>\n");
      out.write("    </body>\n");
      out.write("     <br>");
      out.print(jumptop.home());
      out.write("</br>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
