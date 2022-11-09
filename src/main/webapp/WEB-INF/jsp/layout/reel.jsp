<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <c:set var="contextRoot" value="${pageContext.request.contextPath}" />

        <!DOCTYPE html>
        <html>

        <head>

            <link rel="shortcut icon" href=" ${contextRoot}/images/gogosideLogo.png" type="">
            <title>GoGoSide</title>


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
            <link href="${contextRoot}/css/reel_style.css" rel="stylesheet" />



        </head>

        <body>
            <div id="test1109" style="position:relative ;height: 30rem;">
                <div class="reel">


                    <!-- 輪播牆 -->
                       
                    <div class="carousel">
                        <div class="wrap">
                            <ul>   
                                 <li><a href="${hl0.highLightHref}"><img src="${url0}" /></a> 
                                </li>
                                <li> <a href="${hl1.highLightHref}"><img src="${url1}" /></a> 
                                </li>
                                <li><a href="${hl2.highLightHref}"> <img src="${url2}" /></a> 
                                </li>
                                <li><a href="${hl3.highLightHref}"> <img src="${url3}" /></a> 
                                </li>
                                <li><a href="${hl4.highLightHref}"> <img src="${url4}" /></a> 
                                </li>
                                <li><a href="${hl5.highLightHref}"> <img src="${url5}" /></a> 
                                </li>
                                <li><a href="${hl6.highLightHref}"> <img src="${url6}" /></a> 
                                </li>
                            </ul>
                        </div>
                        <!-- 新聞 -->

                    </div>
                    <div>
                    <h3>熱門新聞</h3>
                        <ul style=" border:red solid 2px">
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news0.newsNumber}">${news0.newsTitle}</a></li>
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news1.newsNumber}">${news1.newsTitle}</a></li>
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news2.newsNumber}">${news2.newsTitle}</a></li>
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news3.newsNumber}">${news3.newsTitle}</a></li>
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news4.newsNumber}">${news4.newsTitle}</a></li>
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news5.newsNumber}">${news5.newsTitle}</a></li>
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news6.newsNumber}">${news6.newsTitle}</a></li>
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news7.newsNumber}">${news7.newsTitle}</a></li>
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news8.newsNumber}">${news8.newsTitle}</a></li>
                            <li><a href="${contextRoot}/News/ViewNewsPage?id=${news9.newsNumber}">${news9.newsTitle}</a></li>
                        </ul>
                    </div>

                </div>
            </div>
            <script>
                // Hover-Carousel component
                // By Yair Even-Or
                // written in jQuery 2013 -> refactored to vanilla 2020
                // https://github.com/yairEO/hover-carousel

                function HoverCarousel(elm, settings) {
                    this.DOM = {
                        scope: elm,
                        wrap: elm.querySelector("ul").parentNode
                    };

                    this.containerWidth = 0;
                    this.scrollWidth = 0;
                    this.posFromLeft = 0; // Stripe position from the left of the screen
                    this.stripePos = 0; // When relative mouse position inside the thumbs stripe
                    this.animated = null;
                    this.callbacks = {};

                    this.init();
                }

                HoverCarousel.prototype = {
                    init() {
                        this.bind();
                    },

                    destroy() {
                        this.DOM.scope.removeEventListener(
                            "mouseenter",
                            this.callbacks.onMouseEnter
                        );
                        this.DOM.scope.removeEventListener("mousemove", this.callbacks.onMouseMove);
                    },

                    bind() {
                        this.callbacks.onMouseEnter = this.onMouseEnter.bind(this);
                        this.callbacks.onMouseMove = (e) => {
                            if (this.mouseMoveRAF) cancelAnimationFrame(this.mouseMoveRAF);

                            this.mouseMoveRAF = requestAnimationFrame(this.onMouseMove.bind(this, e));
                        };

                        this.DOM.scope.addEventListener("mouseenter", this.callbacks.onMouseEnter);
                        this.DOM.scope.addEventListener("mousemove", this.callbacks.onMouseMove);
                    },

                    // calculate the thumbs container width
                    onMouseEnter(e) {
                        this.nextMore = this.prevMore = false; // reset

                        this.containerWidth = this.DOM.wrap.clientWidth;
                        this.scrollWidth = this.DOM.wrap.scrollWidth;
                        // padding in percentage of the area which the mouse movement affects
                        this.padding = 0.2 * this.containerWidth;
                        this.posFromLeft = this.DOM.wrap.getBoundingClientRect().left;
                        var stripePos = e.pageX - this.padding - this.posFromLeft;
                        this.pos = stripePos / (this.containerWidth - this.padding * 2);
                        this.scrollPos = (this.scrollWidth - this.containerWidth) * this.pos;

                        // temporary add smoothness to the scroll
                        this.DOM.wrap.style.scrollBehavior = "smooth";

                        if (this.scrollPos < 0) this.scrollPos = 0;

                        if (this.scrollPos > this.scrollWidth - this.containerWidth)
                            this.scrollPos = this.scrollWidth - this.containerWidth;

                        this.DOM.wrap.scrollLeft = this.scrollPos;
                        this.DOM.scope.style.setProperty(
                            "--scrollWidth",
                            (this.containerWidth / this.scrollWidth) * 100 + "%"
                        );
                        this.DOM.scope.style.setProperty(
                            "--scrollLleft",
                            (this.scrollPos / this.scrollWidth) * 100 + "%"
                        );

                        // lock UI until mouse-enter scroll is finihsed, after aprox 200ms
                        clearTimeout(this.animated);
                        this.animated = setTimeout(() => {
                            this.animated = null;
                            this.DOM.wrap.style.scrollBehavior = "auto";
                        }, 200);

                        return this;
                    },

                    // move the stripe left or right according to mouse position
                    onMouseMove(e) {
                        // don't move anything until inital movement on 'mouseenter' has finished
                        if (this.animated) return;

                        this.ratio = this.scrollWidth / this.containerWidth;

                        // the mouse X position, "normalized" to the carousel position
                        var stripePos = e.pageX - this.padding - this.posFromLeft;

                        if (stripePos < 0) stripePos = 0;

                        // calculated position between 0 to 1
                        this.pos = stripePos / (this.containerWidth - this.padding * 2);

                        // calculate the percentage of the mouse position within the carousel
                        this.scrollPos = (this.scrollWidth - this.containerWidth) * this.pos;

                        this.DOM.wrap.scrollLeft = this.scrollPos;

                        // update scrollbar
                        if (this.scrollPos < this.scrollWidth - this.containerWidth)
                            this.DOM.scope.style.setProperty(
                                "--scrollLleft",
                                (this.scrollPos / this.scrollWidth) * 100 + "%"
                            );

                        // check if element has reached an edge
                        this.prevMore = this.DOM.wrap.scrollLeft > 0;
                        this.nextMore =
                            this.scrollWidth - this.containerWidth - this.DOM.wrap.scrollLeft > 5;

                        this.DOM.scope.setAttribute(
                            "data-at",
                            (this.prevMore ? "left " : " ") + (this.nextMore ? "right" : "")
                        );
                    }
                };

                var carouselElm = document.querySelector("#test1109 .carousel");
                new HoverCarousel(carouselElm);


            </script>
        </body>

        <!-- jQery -->
        <!-- jQery -->
<%--         <script src="${contextRoot}/js/jquery-3.6.1.min.js"></script> --%>
<!--         bootstrap js -->
<%--         <script src="${contextRoot}/js/bootstrap.bundle.min.js"></script> --%>

        </html>