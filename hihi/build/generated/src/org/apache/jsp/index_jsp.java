package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.SanPhamModel;
import entities.SanPham;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_when_test.release();
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Trang chu</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"> \n");
      out.write("        <link href=\"css/index.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js1/jquery-3.3.1.slim.min.js\" ></script>\n");
      out.write("        <script src=\"js1/popper.min.js\" ></script>\n");
      out.write("        <script src=\"js1/bootstrap.min.js\" ></script> \n");
      out.write("        <style>\n");
      out.write("            .footer{\n");
      out.write("                height: 200px;\n");
      out.write("                background-color: graytext;                                     \n");
      out.write("            }\n");
      out.write("            .footer>div{\n");
      out.write("                text-align: center; \n");
      out.write("                color: white;\n");
      out.write("                padding-top: 50px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"carouselExampleIndicators\" class=\"carousel slide\" data-ride=\"carousel\" >\n");
      out.write("            <ol class=\"carousel-indicators\">\n");
      out.write("                <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\n");
      out.write("                <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\n");
      out.write("                <li data-target=\"#carouselExampleIndicators\" data-slide-to=\"3\"></li>\n");
      out.write("            </ol>\n");
      out.write("            <div class=\"carousel-inner\">\n");
      out.write("                <div class=\"carousel-item active\"  >\n");
      out.write("                    <img src=\"images\\hinh4.jpg\" height=\"500px\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"carousel-item\" >\n");
      out.write("                    <img src=\"images\\hinh3.jpg\" height=\"500px\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("                </div>  \n");
      out.write("                <div class=\"carousel-item\" >\n");
      out.write("                    <img src=\"images\\hinh2.jpg\" height=\"500px\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"carousel-item\" >\n");
      out.write("                    <img src=\"images\\hinh1.jpg\" height=\"500px\" class=\"d-block w-100\" alt=\"...\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                <span class=\"sr-only\">Previous</span>\n");
      out.write("            </a>\n");
      out.write("            <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\" role=\"button\" data-slide=\"next\">\n");
      out.write("                <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                <span class=\"sr-only\">Next</span>\n");
      out.write("            </a>\n");
      out.write("\n");
      out.write("            <div class=\"dangnhap\">                   \n");
      out.write("                <ul>\n");
      out.write("                    ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light \" style=\"background-color: #99FFCC;\">\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">                    \n");
      out.write("                        <a class=\"nav-link\" href=\"#\">Trang Chủ<span class=\"sr-only\" >(current)</span></a>                    \n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"GioiThieu.jsp\">Giới Thiệu</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            Thể Loại\n");
      out.write("                        </a> \n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\" style=\"background-color: #CCFFFF;\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\"></a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">ngôn tình</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">tiểu thuyết</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"#\">kiếm hiệp</a>\n");
      out.write("                                                                         \n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                 \n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"Gopy.jsp\">Góp Ý</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"LienHe.jsp\">Liên Hệ</a>\n");
      out.write("                    </li>                    \n");
      out.write("                </ul>\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\" action=\"SanPhamServlet?yeucau=timkiem\" method=\"post\">\n");
      out.write("                    <input class=\"form-control mr-sm-2\" type=\"search\" name=\"tensp\" placeholder=\"Search\" aria-label=\"Search\">\n");
      out.write("                    <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"row mt-3\" >\n");
      out.write("            <div class=\"col-md-9\">\n");
      out.write("                <form action=\"DeleteSPServlet?yeucau=xoanhieu\" method=\"post\">\n");
      out.write("                    ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listsp==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\n");
          out.write("                        ");

                            ArrayList<SanPham> listSP = new SanPhamModel().getList("");
                        
          out.write("\n");
          out.write("\n");
          out.write("                        ");
          //  c:forEach
          org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
          _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
          _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
          _jspx_th_c_forEach_0.setVar("sp");
          _jspx_th_c_forEach_0.setItems(listSP);
          int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
          try {
            int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
            if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              do {
                out.write("\n");
                out.write("                            <div class=\"col-sm-3\" style=\"float: left; margin-top: 10px;\">\n");
                out.write("                                <div class=\"card\" style=\"\">\n");
                out.write("                                    <img src=\"images/");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sp.getHinh()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                out.write("\" class=\"img-fluid\"  alt=\"...\">\n");
                out.write("                                    <div class=\"card-body\">\n");
                out.write("                                        <h5 class=\"card-title\">");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sp.getTenSP()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                out.write("</h5>\n");
                out.write("                                        <p class=\"card-text\">");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sp.getDonGia()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                out.write("$</p>\n");
                out.write("                                        <a href=\"GioHangServlet?yeucau=muasp&txtmasp=");
                out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sp.getMaSP()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                out.write("\" class=\"btn btn-primary\">Buy now</a>                                             \n");
                out.write("                                    </div>\n");
                out.write("                                </div>\n");
                out.write("                            </div> \n");
                out.write("                        ");
                int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
            }
            if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              return;
            }
          } catch (Throwable _jspx_exception) {
            while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
              out = _jspx_page_context.popBody();
            _jspx_th_c_forEach_0.doCatch(_jspx_exception);
          } finally {
            _jspx_th_c_forEach_0.doFinally();
            _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
          }
          out.write(" \n");
          out.write("\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-3\">\n");
      out.write("                <div class=\"list-group\">\n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action\">Cập nhât mẫu truyện mới</a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action list-group-item-warning\">Tìm bạn bốn phương</a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action list-group-item-primary\">Tư vấn khi mua sách</a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action list-group-item-secondary\">Hỗ trợ mua sách</a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action list-group-item-success\">Kiến thức khi đọc sách</a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action list-group-item-danger\">Kinh nghiệm khi mua sách</a>             \n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action list-group-item-info\">Dịch vụ ship tận nhà</a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action list-group-item-light\">Vấn đề phát sinh</a>\n");
      out.write("                    <a href=\"#\" class=\"list-group-item list-group-item-action list-group-item-dark\">Tuyển dụng bán online</a>\n");
      out.write("                </div>                    \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"footer\">\n");
      out.write("            <div>\n");
      out.write("                <h5>\n");
      out.write("                CÔNG TY TNHH MỘT THÀNH VIÊN LỜ VỜ TỜ. <br>\n");
      out.write("            Địa chỉ: 155A, ĐƯỜNG VÕ THỊ SÁU, KP.TÂY A, PHƯỜNG ĐỒNG HÒA, THỊ XÃ DĨ AN, TĨNH BÌNH DƯƠNG.<br>\n");
      out.write("            Hotline: 0337860990 <br>\n");
      out.write("            Email: TRUNGLVPS08925@FPT.EDU.VN \n");
      out.write("             </h5>\n");
      out.write("                <h4>Cao Đẳng Thực Hành FPT Polytechnic</h4>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\n");
        out.write("                        ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <li>   <a href=\"login.jsp\">Hello ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.getTenKH()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</a>  </li>\n");
        out.write("                            <li>   <a href=\"LoginKhachHangServlet?yeucau=dangxuat\">Logout</a>  </li>\n");
        out.write("                            <li>   <a  href=\"giohang.jsp\">Cart </a>   </li>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <li>   <a href=\"loginkhachhang.jsp\">Login</a>  </li>\n");
        out.write("\n");
        out.write("                            <li>   <a href=\"giohang.jsp\">Cart</a>  </li>\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }
}
