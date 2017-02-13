<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="cs_CZ">
<!--  head starts -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>QoE</title>

<link href="/qoe/assets/bootstrap/css/bootstrap.css"
	type="text/css" rel="stylesheet" media="all">
<!-- Custom Theme files -->

<meta name="keywords"
	content="Mentors Responsive Web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web template, 
			Smartphone Compatible Web template, free Webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola Web design" />

<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Julius+Sans+One'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Candal' rel='stylesheet'
	type='text/css'>
<link href='//fonts.googleapis.com/css?family=Roboto+Slab'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<!--/fonts-->
<!--//end-animate-->
<link href="http://vjs.zencdn.net/5.16.0/video-js.css"
			rel="stylesheet">
		<link
			href="https://cdnjs.cloudflare.com/ajax/libs/videojs-resolution-switcher/0.4.2/videojs-resolution-switcher.css"
			rel="stylesheetF">
								
  		<script src="http://vjs.zencdn.net/5.16.0/video.js"></script>
	    <script
			src="https://cdnjs.cloudflare.com/ajax/libs/videojs-resolution-switcher/0.4.2/videojs-resolution-switcher.js"></script>
		<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
		
		<style>
			.video {
				border: 1px solid black;
			}
			
			.video_wrapper {
				display: table;
				width: auto;
				position: relative;
			}
			
			.playpause {
				background-image: url(../assets/videa/loading2.gif);
				background-repeat: no-repeat;
				width: 50%;
				height: 50%;
				position: absolute;
				left: 0%;
				right: 0%;
				top: 0%;
				bottom: 0%;
				margin: auto;
				background-size: contain;
				background-position: center;
			}
		</style></head>
<!-- head ends -->

