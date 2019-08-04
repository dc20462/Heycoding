<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>자바중학교</title>
    <link rel="stylesheet" href="css/mainstyle.css">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<script>
    $('.carousel').carousel({
        interval: 2000
    })
    $('ul.li.dropdown').hover(function () {
        $(this).find('.dropdown').stop(true, true).delay(200).fadeIn(500);
    }, function () {
        $(this).find('.dropdown').stop(true, true).delay(200).fadeOut(500);
    });
</script>

<body>
    <!-- 헤더 시작 -->
    <div class="header">
        <nav class="navbar navbar-expand-md bg-dark navbar-dark px-5">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <!-- 리스트 -->
                <ul class="navbar-nav">
                	<li><a class="navbar-brand" href="#"><img class="logo" src="img/mainlogo.png" alt="자바중학교"></a></li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">학교소개</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">인사말</a>
                            <a class="dropdown-item" href="#">학교연혁</a>
                            <a class="dropdown-item" href="#">교직원소개</a>
                            <a class="dropdown-item" href="#">오시는길</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">알림마당</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">공지사항</a>
                            <a class="dropdown-item" href="#">가정통신문</a>
                            <a class="dropdown-item" href="#">급식게시판</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">학교생활</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">학교갤러리</a>
                            <a class="dropdown-item" href="#">동아리활동</a>
                            <a class="dropdown-item" href="#">봉사활동</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">커뮤니티</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="freeboardList.main">자유게시판</a>
                            <a class="dropdown-item" href="#">익명게시판</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <!-- 헤더 끝 -->

    <!-- 카루셀 시작 -->
    <div id="demo" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <!-- 슬라이드쇼 -->
            <div class="carousel-item active">
                <img class="d-block w-100" src="img/mainslide1.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="img/mainslide2.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="img/mainslide3.jpg" alt="Third slide">
            </div>
            <!-- 슬라이드 쇼 끝 -->
            <!-- 넘김 버튼 -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <!-- <span>Previous</span> -->
            </a> <a class="carousel-control-next" href="#demo" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <!-- <span>Next</span> -->
            </a>
            <!-- 버튼 끝 -->
            <!-- 인디케이터 : 0부터 시작 -->
            <ul class="carousel-indicators">
                <li data-target="#demo" data-slide-to="0" class="active"></li>
                <li data-target="#demo" data-slide-to="1"></li>
                <li data-target="#demo" data-slide-to="2"></li>
            </ul>
            <!-- 인디케이터 끝 -->
        </div>
        <!-- 카루셀 끝 -->

        <!-- 게시판 1-->
        <div class="container p-4">
            <div class="row">
                <div class="col-lg-5 col-md-10 p-3">
                    <h1 class="display-4 mb-4">JAVA <b>NOTICE</b></h1>
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-notice-tab" data-toggle="tab" href="#nav-home"
                            role="tab" aria-controls="nav-notice" aria-selected="true">공지사항</a>
                        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile"
                            role="tab" aria-controls="nav-profile" aria-selected="false">가정통신문</a>
                        <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact"
                            role="tab" aria-controls="nav-contact" aria-selected="false">급식메뉴</a>
                    </div>
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="nav-notice" role="tabpanel"
                            aria-labelledby="nav-notice-tab">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Firstname</th>
                                        <th>Lastname</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>Mary</td>
                                        <td>Moe</td>
                                        <td>mary@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>July</td>
                                        <td>Dooley</td>
                                        <td>july@example.com</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Firstname</th>
                                        <th>Lastname</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>Mary</td>
                                        <td>Moe</td>
                                        <td>mary@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>July</td>
                                        <td>Dooley</td>
                                        <td>july@example.com</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Firstname</th>
                                        <th>Lastname</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>Mary</td>
                                        <td>Moe</td>
                                        <td>mary@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>July</td>
                                        <td>Dooley</td>
                                        <td>july@example.com</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!-- 게시판 2 -->
                <div class="col-lg-5 col-md-10 p-3">
                    <h1 class="display-4 mb-4">JAVA <b>DATA</b></h1>
                    <div class="nav nav-tabs" id="nav-data-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-gallery-tab" data-toggle="tab" href="#nav-gallery"
                            role="tab" aria-controls="nav-data" aria-selected="true">학교갤러리</a>
                        <a class="nav-item nav-link" id="nav-activity-tab" data-toggle="tab" href="#nav-activity"
                            role="tab" aria-controls="nav-profile" aria-selected="false">동아리활동</a>
                        <a class="nav-item nav-link" id="nav-freeboard-tab" data-toggle="tab" href="#nav-freeboard"
                            role="tab" aria-controls="nav-contact" aria-selected="false">자유게시판</a>
                    </div>
                    <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="nav-gallery" role="tabpanel" aria-labelledby="nav-gallery-tab">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Firstname</th>
                                        <th>Lastname</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>Mary</td>
                                        <td>Moe</td>
                                        <td>mary@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>July</td>
                                        <td>Dooley</td>
                                        <td>july@example.com</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane fade" id="nav-activity" role="tabpanel" aria-labelledby="nav-activity-tab">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Firstname</th>
                                        <th>Lastname</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>Mary</td>
                                        <td>Moe</td>
                                        <td>mary@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>July</td>
                                        <td>Dooley</td>
                                        <td>july@example.com</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane fade" id="nav-freeboard" role="tabpanel" aria-labelledby="nav-freeboard-tab">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Firstname</th>
                                        <th>Lastname</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>John</td>
                                        <td>Doe</td>
                                        <td>john@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>Mary</td>
                                        <td>Moe</td>
                                        <td>mary@example.com</td>
                                    </tr>
                                    <tr>
                                        <td>July</td>
                                        <td>Dooley</td>
                                        <td>july@example.com</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- today -->
                <div class="col-lg-2 col-md-10 p-3">
                <h1 class="display-4 mb-4">TODAY <b>VIEW</b></h1>
                    <table class="table">
                        <tr>
                            <td><h5>Today</h5></td>
                            <td>111</td>
                        </tr>
                        <tr>
                            <td><h5>Total</h5></td>
                            <td>1,000,111</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <!-- ABOUT JAVA -->
        <section id="about" class="">
            <div class="container-fluid p-5">
                <div class="row">
                    <div class="col text-center">
                        <h1 class="display-4 text-uppercase text-dark mb-4">ABOUT JAVA MIDDLE SCHOOL</h1>
                    </div>
                    <div class="row py-3 no-gutters">
                        <div class="col-sm-6 col-md-4 my-12"> 
                        	<img src="img/circle3.png" alt="" class="img-fluid">
                        	<div class="col text-center">
                        		<h5 class="text-dark mb-4">학교상징</h1>
               				</div>
                        </div>
                        <div class="col-sm-6 col-md-4 my-12"> <img src="img/circle2.png" alt="" class="img-fluid">
                        	<div class="col text-center">
                        		<h5 class="text-dark mb-4">학교투어</h1>
               				</div>
               			</div>
                        <div class="col-sm-6 col-md-4 my-12">
                         	<img src="img/circle.png" alt="" class="img-fluid"> 
                         	<div class="col text-center">
                        		<h5 class="text-dark mb-4">학교행사</h1>
               				</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <!-- 영상 -->
    <section id="movie" class="">
        <div class="container-fluid px-5 py-5 bg-light">
            <div class="row">
                <div class="col text-center">
                        <h1 class="display-4 text-uppercase text-dark mb-4">ABOUT JAVA MIDDLE SCHOOL</h1>
                </div>
                <div class="embed-responsive embed-responsive-16by9">
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/L40f5mgQGfY" frameborder="0"
                        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe>
                </div>
            </div>
        </div>
    </section>

    <!-- 푸터 -->
    <section id="footer" class="">
        <div class="container-fluid p-5 bg-secondary">
            <div class="row">
           		<img src="img/footer_logo.png" alt="" class="img-fluid"> 
                (우) 부산광역시 진구 전포동
                교무실 : 051-000-0000
                행정실 : 051-000-0000
                ALL RIGHTS RESERVED.
            </div>
        </div>
    </section>

    <!-- 부트스트랩 -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>