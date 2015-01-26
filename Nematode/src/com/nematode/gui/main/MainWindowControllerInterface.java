package com.nematode.gui.main;

import com.nematode.model.VideoInterface;

public interface MainWindowControllerInterface {

	public void dispose();

	public void showView();

	public void playButtonPressed();

	public void pauseButtonPressed();

	public void stopButtonPressed();

	public void setVideo(VideoInterface video);

	public void showNextFrame();
}
