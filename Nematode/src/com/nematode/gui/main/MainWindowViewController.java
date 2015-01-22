package com.nematode.gui.main;

import org.bytedeco.javacpp.opencv_core.Mat;

import com.nematode.fileIO.VideoFileChooser;
import com.nematode.model.VideoInterface;
import com.nematode.model.VideoMatriarchInterface;

public class MainWindowViewController implements MainWindowControllerInterface {

	private final AbstractMainWindow mainWindow;
	private final VideoMatriarchInterface videoMatriarch;

	public MainWindowViewController(final AbstractMainWindow mainWindow,
			final VideoMatriarchInterface videoMatriarch) {
		this.mainWindow = mainWindow;
		this.videoMatriarch = videoMatriarch;

		addListenersToMainWindow();
	}

	private void addListenersToMainWindow() {
		this.mainWindow.addWindowListener(new MainWindowCloseListener(this));
		this.mainWindow.addListenerToPlayButton(new PlayButtonListener(this));
		this.mainWindow.addListenerToPauseButton(new PauseButtonListener(this));
		this.mainWindow.addListenerToOpenVideoButton(new OpenVideoButtonListener(this,
				new VideoFileChooser()));
	}

	@Override
	public void showView() {
		this.mainWindow.setVisible(true);
	}

	@Override
	public void dispose() {
		this.mainWindow.dispose();
	}

	@Override
	public void playButtonPressed() {
		this.videoMatriarch.startVideo();
	}

	@Override
	public void pauseButtonPressed() {
	}

	public void stopButtonPressed() {
		this.videoMatriarch.stopVideo();
	}

	@Override
	public void showNextFrame() {
		final Mat currentFrame = this.videoMatriarch.grabCurrentFrame();
		this.mainWindow.displayImage(currentFrame);
	}

	@Override
	public void setVideo(final VideoInterface video) {
		this.videoMatriarch.setVideo(video);
		this.mainWindow.displayImage(video.getThumbnail());
	}

	public AbstractMainWindow getMainWindow() {
		return this.mainWindow;
	}

	public VideoMatriarchInterface getVideoMatriarch() {
		return this.videoMatriarch;
	}
}
