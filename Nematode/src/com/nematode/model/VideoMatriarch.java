package com.nematode.model;

public class VideoMatriarch implements VideoMatriarchInterface {

	private VideoInterface video;

	public VideoMatriarch() {
		this.video = new NullVideo();
	}

	@Override
	public VideoInterface getVideo() {
		return this.video;
	}

	@Override
	public void setVideo(final VideoInterface video) {
		this.video = video;
	}

}