<body>
	<!--header-->
	<div class="header">
		<nav class="navbar navbar-inverse">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand"
						href="/qoe/home">Quality of
						Experience</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a
						href="/qoe/home">Home</a>
					</li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Videa <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<!-- <li><a href="/qoe/videa/aspen">aspen</a>
							</li> -->
							<li><a
								href="/qoe/videa/aspenvidea">aspen
									videa</a></li>
							<!-- <li><a
						href="/qoe/videa/controlledBurn">controlled
							burn</a></li> -->
						</ul>
					</li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Info<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a
								href="/qoe/presentation">Presentation</a>
							</li>
							<li><a
								href="/qoe/subjectiveqoe">Subjektivní
									QoE </a>
							</li>
							<li><a
								href="/qoe/objectiveqoe">Objektivní
									QoE </a>
							</li>
							<li><a
								href="/qoe/qoemeasurement">Měření
									subjektivního QoE </a>
							</li>
							<li><a
								href="/qoe/resultcorrelation">Korelace
									výsledků</a>
							</li>
							<li><a href="/qoe/fullthesis">DP
									práce </a>
							</li>
						</ul>
					</li>
					<!-- <li><a href="/qoe/presentation">Presentation</a></li> -->
					<li><a href="/qoe/about">About</a>
					</li>
					<li><a href="/qoe/contact">Contact</a>
					</li>
					<li><a href="/qoe/statistics">Statistics</a>
					</li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="/qoe/logout"><span
							class="glyphicon glyphicon-log-in"> Logout</span> </a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/qoe/userDetail">
							</a>
					</li>
				</ul>
			</div>
		</nav>

	</div>
	<!--//header-->

	<div class="container">
		<!-- page body -->

	
		<div id="video_wrapper">
		  <video id="video" class="video-js vjs-default-skin" controls="true"
				controls class="img img-responsive" preload="auto" poster="${pageContext.request.contextPath}/assets/videa/loading.gif"
				data-setup="{}">
		    <source
				src="${pageContext.request.contextPath}/assets/videa/aspen/aspen_1080p.mp4"
				type='video/mp4' label='1080' />
		    <source
				src="${pageContext.request.contextPath}/assets/videa/aspen/aspen_720p.mp4"
				type='video/mp4' label='720' />
   		    <source
				src="${pageContext.request.contextPath}/assets/videa/aspen/aspen_480p.mp4"
				type='video/mp4' label='480' />
			<source
				src="${pageContext.request.contextPath}/assets/videa/aspen/aspen_360p.mp4"
				type='video/mp4' label='360' "/>
		
			<p class="vjs-no-js">
		      To view this video please enable JavaScript, and consider upgrading to a web browser that
		      <a href="http://videojs.com/html5-video-support/"
					target="_blank">supports HTML5 video</a>
		    </p>
		  </video>
	      <div class="playpause"></div>
		</div>
			
		  <script type="text/javascript">
					var video = document.getElementById('video');
					var isPause = 0;
					var pauseTime = [ "4", "8", "14" ];
					var pausedCurrTime = video.currentTime;
					$(".playpause").fadeOut();

					video.addEventListener('timeupdate', function() {
						//console.log(this.currentTime.toString().split('.')[0]
						//	.trim());
						if ((jQuery.inArray(this.currentTime.toString().split('.')[0].trim(), pauseTime) > -1)) {
							pausedCurrTime = this.currentTime;
							this.pause();
							$(".playpause").fadeIn();
							wait();
						}
					});

					function wait() {
						setTimeout(function() {
							$(".playpause").fadeOut();
							isPause++;
							video.currentTime = pausedCurrTime + 1;
							video.play();
						}, 2000);
					}

					/*
					videojs('video').videoJsResolutionSwitcher();
					var isPause = 0;
					var pausetime = 2; // stop at 2 seconds
					var myPlayer = videojs('video');
					var currTime = myPlayer.currentTime;
					myPlayer.on('timeupdate', function(e) {
					    if( isPause == 0 && ( this.currentTime() >= pausetime ) ){
					    	//this.poster('loading.gif');
					    	//this.posterImage.show();
					    	myPlayer.pause();
					    	currTime = this.currentTime();
					    	myPlayer.addClass("playpause2");
					    	//myPlayer.load();
					        wait();
					    }
					});
					
					function wait(){
					    setTimeout(function(){
					        isPause++;
					        //myPlayer.removeClass("playpause2");
					        myPlayer.play();
					    },3000);
					}
					 */
				</script>
		  <script type="text/javascript">
					var video = document.getElementById('video');
					var isPause = 0;
					var pauseTime = [ "4", "8", "14" ];
					var pausedCurrTime = video.currentTime;
					$(".playpause").fadeOut();

					video.addEventListener('timeupdate', function() {
						//console.log(this.currentTime.toString().split('.')[0]
						//	.trim());
						if ((jQuery.inArray(this.currentTime.toString().split('.')[0].trim(), pauseTime) > -1)) {
							pausedCurrTime = this.currentTime;
							this.pause();
							$(".playpause").fadeIn();
							wait();
						}
					});

					function wait() {
						setTimeout(function() {
							$(".playpause").fadeOut();
							isPause++;
							video.currentTime = pausedCurrTime + 1;
							video.play();
						}, 2000);
					}

					/*
					videojs('video').videoJsResolutionSwitcher();
					var isPause = 0;
					var pausetime = 2; // stop at 2 seconds
					var myPlayer = videojs('video');
					var currTime = myPlayer.currentTime;
					myPlayer.on('timeupdate', function(e) {
					    if( isPause == 0 && ( this.currentTime() >= pausetime ) ){
					    	//this.poster('loading.gif');
					    	//this.posterImage.show();
					    	myPlayer.pause();
					    	currTime = this.currentTime();
					    	myPlayer.addClass("playpause2");
					    	//myPlayer.load();
					        wait();
					    }
					});
					
					function wait(){
					    setTimeout(function(){
					        isPause++;
					        //myPlayer.removeClass("playpause2");
					        myPlayer.play();
					    },3000);
					}
					 */
				</script>
			</div>

	<script type="application/x-javascript">
		 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	</script>
	<!-- //Custom Theme files -->

	<!-- js -->
	<script src="/qoe/assets/bootstrap/js/bootstrap.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/qoe/assets/js/jquery-1.11.1.min.js"></script>
	<!-- <script src="/qoe/assets/bootstrap/js/bootstrap.min.js"></script> -->
	<script src="/qoe/assets/js/jquery.backstretch.min.js"></script>
	<script src="/qoe/assets/js/scripts.js"></script>

</body>
</html>