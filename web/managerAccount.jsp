
<%@page import="model.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Account Manager</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <jsp:include page="Header.jsp"></jsp:include>


            <!-- Start All Title Box -->
            <div class="all-title-box">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h2>Manager</h2>
                            <ul class="breadcrumb">
                                <li class="breadcrumb-item"><a href="HomeServlet">home</a></li>
                                <li class="breadcrumb-item active">Manager</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End All Title Box -->

            <!-- Start Cart  -->
            <div class="cart-box-main">
                <div class="container">
                    <div class="row col-lg-12">
                        <div class="table-main table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Ảnh</th>
                                        <th>Email</th>
                                        <th>Tên người dùng</th>
                                        <th>Tên đầy đủ</th>
                                        <th>Ngày tạo</th>
                                        <th>Admin</th>
                                        <th>ID</th>
                                        <th>Lựa chọn</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listA}" var="o">
                                    <c:if test="${currentAccount.accountID != o.accountID}">
                                        <tr>
                                            <td class="thumbnail-img">
                                                <img class="img-fluid" src="${o.userImage}" alt="" />
                                            </td>
                                            <td class="name-pr">
                                                <p>${o.userEmail}</p>
                                            </td>
                                            <td class="price-pr">
                                                <p>${o.username}</p>
                                            </td>
                                            <td class="name-pr">
                                                <p>${o.userFullname}</p>
                                            </td>
                                            <td class="total-pr">
                                                <p>${o.createDate}</p>
                                            </td>
                                            <td class="total-pr">
                                                <p>${o.isAdmin}</p>
                                                <c:if test="${o.isAdmin == true}">
                                                    
                                                    <a href="updateAdmin?idA=${o.accountID}&changeTo=${o.isAdmin == true ? 0:1}" style="color: red;">
                                                        Gỡ Quyền
                                                    </a>
                                                </c:if>
                                                <c:if test="${o.isAdmin != true}">
                                                    <a href="updateAdmin?idA=${o.accountID}&changeTo=${o.isAdmin == true ? 0:1}" style="color: green;">
                                                        Cấp quyền
                                                    </a>
                                                </c:if>
                                            </td>
                                            <td class="total-pr">
                                                <p>${o.accountID}</p>
                                            </td>
                                            <td class="remove-pr">
                                                <a href="deleteAccount?idA=${o.accountID}">
                                                    <i class="fas fa-times"></i>
                                                </a>

                                            </td>
                                        </tr>                                             
                                    </c:if>

                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
<!--            <div class="container">
                <div class="row col-lg-12">
                    <div class="col-lg-7 col-sm-6">
                        <div class="update-box" style="text-align: center;">
                            <input value="Update Cart" type="submit">
                        </div>
                    </div>
                </div>

            </div>-->
        </div>
        <!-- End Cart -->

        <jsp:include page="Footer.jsp"></jsp:include>

        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

        <!-- ALL JS FILES -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- ALL PLUGINS -->
        <script src="js/jquery.superslides.min.js"></script>
        <script src="js/bootstrap-select.js"></script>
        <script src="js/inewsticker.js"></script>
        <script src="js/bootsnav.js."></script>
        <script src="js/images-loded.min.js"></script>
        <script src="js/isotope.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/baguetteBox.min.js"></script>
        <script src="js/form-validator.min.js"></script>
        <script src="js/contact-form-script.js"></script>
        <script src="js/custom.js"></script>
    </body>

</html>