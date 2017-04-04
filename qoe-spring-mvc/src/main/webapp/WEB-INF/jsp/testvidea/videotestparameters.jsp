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

#styled_video_container1 {
	width: 85%;
	height: 85%;
	display: block;
}

#styled_video_container2 {
	width: 85%;
	height: 85%;
	display: none;
}

#styled_video_container3 {
	width: 85%;
	height: 85%;
	display: none;
}

#styled_video_container4 {
	width: 85%;
	height: 85%;
	display: none;
}
</style>
	</jsp:attribute>
	<jsp:attribute name="body">
		<h1 class="page-header">
			Spusťe video a po přehrání video ohodnoťte na stupnici MOS <small></small>
		</h1>

		<c:forEach items="${videoSources}" var="videoSource" varStatus="loop">
			<div id='styled_video_container${loop.count}'>
				<video id='video${loop.count}' controls="true" controls
					class="img img-responsive" preload="auto"
					src="${pageContext.request.contextPath}/assets/videa/${videoSource}">
			  	</video>
			</div>
		</c:forEach>
	      <div class="playpause"></div>
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
				console.log("Video kvality: " + pauseVideoQuality);
				console.log(videoSources);
				
				$(".playpause").fadeOut();
	
				var video_1 = document.getElementById("video1");
				var video_2 = document.getElementById("video2");
				var video_3 = document.getElementById("video3");
				var video_4 = document.getElementById("video4");
				
				//$( document ).ready(function() {
				//	toggleFullScreen(video_2);
				//	toggleFullScreen(video_3);
				//	toggleFullScreen(video_4);
				//});
				
				//console.log("idkca videii: " + video_1.id);
				//console.log("idkca videii: " + video_2.id);
				//console.log("idkca videii: " + video_3.id);
				//console.log("idkca videii: " + video_4.id);
				
				//video_1.addEventListener('click', function() {
				//	if (this.paused) {
				//		this.play();
				//	} else if(this.play){
				//		this.pause();
				//	}
				//});
				
				var videos = document.querySelectorAll('video');
				for(var i=0;i<videos.length;i++){
					var v = videos[i];
					v.addEventListener('click', function() {
						if (this.paused) {
							this.play();
						} else if (this.play) {
							this.pause();
						}
					});
					
					v.addEventListener('timeupdate', function() {
						if ((jQuery.inArray(this.currentTime.toString().split(
								'.')[0].trim(), pauseLength) > -1)) {
							console.log("Čas, v který se děje něco s videem:" + this.currentTime.toString().split('.')[0].trim());
							console.log("Čas loadingu pro tento případ je:" + pauseTime[nextIndex] + " sekund");
							this.currentTime = this.currentTime + 1;
							pausedCurrTime = this.currentTime;
							$(".playpause").fadeIn();
							
							console.log("Video ID je: " + this.id);
							
							pauseAllVideos();
							removeAllVideos();
							
							console.log("Video by mělo být pausnuté i odstraněné");
							
							//testVideoView();
							updateVideoQualioty(this.currentTime);
							testVideoView();
							testVideoPaused();

							console.log("Chci prepnout na kvalitu: " + pauseVideoQuality[nextIndex]);
							console.log(this.src);
							nextIndex = nextIndex+1;
							console.log("");
							console.log("");
						}
						if(this.ended){
							document.getElementById("submitVideoFormToEvaluateMos").submit();
						}
					});
				}
				
				function updateVideoQualioty(currentTime){
					if(pauseVideoQuality[nextIndex]=="1080p"){
						$('#styled_video_container1').css("display","block");
						video_1.currentTime = currentTime;
						setTimeout(wait(video_1), pauseTime[nextIndex]);
						if(video_1.paused){
							video_1.play();
						}
					} else if(pauseVideoQuality[nextIndex]=="720p"){
						$('#styled_video_container2').css("display","block");
						video_2.currentTime = currentTime;
						setTimeout(wait(video_2), pauseTime[nextIndex]);
						if(video_2.paused){
							video_2.play();
						}
					} else if(pauseVideoQuality[nextIndex]=="480p"){
						$('#styled_video_container3').css("display","block");
						video_3.currentTime = currentTime;
						setTimeout(wait(video_3), pauseTime[nextIndex]);
						if(video_3.paused){
							video_3.play();
						}
					} else if(pauseVideoQuality[nextIndex]=="360p"){
						$('#styled_video_container4').css("display","block");
						video_4.currentTime = currentTime;
						setTimeout(wait(video_4), pauseTime[nextIndex]);
						if(video_4.paused){
							video_4.play();
						}
					}
				}
				
				function pauseAllVideos(){
					if(!video_1.paused){
						video_1.pause();
					} else if(!video_2.paused){
						video_2.pause();
					} else if(!video_3.paused){
						video_3.pause();
					} else if(!video_4.paused){
						video_4.pause();
					}
				}
				
				function removeAllVideos(){
					$('#styled_video_container1').css("display","none");
					$('#styled_video_container2').css("display","none");
					$('#styled_video_container3').css("display","none");
					$('#styled_video_container4').css("display","none");
				}
				
				function testVideoPaused(){
					if(video_1.paused){
						console.log("video1 je pausnute");
					} else{
						console.log("video1 hraje");
					}
					if(video_2.paused){
						console.log("video2 je pausnute");
					} else{
						console.log("video2 hraje");
					}
					if(video_3.paused){
						console.log("video3 je pausnute");
					} else{
						console.log("video3 hraje");
					}
					if(video_4.paused){
						console.log("video4 je pausnute");
					} else{
						console.log("video4 hraje");
					}
				}
				
				function testVideoView(){
					console.log("video1 zobrazeni: "+$('#styled_video_container1').css("display"));
					console.log("video2 zobrazeni: "+$('#styled_video_container2').css("display"));
					console.log("video3 zobrazeni: "+$('#styled_video_container3').css("display"));
					console.log("video4 zobrazeni: "+$('#styled_video_container4').css("display"));
				}
				
				function wait(videoToPause) {
					//pauseAllVideos();
					if(!videoToPause.paused){
						videoToPause.pause();
					}
					$(".playpause").fadeOut();
				};
				
				function toggleFullScreen(videoToFullScreen){
					if(videoToFullScreen.requestFullScreen){
						videoToFullScreen.requestFullScreen();
					} else if(videoToFullScreen.webkitRequestFullScreen){
						videoToFullScreen.webkitRequestFullScreen();
					} else if(videoToFullScreen.mozRequestFullScreen){
						videoToFullScreen.mozRequestFullScreen();
					}
				}
			</script>
	</jsp:attribute>
</my:pagetemplate>