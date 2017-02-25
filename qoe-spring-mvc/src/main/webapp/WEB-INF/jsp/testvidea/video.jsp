<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:pagetemplate title="QoE">
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
			.video_wrapper { /*display: table;*/
				
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
		<h1 class="page-header">
			Spusťe video a po přehrání video ohodnoťte na stupnici MOS <small></small>
		</h1>

		<div id="video_wrapper">
			  <video id="video" controls="true" controls
				class="img img-responsive" preload="auto"
				poster="${pageContext.request.contextPath}/assets/videa/loading.gif"
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
		  </div>
	      <div class="playpause"></div>
      		<form:form id="submitVideoFormToEvaluateMos" method="post"
				action="${pageContext.request.contextPath}/mos/evaluate" enctype="multipart/form-data;charset=UTF-8">
			</form:form>
	      <br/>
	      
	      <br/>
		  <script type="text/javascript">
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
						if(this.ended){
							document.getElementById("submitVideoFormToEvaluateMos").submit();
						};
					});
					video.addEventListener('click', function() {
						if (this.paused) {
							this.play();
						} else if (this.play) {
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

					var $video = $('video'), $window = $(window);

					$(window)
							.resize(
									function() {
										var height = $window.height()
												- $window.height() / 15;
										$video.css('height', height);

										var videoWidth = $video.width(), windowWidth = $window
												.width()
												- $window.width() / 90;
										$video.css('width', windowWidth);
									}).resize();
				</script>
	</jsp:attribute>
</my:pagetemplate>