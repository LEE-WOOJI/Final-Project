<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!-- Favicon-->
    <link rel="icon" href="assets/img/favicon.ico" type="image/x-ico" />
    <title>글피 - Glory Trophy</title>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>

    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/body-styles.css" rel="stylesheet" />
    <link href="css/clock.css" rel="stylesheet" />

    <!-- JavaScript Includes -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js"></script>

    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               SB Forms JS                               * *-->
    <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

    <!-- head -->
    <jsp:include page="header.jsp" flush="false" />

    <style type="text/css">
        @font-face {
            font-family: 'yg-jalnan';
            src:
                url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_four@1.2/JalnanOTF00.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }

        * {
            font-family: 'yg-jalnan', verdana, tahoma;
        }
    </style>



</head>

<body id="page-top">
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               캐 러 샐                                  * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="assets/img/carousel/달리기.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="assets/img/carousel/공부.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="assets/img/carousel/명상.jpg" class="d-block w-100" alt="...">
            </div>
        </div>

        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>




    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               글피 카테고리                              * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <section class="page-section bg-light" id="portfolio">
        <div class="container">
            <div class="text-center">
                <h1>카테고리</h1>
                <h5>원하는 종류의 글피 카테고리를 선택해주세요</h5>
            </div>
            <div class="row">
                <div class="col-lg-4 col-sm-6 mb-4">
                    <!-- 건강 카테고리-->
                    <div class="portfolio-item">
                        <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal1">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content"><i class="fas fa-medal"
                                        style="font-size: 50px;"></i></div>
                            </div>
                            <img class="img-fluid" src="assets/img/category/001.png" alt="..." />
                        </a>
                        <div class="portfolio-caption">
                            <div class="portfolio-caption-heading">건강</div>
                            <div class="portfolio-caption-subheading text-muted">Health</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 mb-4">
                    <!-- 취미 카테고리 -->
                    <div class="portfolio-item">
                        <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal2">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content"><i class="fas fa-medal"
                                        style="font-size: 50px;"></i></div>
                            </div>
                            <img class="img-fluid" src="assets/img/category/002.png" alt="..." />
                        </a>
                        <div class="portfolio-caption">
                            <div class="portfolio-caption-heading">취미</div>
                            <div class="portfolio-caption-subheading text-muted">Hobby</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 mb-4">
                    <!-- 금융 카테고리 -->
                    <div class="portfolio-item">
                        <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal3">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content"><i class="fas fa-medal"
                                        style="font-size: 50px;"></i></div>
                            </div>
                            <img class="img-fluid" src="assets/img/category/003.png" alt="..." />
                        </a>
                        <div class="portfolio-caption">
                            <div class="portfolio-caption-heading">금융</div>
                            <div class="portfolio-caption-subheading text-muted">Finance</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 mb-4 mb-lg-0">
                    <!-- 공부 카테고리 -->
                    <div class="portfolio-item">
                        <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal4">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content"><i class="fas fa-medal"
                                        style="font-size: 50px;"></i></div>
                            </div>
                            <img class="img-fluid" src="assets/img/category/004.png" alt="..." />
                        </a>
                        <div class="portfolio-caption">
                            <div class="portfolio-caption-heading">공부</div>
                            <div class="portfolio-caption-subheading text-muted">Study</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6 mb-4 mb-sm-0">
                    <!-- 생활 카테고리 -->
                    <div class="portfolio-item">
                        <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal5">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content"><i class="fas fa-medal"
                                        style="font-size: 50px;"></i></div>
                            </div>
                            <img class="img-fluid" src="assets/img/category/005.png" alt="..." />
                        </a>
                        <div class="portfolio-caption">
                            <div class="portfolio-caption-heading">생활</div>
                            <div class="portfolio-caption-subheading text-muted">Life</div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <!-- 펫/환경 카테고리 -->
                    <div class="portfolio-item">
                        <a class="portfolio-link" data-bs-toggle="modal" href="#portfolioModal6">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content"><i class="fas fa-medal"
                                        style="font-size: 50px;"></i></div>
                            </div>
                            <img class="img-fluid" src="assets/img/category/006.png" alt="..." />
                        </a>
                        <div class="portfolio-caption">
                            <div class="portfolio-caption-heading">펫/환경</div>
                            <div class="portfolio-caption-subheading text-muted">Pet/Environment</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               글피 소개                                  * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <section id="about" >
        <div class="row" style="padding-top: 300px; padding-bottom: 300px;">
            <div class="col-12" style="text-align: center;">
                <img src="assets/img/about/trophy.png" class="img-fluid" style="padding-bottom: 50px;">
                <h1>'글피' 소개</h1><br><br> 
                <h4> 글피는 글로리 트로피(Glory Trophy)의 줄임말으로<br><br>
                    습관을 완수한 당신은 영광스러운 트로피를 받을 자격이 있다는 의미입니다.<br><br>
                    작은 습관들이 모여 나의 하루가 되고 인생이 됩니다.<br><br>
                    오늘부터 작은 습관을 쌓아 인생을 바꾸세요!
                </h4>
            </div>
        </div>

        <!--01. 나에게 필요한 글피 선택-->
        <div class="row" style="padding-top: 300px; padding-bottom: 300px; text-align: center;">
            <div class="col-xl-6 col-lg-12" style="padding: 50px">
                <h1>01</h1>
                <h1 style="padding: 30px;" > 나에게 필요한 글피 선택</h1>
                <h4>미라클 모닝,영어공부,운동,취미 등<br><br> 
                    작심삼일을 넘어 글피까지도<br><br> 
                    같은 목표를 가진 사람들과 함께 
                    <br> <br>좋은 습관을 형성합니다.</h4>
            </div>
            <div class=" col-xl-6 p-5">
                <img src="assets/img/about/click.png" style="width: 100%;" class="img-fluid" />
            </div>
        </div>

        <!--02. 사진으로 인증하기-->
        <div class="row" style="padding-top: 300px; padding-bottom: 300px; text-align: center; ">
            <div class="col-xl-6 col-lg-12 order-2" style="padding: 50px">
                <img src="assets/img/about/certifi.png" style="width: 100%;" class="img-fluid" />
            </div>
            <div class=" col-xl-6 p-5 order-1">
                <h1>02</h1>
                <h1 style="padding: 30px;" >인증하기</h1><br>
                <h4> 매일 실천한 일은 정해진 기준에 따라<br><br> 
                    인증샷을 찍고 <br><br> 
                    정해진 시간내에 업로드를 합니다.</h4>
            </div>
        </div>

        <!--03. 환급-->
        <div class="row" style="padding-top: 300px; padding-bottom: 300px; text-align: center; ">
            <div class="col-xl-6 col-lg-12" style="padding: 50px">
                <h1 >03</h1>
                <h1 style="padding: 30px;" >내 의지를 돈으로 건다</h1>
                <h4>시작 전 참가비 10,000원을 걸고,<br><br>
                    내가 실천한 만큼 참가비를 환급 받습니다.<br><br>
                    50% 미만 달성시에는 환급받을 수 없으니 주의해주세요 !</h4>
            </div>
            <div class=" col-xl-6 p-5">
                <img src="assets/img/about/money.png" style="width: 100%;" class="img-fluid" />
            </div>
        </div>

    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               시계 부분                                  * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <div class="row text-align center" style="padding-bottom: 300px; text-align: center; ">
            <div class="col-lg-8 mx-auto text-center">
                <div id="clock" class="light">
                    <div class="display">
                        <div class="weekdays"></div>
                        <div class="ampm"></div>
                        <div class="alarm"></div>
                        <div class="digits"></div>
                    </div>
                </div>

                <!-- 라이트 / 다크 테마 변경 ! -->
                <!-- <div class="button-holder">
                    <a class="button">시계 테마 변경 </a>
                </div> -->

                <h4 class="large text-muted">
                    미래는 현재 우리가 무엇을 하는가에 달려 있다 - 마하트마 간디<br><br>
                    The future depends on what we do in the present - Mahatma Gandhi 
                </h4>
            </div>
        </div>
    </section>


     <!-- Footer-->
     <jsp:include page="footer.jsp" flush="false" />

</body>


<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</html>
