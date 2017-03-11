<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
			    <source id="videoSource"
				src="${pageContext.request.contextPath}/assets/videa/${videoSources.get(0)}"
				type='video/mp4' />
				<p>
			      To view this video please enable JavaScript, and consider upgrading to a web browser that
			    </p>
			  </video>
		  </div>
	      <div class="playpause"></div>
      		<form:form id="submitVideoFormToEvaluateMos" method="post"
			action="${pageContext.request.contextPath}/mos/evaluate"
			enctype="multipart/form-data;charset=UTF-8">
			</form:form>
	      <br />
	      
	      <br />
		  <script type="text/javascript">
		  			var pauseTime = [];
		  			var pauseLength = [];
		  			var pauseVideoQuality = [];
		  			var videoSources = [];
		  			var nextIndex = 0;
					<c:forEach items="${videoScenarioParameters}" var="scenarioParameter" varStatus="pauseTimeStatus">
						pauseTime.push(${scenarioParameter.time}*1000);
						pauseLength.push("${scenarioParameter.length}");
						pauseVideoQuality.push("${scenarioParameter.videoQuality}");
					</c:forEach>
					
					<c:forEach items="${videoSources}" var="videoSource">
						videoSources.push("${videoSource}");
					</c:forEach>
					
					var isPause = 0;
					console.log("Časy na jak dlouho se video zastaví: " + pauseTime);
					console.log("Časy, v kterých se video zastaví: " + pauseLength);
					console.log(pauseVideoQuality);
					console.log(videoSources);
					
					var pausedCurrTime = video.currentTime;
					$(".playpause").fadeOut();

					var source = document.getElementById("videoSource");
					
					var wait = function() {
						//$(".playpause").fadeOut();
						isPause++;
						video.src = "/assets/videa/" + "${videoObj.name}" + "_" + pauseVideoQuality[nextIndex]+".mp4";
						video.load();
						//source.
						console.log("Src videa je: " + video.src);
						video.currentTime = pausedCurrTime;
						//source.setAttribute('src', "/assets/videa/" + videoSources[videoSources.length-1]);
						video.play();
						//pauseLength.shift();
						nextIndex = nextIndex + 1;
					};
					
					video.addEventListener('timeupdate', function() {
						if ((jQuery.inArray(this.currentTime.toString().split(
								'.')[0].trim(), pauseLength) > -1)) {
							console.log("Čas, v který se děje něco s videem:" + this.currentTime.toString().split('.')[0].trim());
							console.log("Čas loadingu pro tento případ je:" + pauseTime[nextIndex] + " sekund");
							this.currentTime = this.currentTime + 1;
							pausedCurrTime = this.currentTime;
							this.pause();
							//$(".playpause").fadeIn();
							setTimeout(wait, pauseTime[nextIndex]);
						}
						if(this.ended){
							document.getElementById("submitVideoFormToEvaluateMos").submit();
						}
					});
					
					video.addEventListener('click', function() {
						if (this.paused) {
							this.play();
							toggleFullScreen();
						} else if (this.play) {
							this.pause();
						}
					});
					
					function toggleFullScreen(){
						if(video.requestFullScreen){
							video.requestFullScreen();
						} else if(video.webkitRequestFullScreen){
							video.webkitRequestFullScreen();
						} else if(video.mozRequestFullScreen){
							video.mozRequestFullScreen();
						}
					}

					var $video = $('video'), $window = $(window);

					$(window).resize(function() {
						var height = $window.height() - $window.height() / 15;
						$video.css('height', height);
						var videoWidth = $video.width(), windowWidth = $window.width() - $window.width() / 90;
						$video.css('width', windowWidth);
					}).resize();
				</script>
	</jsp:attribute>
</my:pagetemplate>