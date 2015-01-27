package com.nematode.model;

import org.bytedeco.javacpp.opencv_core.Mat;

public interface VideoMatriarchInterface {

	public void setVideo(VideoInterface video);

	public Mat grabCurrentFrame();

	public void startVideo();

	public void stopVideo();

	public boolean isRunning();

}
