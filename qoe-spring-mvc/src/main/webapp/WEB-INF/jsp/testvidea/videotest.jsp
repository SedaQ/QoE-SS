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
				background-position: center
			}
			
			#styled_video_container1{
				width: 50%;
				height: 50%;
			}
			#styled_video_container2{
				width: 50%;
				height: 50%;
				display:none;
			}
			#styled_video_container3{
				width: 50%;
				height: 50%;
				display:none;
			}
			#styled_video_container4{
				width: 50%;
				height: 50%;
				display:none;
			}
		}
		</style>
	</jsp:attribute>
	<jsp:attribute name="body">
		<h1 class="page-header">
			Spusťe video a po přehrání video ohodnoťte na stupnici MOS <small></small>
		</h1>
			<div id="styled_video_container1">
				<video id="video1"  src="${pageContext.request.contextPath}/assets/videa/aspen_1080p.mp4" autoplay controls="true" controls
					class="img img-responsive" preload="auto"></video>
			</div>
			<div id="styled_video_container2">
				<video id="video2"  src="${pageContext.request.contextPath}/assets/videa/controlled_burn_1080p.mp4" controls="true" controls
					class="img img-responsive" preload="auto"></video>
			</div>
			<div id="styled_video_container3">
				<video id="video3"  src="${pageContext.request.contextPath}/assets/videa/dinner_1080p.mp4" controls="true" controls
					class="img img-responsive" preload="auto" ></video>
			</div>
			<div id="styled_video_container4">
				<video id="video4"  src="${pageContext.request.contextPath}/assets/videa/aspen_360.mp4" controls="true" controls
					class="img img-responsive" preload="auto"></video>
			</div>
		
		<video id="preload" style="display:none;" /> 
		
		<div id="1080p" class="quality">1080p</div> 
        <!-- <div class="playpause"></div> -->
	      
	      <br />
	      <br />
		  <script type="text/javascript">
			  //$('#styled_video_container1').fadeIn();
			  //$('#styled_video_container2').fadeOut();
			  //$('#styled_video_container3').fadeOut();
			  //$('#styled_video_container4').fadeOut();
		  
			  
		  	video1.addEventListener('click', function() {
				if (this.paused) {
					video2.currentTime = this.currentTime;
					video2.play();
					$('#styled_video_container1').css("display","none");
					$('#styled_video_container2').css("display","block");
					toggleFullScreen();
				} else if (this.play) {
					this.pause();
				}
			});
		  	
		  	video2.addEventListener('click', function() {
				if (this.paused) {
					video3.currentTime = this.currentTime;
					video3.play();
					$('#styled_video_container2').css("display","none");
					$('#styled_video_container3').css("display","block");
					toggleFullScreen();
				} else if (this.play) {
					this.pause();
				}
			});
		  	
		  	video3.addEventListener('click', function() {
				if (this.paused) {
					video4.currentTime = this.currentTime;
					video4.play();
					$('#styled_video_container3').css("display","none");
					$('#styled_video_container4').css("display","block");
					toggleFullScreen();
				} else if (this.play) {
					this.pause();
				}
			});
		  	
		  	video4.addEventListener('click', function() {
				if (this.paused) {
					video1.currentTime = this.currentTime;
					video1.play();
					$('#styled_video_container4').css("display","none");
					$('#styled_video_container1').css("display","block");
					toggleFullScreen();
				} else if (this.play) {
					this.pause();
				}
			});
		  </script>
	</jsp:attribute>
</my:pagetemplate>