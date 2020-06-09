<%-- 
    Document   : index
    Created on : Dec 27, 2019, 6:58:15 PM
    Author     : trung
--%>

<%@page import="java.util.List"%>
<%@page import="model.SanPhamModel"%>
<%@page import="entities.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"> 
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
        <script src="js1/jquery-3.3.1.slim.min.js" ></script>
        <script src="js1/popper.min.js" ></script>
        <script src="js1/bootstrap.min.js" ></script> 
        <style>
            .footer{
                height: 200px;
                background-color: graytext;                                     
            }
            .footer>div{
                text-align: center; 
                color: white;
                padding-top: 50px;
            }
        </style>
    </head>
    <body>

        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" >
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active"  >
                    <img src="images\hinh4.jpg" height="500px" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item" >
                    <img src="images\hinh3.jpg" height="500px" class="d-block w-100" alt="...">
                </div>  
                <div class="carousel-item" >
                    <img src="images\hinh2.jpg" height="500px" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item" >
                    <img src="images\hinh1.jpg" height="500px" class="d-block w-100" alt="...">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>

            <div class="dangnhap">                   
                <ul>
                    <c:choose>

                        <c:when test="${user!=null}">
                            <li>   <a href="login.jsp">Hello ${user.getTenKH()}</a>  </li>
                            <li>   <a href="LoginKhachHangServlet?yeucau=dangxuat">Logout</a>  </li>
<!--                            <li>   <a  href="giohang.jsp">Cart </a>   </li>-->
                            </c:when>

                        <c:when test="${user==null}">
                            <li>   <a href="loginadmin.jsp">Login</a>  </li>

<!--                            <li>   <a href="giohang.jsp">Cart</a>  </li>-->
                            </c:when>

                    </c:choose>

                </ul>
            </div>
        </div>


        <nav class="navbar navbar-expand-lg navbar-light " style="background-color: #99FFCC;">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">                    
                        <a class="nav-link" href="#">Trang Chủ<span class="sr-only" >(current)</span></a>                    
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="GioiThieu.jsp">Giới Thiệu</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Thể Loại
                        </a> 
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="background-color: #CCFFFF;">
                            <a class="dropdown-item" href="#"></a>
                            <a class="dropdown-item" href="#">ngôn tình</a>
                            <a class="dropdown-item" href="#">tiểu thuyết</a>
                            <a class="dropdown-item" href="#">kiếm hiệp</a>
                                                                         
                        </div>
                    </li>
                 
                    <li class="nav-item">
                        <a class="nav-link" href="Gopy.jsp">Góp Ý</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="LienHe.jsp">Liên Hệ</a>
                    </li>                    
                </ul>
                <form class="form-inline my-2 my-lg-0" action="SanPhamServlet?yeucau=timkiem" method="post">
                    <input class="form-control mr-sm-2" type="search" name="tensp" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>

        <div class="row mt-3" >
            <div class="col-md-9">
                <form action="DeleteSPServlet?yeucau=xoanhieu" method="post">
                    <c:if test="${listsp==null}" >

                        <%
                            ArrayList<SanPham> listSP = new SanPhamModel().getList("");
                        %>

                        <c:forEach var="sp" items="<%=listSP%>">
                            <div class="col-sm-3" style="float: left; margin-top: 10px;">
                                <div class="card" style="">
                                    <img src="images/${sp.getHinh()}" class="img-fluid"  alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">${sp.getTenSP()}</h5>
                                        <p class="card-text">${sp.getDonGia()}$</p>
                                        <a href="GioHangServlet?yeucau=muasp&txtmasp=${sp.getMaSP()}" class="btn btn-primary">Buy now</a>                                             
                                    </div>
                                </div>
                            </div> 
                        </c:forEach> 

                    </c:if>



                </form>
            </div>
            <div class="col-md-3">
                <div class="list-group">
                    <a href="#" class="list-group-item list-group-item-action">Cập nhât mẫu truyện mới</a>
                    <a href="#" class="list-group-item list-group-item-action list-group-item-warning">Tìm bạn bốn phương</a>
                    <a href="#" class="list-group-item list-group-item-action list-group-item-primary">Tư vấn khi mua sách</a>
                    <a href="#" class="list-group-item list-group-item-action list-group-item-secondary">Hỗ trợ mua sách</a>
                    <a href="#" class="list-group-item list-group-item-action list-group-item-success">Kiến thức khi đọc sách</a>
                    <a href="#" class="list-group-item list-group-item-action list-group-item-danger">Kinh nghiệm khi mua sách</a>             
                    <a href="#" class="list-group-item list-group-item-action list-group-item-info">Dịch vụ ship tận nhà</a>
                    <a href="#" class="list-group-item list-group-item-action list-group-item-light">Vấn đề phát sinh</a>
                    <a href="#" class="list-group-item list-group-item-action list-group-item-dark">Tuyển dụng bán online</a>
                </div>                    
            </div>
        </div>

        <div class="footer">
            <div>
                <h5>
                CÔNG TY TNHH MỘT THÀNH VIÊN LỜ VỜ TỜ. <br>
            Địa chỉ: 155A, ĐƯỜNG VÕ THỊ SÁU, KP.TÂY A, PHƯỜNG ĐỒNG HÒA, THỊ XÃ DĨ AN, TĨNH BÌNH DƯƠNG.<br>
            Hotline: 0337860990 <br>
            Email: TRUNGLVPS08925@FPT.EDU.VN 
             </h5>
                <h4>Cao Đẳng Thực Hành FPT Polytechnic</h4>
            </div>
        </div>
    </body>
</html>
