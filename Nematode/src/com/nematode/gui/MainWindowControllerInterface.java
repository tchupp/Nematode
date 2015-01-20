package com.nematode.gui;

import com.nematode.model.VideoInterface;

public interface MainWindowControllerInterface {

	public void dispose();

	public void showView();

	public void playButtonPressed();

	public void pauseButtonPressed();

	public void setVideo(VideoInterface video);

}
