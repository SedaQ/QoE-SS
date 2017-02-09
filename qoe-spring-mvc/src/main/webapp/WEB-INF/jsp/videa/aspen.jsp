<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:videopagetemplate title="QoE">
	<jsp:attribute name="body">
	
    <!-- 1. The <iframe> (and video player) will replace this <div> tag. -->
    <div id="player"></div> 
	<!-- <iframe id="player" type="text/html" width="640" height="360"
	  src="http://www.youtube.com/embed/fv7PC4BH4Gc?enablejsapi=1&origin=http://example.com"
	  frameborder="0"></iframe>-->

    <script>
					// 2. This code loads the IFrame Player API code asynchronously.
					var tag = document.createElement('script');

					tag.src = "https://www.youtube.com/iframe_api";
					var firstScriptTag = document
							.getElementsByTagName('script')[0];
					firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

					// 3. This function creates an <iframe> (and YouTube player)
					//    after the API code downloads.
					var player;
					var iframe;
					var timeout = [ 6000, 12000, 18000 ];
					var paused = false;
					function onYouTubeIframeAPIReady() {
						player = new YT.Player('player', {
							//height : screen.height,
							//width : screen.width,
							height : screen.height-(screen.height/9.7),
							width : '100%',
							//height : '400',
							//width : '700',
							videoId : 'fv7PC4BH4Gc',
							//playerVars: { 'autoplay': 1, 'controls': 0 },
							events : {
								'onReady' : onPlayerReady,
								//'onStateChange': onPlayerStateChange,
								//'onPlaybackQualityChange' : onPlayerChangeQuality
								'onStateChange' : onPlayerChangeQuality,
							}
						});
					}

					// 4. The API will call this function when the video player is ready.
					function onPlayerReady(event) {
						iframe = $('#player');
						//try {
						//	if (autoplay)
						event.target.playVideo();
						event.target.setSize(screen.width, screen.heigth);
						//goFullscreen('player');
						//}
						//catch (ex) { }
					}

					function onPlayerChangeQuality(event) {
						if (event.data == YT.PlayerState.PLAYING) {
							//setTimeout(changeQualityToTiny, 3000);
							setTimeout(pauseVideo, 6000);
							setTimeout(playVideo, 11000);
						}
					}

					function changeQualityToTiny() {
						player.setPlaybackQuality('tiny');
					}

					function changeQualityToMedium() {
						player.setPlaybackQuality('medium');
					}

					function changeQualityToHD() {
						//trackEvent(category, 'Buffering', event.target.eventTag);
						player.setPlaybackQuality('hd720');
					}

					// 5. The API calls this function when the player's state changes.
					//    The function indicates that when playing a video (state=1),
					//    the player should play for six seconds and then stop.
					var done = false;
					function onPlayerStateChange(event) {
						if (event.data == YT.PlayerState.PLAYING && !done) {
							done = true;
						}
					}

					function stopVideo() {
						player.stopVideo();
					}

					function pauseVideo() {
						player.pauseVideo();
					}

					function playVideo() {
						player.playVideo();
					}

					function goFullscreen(id) {
						// Get the element that we want to take into fullscreen mode
						var element = document.getElementById(id);

						// These function will not exist in the browsers that don't support fullscreen mode yet,
						// so we'll have to check to see if they're available before calling them.

						if (element.mozRequestFullScreen) {
							// This is how to go into fullscren mode in Firefox
							// Note the "moz" prefix, which is short for Mozilla.
							element.mozRequestFullScreen();
						} else if (element.webkitRequestFullScreen) {
							// This is how to go into fullscreen mode in Chrome and Safari
							// Both of those browsers are based on the Webkit project, hence the same prefix.
							element.webkitRequestFullScreen();
						}
						// Hooray, now we're in fullscreen mode!
					}
				</script>
				
				<style type="text/css">
					.player:-webkit-full-screen {
						width: 100%;
						height: 100%;
					}
					
					.player:-moz-full-screen {
						width: 100%;
						height: 100%;
					}
				</style>

	</jsp:attribute>
</my:videopagetemplate>