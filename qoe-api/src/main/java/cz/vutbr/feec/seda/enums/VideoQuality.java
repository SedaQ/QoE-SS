package cz.vutbr.feec.seda.enums;

/**
 * @author Pavel Šeda (441048)
 *
 */
public enum VideoQuality {
	TINY_144("144p"), 
	SMALL_240("240p"), 
	MEDIUM_360("360p"),
	LARGE_480("480p"), 
	HD_720("720p"), 
	HD_1080("1080p");

	private String videoQuality;

	private VideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}

	public String getVideoQuality() {
		return videoQuality;
	}

	public void setVideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}

	public static String getNameByQuality(String quality) {
		for (VideoQuality e : VideoQuality.values()) {
			if (quality == e.videoQuality)
				return e.name();
		}
		return null;
	}
	
	@Override
	public String toString(){
		return videoQuality;
	}

}
