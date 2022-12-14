<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />

        <!DOCTYPE html>
        <html>

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="keywords" content="" />
                <meta name="description" content="" />
                <meta name="author" content="" />


                <link rel="shortcut icon" href="${contextRoot}/images/gogosideLogo.png" type="">
                <title> GoGoSide </title>


                <!-- bootstrap core css -->
                <link rel="stylesheet" type="text/css" href="${contextRoot}/css/bootstrap.css" />
                <!--owl slider stylesheet -->
                <link rel="stylesheet" type="text/css"
                      href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
                <!-- nice select  -->
                <link rel="stylesheet"
                      href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css"
                      integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ=="
                      crossorigin="anonymous" />
                <!-- font awesome style -->
                <link href="${contextRoot}/css/font-awesome.min.css" rel="stylesheet" />
                <!-- responsive style -->
                <link href="${contextRoot}/css/responsive.css" rel="stylesheet" />
                <script src="https://kit.fontawesome.com/104e2ed605.js" crossorigin="anonymous"></script>



                <!-- Custom styles for this template -->
                <link href="${contextRoot}/css/footer_style.css" rel="stylesheet" />


            </head>

            <body>
                <footer class="footer_section">

                    <!-- ????????? -->
                    <div class="footer_contact">
                        <span>????????????</span>
                        <a href="">
                            <i class="fa fa-envelope" aria-hidden="true"></i>
                            <span>gogoside@gmail.com</span>
                        </a>
                    </div>

                    <!-- ???????????? -->
                    <div class="footer-info">
                        <p>
                            &copy; <span></span> EEIT152GROUP 4th GOGOSIDE
                        </p>
                    </div>

                </footer>



            </body>
            <!-- jQery -->
<%--             <script src="${contextRoot}/js/jquery-3.6.1.min.js"></script> --%>
            <!-- bootstrap js -->
<%--             <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script> --%>

        </html>