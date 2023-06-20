<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container pt-3">



         <div class="culmn">
        <!--   Home page style-->


            <nav class="navbar navbar-default bootsnav navbar-fixed no-background white">

               
                <div class="top-search">
                    <div class="container">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-search"></i></span>
                            <input type="text" class="form-control" placeholder="Search">
                            <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                        </div>
                    </div>
                </div>
                   <!-- End Top Search 위에 헤더 home~~~여기 색깔이랑 스타일-->

	      <div class="container"> 
                    <div class="attr-nav">
                        <ul>
                            <li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
                        </ul>
                    </div> <!-- 헤더 내용 너무 끝쪽으로 안붙게 해주는 영역 -->

            
                    <!-- Start Header Navigation -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="#brand">
                            <img src="assets/images/logo.png" class="logo" alt="">
                            <!--<img src="assets/images/footer-logo.png" class="logo logo-scrolled" alt="">-->
                        </a>

                    </div>
                    <!-- End Header Navigation -->

                    <!-- navbar menu -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#home">Home</a></li>                    
                            <li><a href="#about">노란색</a></li>
                            <li><a href="#service">로그인</a></li>
                            <li><a href="#portfolio">게시판</a></li>
                            <li><a href="#test">회원가입</a></li>
                            <li><a href="#contact">푸터</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div> 

            </nav>

            <!--Home Sections-->

            <section id="home" class="home bg-black fix">
                <div class="overlay"></div>
                <div class="container">
                    <div class="row">
                        <div class="main_home text-center">
                            <div class="col-md-12">
                                <div class="hello">
                                    <div class="slid_item">
                                        <div class="home_text ">
                                            <h1 class="text-yellow">CHECK IN FOR U</h1>
                                            <h3 class="text-white text-uppercase">when is your flight to? </h3>
                                        </div>
                                    </div><!-- End off slid item -->
                                </div>
                            </div>
                        </div>
                        <a class="mouse-scroll" href="#about"> 
                            <span class="mouse">
                                <span class="mouse-movement"></span>
                            </span>
                            <span class="mouse-message fadeIn">이동봉사하러가기!</span> <br />
                           
                        </a>

                    </div><!--End off row-->
                </div><!--End off container -->
            </section> <!--End off Home Sections-->
            


            <!--About Section-->
            <section id="about" class="about bg-yellow roomy-80">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="main_about text-center">
                                <h3 class="text-black"> WE LOVE DOG! </h3>
                                <h2 class="text-white">- & -</h2>
                                <h3 class="text-black text-uppercase">WE LOVE DOG! Adopt a dog rather than buying one.</h3>

                                <a href="" class="btn btn-primary m-top-100">apply volunteer!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>

        </div>
</body>
</html>
        