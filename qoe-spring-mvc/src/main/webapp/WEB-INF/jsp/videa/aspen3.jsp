<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<my:videopagetemplate title="QoE">
	<jsp:attribute name="body">
			<!-- 
				<video width="320" height="240" controls>
				  <source src="/qoe-spring-mvc/src/main/webapp/assets/videa/aspen/aspen_1080p.mp4" type="video/mp4">
				  <source src="/qoe-spring-mvc/src/main/webapp/assets/videa/aspen/aspen_360p.mp4" type="video/mp4">
				</video>
			 -->
		    <iframe src="https://www.youtube.com/embed/fv7PC4BH4Gc"
			id="iframePlayer"
			style="border: 0; position: absolute; top: 0; left: 0; right: 0; bottom: 0; width: 100%; height: 100%"></iframe>

	
	<!-- 
	<script>
		var map = {
			'fullHD' : '1080p',
			'720p' : '720p',
			'360p' : '360p'
		};

		function changeQ(quality) {
			$('source', 'video#player').attr('src',
					'http://v.com/' + map[quality]);
			$('span#pp').html(map[quality]);
			console.log($('source', 'video#player').attr('src'))
		}

		var map2 = {
			'240p' : '&vq=small',
			'360p' : '&vq=medium',
			'480p' : '&vq=large',
			'720p' : '&vq=hd720'
		};

		function changeQualityIFrame(quality) {
			$('source', 'iframe#iframePlayer').attr('src',
					'http://v.com/' + map[quality]);
			$('span#pp').html(map[quality]);
			console.log($('source', 'iframe#iframePlayer').attr('src'))
		}
	</script>
	 -->
	</jsp:attribute>
</my:videopagetemplate>