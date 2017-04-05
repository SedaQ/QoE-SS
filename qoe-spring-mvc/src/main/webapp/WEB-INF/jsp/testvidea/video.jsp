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
	background: ;
	background-size: cover; 
	border: 1px solid black;
	position: relative;
	display: block;
	z-index: 1;
	visibility: ;
}

/*
.videoToCover {
	border: 1px solid black;
	position: relative;
	display: none;
	z-index:300000;
	visibility: ;
}
*/

.video_wrapper { /*display: table;*/
	
}

.playpause {
	background: url(../assets/videa/loading2.gif) no-repeat;
	/*background-repeat: no-repeat;*/
	position: absolute;
	width: 50%;
	height: 50%;
	left: 0%;
	right: 0%;
	top: 0%;
	bottom: 0%;
	margin: auto;
	background-size: contain;
	background-position: center;
	z-index: 2;
}

</style>
	</jsp:attribute>
	<jsp:attribute name="body">
		<h1 class="page-header">
			Spusťe video a po přehrání video ohodnoťte na stupnici MOS <small></small>
		</h1>


		  <div id="video_wrapper">
			  <video id="video" controls="true" controls
				class="img img-responsive" preload="auto" data-setup="{}">
			    <source id="videoSource"
				src="${pageContext.request.contextPath}/assets/videa/${videoSources.get(0)}"
				type='video/mp4' />
				<p>
			      To view this video please enable JavaScript, and consider upgrading to a web browser that
			    </p>
			  </video>
			  <!-- 
  			  <video id="videoToCover" controls="true" controls
				style="display:none" class="img img-responsive" preload="auto"
				data-setup="{}"
				src="${pageContext.request.contextPath}/assets/videa/${videoSources.get(0)}"
				type='video/mp4'>
				<p>
			      To view this video please enable JavaScript, and consider upgrading to a web browser that
			    </p>
			  </video> -->
			  <div class="playpause"></div>
		 </div>
	      
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
					
					console.log("Časy na jak dlouho se video zastaví: " + pauseTime);
					console.log("Časy, v kterých se video zastaví: " + pauseLength);
					console.log(pauseVideoQuality);
					console.log(videoSources);
					var alreadyStopped = false;
					
					var pausedCurrTime = video.currentTime;
					$(".playpause").fadeOut();
					//$(".playpause").fadeIn();
					
					//var videoToCover = document.getElementById("videoToCover");
					//var video = document.getElementById("video");

					function wait() {
						
						video.play();
						//pauseLength.shift();
						nextIndex = nextIndex + 1;
						$(".playpause").fadeOut();
					};
					
					video.addEventListener('timeupdate', function() {
						//console.log(this.currentTime);
						var currTime = this.currentTime.toString().split('.')[0].trim();
						if ((jQuery.inArray(currTime, pauseLength) > -1)) {
							if(alreadyStopped == false){
								//console.log("Čas, v který se děje něco s videem:" + this.currentTime.toString().split('.')[0].trim());
								//console.log("Čas loadingu pro tento případ je:" + pauseTime[nextIndex] + " sekund");
								pausedCurrTime = this.currentTime;
								this.pause();
								$(".playpause").show();
								
								video.src = "/assets/videa/" + "${videoObj.name}" + "_" + pauseVideoQuality[nextIndex]+".mp4";
								video.load();
								console.log("Src videa je: " + video.src);
								video.currentTime = pausedCurrTime;
								setTimeout(wait, pauseTime[nextIndex]);
								alreadyStopped = true;
							}
						}
						var pausCurrTime = pausedCurrTime.toString().split('.')[0].trim();
						if(currTime != pausCurrTime){
							alreadyStopped = false;
						}
						if(this.ended){
							document.getElementById("submitVideoFormToEvaluateMos").submit();
						}
					});
					
					video.addEventListener('click', function() {
						if (this.paused) {
							this.play();
							//toggleFullScreen();
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