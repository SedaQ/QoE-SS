<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:videopagetemplate title="QoE">
	<jsp:attribute name="body">
	
    <!-- 1. The <iframe> (and video player) will replace this <div> tag. -->
    <div id="player"></div>

    <script>
      // 2. This code loads the IFrame Player API code asynchronously.
      var tag = document.createElement('script');

      tag.src = "https://www.youtube.com/iframe_api";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

      // 3. This function creates an <iframe> (and YouTube player)
      //    after the API code downloads.
      var player;
      function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
          height: '360',
          width: '640',
          videoId: 'fv7PC4BH4Gc',
          //playerVars: { 'autoplay': 1, 'controls': 0 },
          events: {
            'onReady': onPlayerReady,
            //'onStateChange': onPlayerStateChange,
            //'onPlaybackQualityChange' : onPlayerChangeQuality
            'onStateChange': onPlayerChangeQuality,
          }
        });
      }

      // 4. The API will call this function when the video player is ready.
      function onPlayerReady(event) {
        event.target.playVideo();
      }

      
      function onPlayerChangeQuality(event){
    	
    	if(event.data == YT.PlayerState.PLAYING){
    		setTimeout(changeQualityToMedium, 3000);
    		
    		setTimeout(changeQualityToHD, 6000);
    		
    	}  
      }
      
      function changeQualityToMedium(){
    	  player.setPlaybackQuality('medium');
      }
      
      function changeQualityToHD(){
    	  player.setPlaybackQuality('hd720');
      }
      
      // 5. The API calls this function when the player's state changes.
      //    The function indicates that when playing a video (state=1),
      //    the player should play for six seconds and then stop.
      var done = false;
      function onPlayerStateChange(event) {
        if (event.data == YT.PlayerState.PLAYING && !done) {
          setTimeout(stopVideo, 6000);
          done = true;
        }
      }
      
      function stopVideo() {
        player.stopVideo();
      }
    </script>

	</jsp:attribute>
</my:videopagetemplate>