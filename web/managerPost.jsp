
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
        <title>Post Manager</title>
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
                            <table class="table" style="table-layout: fixed; width: 100%;">
                                <thead>
                                    <tr>
                                        <th>Ảnh</th>
                                        <th>Tựa đề</th>
                                        <th>Người đăng</th>
                                        <th>Mô tả</th>
                                        <th>Ngày đăng</th>
                                        <th>Số like</th>
                                        <th>ID</th>
                                        <th>Option</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listP}" var="o">
                                    <tr style="word-break: break-all;">
                                        <td class="thumbnail-img">
                                            <img class="img-fluid" src="${o.thumbnailURL}" alt="" />
                                        </td>


                                        <td class="price-pr" style="overflow:auto; ">
                                            ${o.postTitle}
                                        </td>
                                        <td class="name-pr">
                                            <c:forEach items="${listAccount}" var="i">
                                                <c:if test="${i.accountID == o.accountID}">
                                                    <p>${i.userFullname}</p>
                                                </c:if> 
                                            </c:forEach> 
                                        </td>
                                        <td class="name-pr"  style="width: 300px; overflow: auto;">
                                            <p>${o.postDescription}</p>
                                        </td>
                                        <td class="total-pr">
                                            <p>${o.postDate}</p>
                                        </td>
                                        <td class="total-pr">
                                            <p>${o.postLike}</p>
                                        </td>
                                        <td class="total-pr">
                                            <p>${o.postID}</p>
                                        </td>
                                        <td class="remove-pr">
                                            <a href="updatePostAdmin?idP=${o.postID}" style="padding-right: 3%;" alt="Chỉnh Sửa">
                                                <i class="far fa-edit"></i>
                                            </a>
                                            <a href="deletePost?idP=${o.postID}">
                                                <i class="fas fa-times"></i>
                                            </a>
                                        </td>
                                    </tr>                                             
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