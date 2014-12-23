package com.nematode.model;

public interface VideoMatriarchInterface {

	public VideoInterface getVideo();

	public void setVideo(VideoInterface video);

	public void addObserver(VideoObserverInterface observer);

	public void removeObserver(VideoObserverInterface observer);

}
