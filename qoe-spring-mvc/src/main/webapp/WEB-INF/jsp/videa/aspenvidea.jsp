<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:videopagetemplate title="QoE">
	<jsp:attribute name="head">
		<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
		
		<style>
			.video {
				border: 1px solid black;
				position: relative;
				/*object-fit: fill
			    min-width: 85%;
			    min-height: 85%;
			    width: 85%;
			    height: 85%;
				z-index: -100;*/
			}
			
			.video_wrapper {
				/*display: table;*/
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
		</style>
	</jsp:attribute>

	<jsp:attribute name="body">
	
		<div id="video_wrapper">
		  <video id="video" controls="true"
				controls class="img img-responsive" preload="auto"	poster="${pageContext.request.contextPath}/assets/videa/loading.gif"
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
			<p>
		      To view this video please enable JavaScript, and consider upgrading to a web browser that
		    </p>
		  </video>
	      <div class="playpause"></div>
		</div>
			
		  <script type="text/javascript">
					var video = document.getElementById('video');
					if (video.requestFullscreen) {
						video.requestFullscreen();
						console.log("video.requestFullscreen");
					} else if (video.mozRequestFullScreen) {
						video.mozRequestFullScreen();
						console.log("video.mozRequestFullScreen");
					} else if (video.webkitRequestFullscreen) {
						video.webkitRequestFullscreen();
						console.log("vid.webkitRequestFullscreen");
					}

					var isPause = 0;
					var pauseTime = [ "4", "8", "14" ];
					var pausedCurrTime = video.currentTime;
					$(".playpause").fadeOut();

					video.addEventListener('timeupdate', function() {
						//console.log(this.currentTime.toString().split('.')[0]
						//	.trim());
						if ((jQuery.inArray(this.currentTime.toString().split(
								'.')[0].trim(), pauseTime) > -1)) {
							pausedCurrTime = this.currentTime;
							this.pause();
							$(".playpause").fadeIn();
							wait();
						}
					});
					video.addEventListener('click', function(){
						if(this.paused){
							this.play();
						} else if(this.play){
							this.pause();
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
					
					var $video  = $('video'),
				    $window = $(window); 

					$(window).resize(function(){
					    var height = $window.height()-$window.height()/15;
					    $video.css('height', height);
	
					    var videoWidth = $video.width(),
					        windowWidth = $window.width()-$window.width()/90;
					    $video.css('width', windowWidth);
					    
					    /*
				        marginLeftAdjust =  (windowWidth - videoWidth) / 2;
					    marginLeftAdjust = videoWidth;
	
					    $video.css({
					        'height': height-height/55, 
					        'marginLeft' : marginLeftAdjust
					    });*/
					}).resize();


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
	</jsp:attribute>
</my:videopagetemplate>