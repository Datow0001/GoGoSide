<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <link href="${contextRoot}/css/login_style.css" rel="stylesheet" />


            </head>

            <body>
                <div id="block" class="w3lvide-content" data-vide-bg="images/freelan"
                     data-vide-options="position: 0% 50%">
                    <!-- /form -->
                    <div class="workinghny-form-grid">
                        <div class="main-hotair">
                            <div class="content-wthree">
                                <h1>歡迎來到GoGoSide果果賽</h1>

                                <form id="loginForm" method="POST" action>
                                    <input type="text" class="text input1" name="account" placeholder="帳號" required=""
                                           autofocus>
                                    <input type="password" class="password input1" name="password" placeholder="密碼"
                                           required=""
                                           autofocus>
                                    <button class="btn" type="submit">登入</button>
                                    <div class="ckbutton">
                                        <input class="ckbutton_checkbox" type="checkbox" value="" name=""
                                               id="ckbutton_id">
                                        <label class="ckbutton_label" for="ckbutton_id">
                                            <span>
                                                記住我的帳號密碼
                                            </span>
                                        </label>
                                        <a href=""> <span class="fg">忘記密碼?</span></a>
                                    </div>
                                </form>


                                <p><span class="slog">使用社群登入</span></p>
                                <div class="social-login">
                                    <a href="#facebook">

                                        <span class="fa fa-facebook" aria-hidden="true"></span>


                                    </a>
                                    <a href="#twiter">

                                        <span class="fa fa-twitter" aria-hidden="true"></span>

                                    </a>
                                    <a href="#google">

                                        <span class="fa fa-google-plus" aria-hidden="true"></span>

                                    </a>

                                    <a href="#insta">

                                        <span class="fa fa-pinterest" aria-hidden="true"></span>
                                    </a>
                                </div>

                                <div class="crt">
                                    <span class="continue ">還沒有帳號嗎?建立一個吧!!</span>
                                    <a class="btnA" href="${contextRoot}/registerForm">創建帳號</a>
                                </div>

                            </div>

                        </div>


                        <!-- 版權聲明 -->
                        <div class="copyright text-center">
                            <p>
                                &copy; <span></span> EEIT152GROUP 4th GOGOSIDE
                            </p>
                        </div>
                        <!-- 版權聲明end -->

                    </div>
                </div>







            </body>
            <!-- jQery -->
            <script src="${contextRoot}/js/jquery-3.6.1.min.js"></script>
            <!-- //js -->
            <script src="${contextRoot}/js/jquery.vide.js"></script>
            <!-- bootstrap js -->
            <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>

        </html>