package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ec.itemDataBeans;
import ec.ecHelper;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    //ecHelper jumptop = ecHelper.getInstance();
    //�Z�b�V�����X�^�[�g
    session = request.getSession();
    int sum = (int)request.getAttribute("sum");
    
    itemDataBeans iDB = (itemDataBeans)session.getAttribute("cartData");
    //���i�摜�E���i���Ƌ��z��\������E
    //�폜�{�^��������
    //��ʉ����ɍ��v���z�̕\��

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=Shift_JIS\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"menu\">\n");
      out.write("        <h1>�J�[�g�̒��g</h1>\n");
      out.write("        ");
if(iDB.getItemCnt() > 0)
        {
      out.write("\n");
      out.write("            ");
for(int i=0; i < iDB.getItemCnt();i++)
            {
      out.write("\n");
      out.write("            \n");
      out.write("            <a href=\"item?ItemIndex=");
      out.print(i );
      out.write("\">\n");
      out.write("            <img src=");
      out.print( iDB.getImageURL(i) );
      out.write(" alt=\"\">\n");
      out.write("            <p class=\"title\">");
      out.print( "�i���F"+iDB.getName(i) );
      out.write("</p>\n");
      out.write("            <p class=\"desc\">");
      out.print( "���i�F" +iDB.getPrice(i) );
      out.write("</p>\n");
      out.write("            </a>\n");
      out.write("            \n");
      out.write("            <form action=delete method=\"GET\">\n");
      out.write("            <input type=\"submit\" name=\"btnDelete\" value=\"�폜\">\n");
      out.write("            <input type=\"hidden\" name=\"deleteIndex\"  value=\"");
      out.print(i);
      out.write("\">\n");
      out.write("            </form>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        ");
}
        else
        {
      out.write("\n");
      out.write("            �J�[�g�̒��g������܂���<br>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </body>\n");
      out.write("    ���v���z�F");
      out.print( sum);
      out.write("\n");
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
