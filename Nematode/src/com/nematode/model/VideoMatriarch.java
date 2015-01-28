package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public class VideoMatriarch implements VideoMatriarchInterface {

	private VideoInterface video;
	private boolean isRunning;
	private int currentFrameNumber;

	public VideoMatriarch() {
		this.video = new NullVideo();
		this.currentFrameNumber = 1;
	}

	@Override
	public void setVideo(final VideoInterface video) {
		this.video = video;
	}

	public VideoInterface getVideo() {
		return this.video;
	}

	@Override
	public Mat grabCurrentFrame() {
		this.currentFrameNumber++;
		if (this.currentFrameNumber == this.video.getFrameLength() - 1) {
			this.isRunning = false;
		}
		return this.video.grab();
	}

	@Override
	public void startVideo() {
		this.video.start();
		this.isRunning = true;
		this.currentFrameNumber = 1;
	}

	@Override
	public void stopVideo() {
		this.video.stop();
		this.isRunning = false;
		this.currentFrameNumber = 1;
	}

	@Override
	public boolean isRunning() {
		return this.isRunning;
	}

	public int getCurrentFrameNumber() {
		return this.currentFrameNumber;
	}
}
