package com.nematode.gui.main;

import javax.swing.Timer;

import org.bytedeco.javacpp.opencv_core.Mat;

import com.nematode.fileIO.VideoFileChooser;
import com.nematode.model.VideoInterface;
import com.nematode.model.VideoMatriarchInterface;

public class MainWindowViewController implements MainWindowControllerInterface {

	private final AbstractMainWindow mainWindow;
	private final VideoMatriarchInterface videoMatriarch;
	private final Timer playVideoTimer;

	public MainWindowViewController(final AbstractMainWindow mainWindow,
			final VideoMatriarchInterface videoMatriarch) {
		this.mainWindow = mainWindow;
		this.videoMatriarch = videoMatriarch;

		this.playVideoTimer = new PlayVideoTimer(1000, new PlayVideoTimerListener(this));

		addListenersToMainWindow();
	}

	private void addListenersToMainWindow() {
		this.mainWindow.addWindowListener(new MainWindowCloseListener(this));
		this.mainWindow.addListenerToPlayButton(new PlayButtonListener(this));
		this.mainWindow.addListenerToPauseButton(new PauseButtonListener(this));
		this.mainWindow.addListenerToStopButton(new StopButtonListener(this));
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
		this.playVideoTimer.stop();
	}

	@Override
	public void playButtonPressed() {
		if (!this.videoMatriarch.isRunning()) {
			this.videoMatriarch.startVideo();
		}
		this.playVideoTimer.start();
	}

	@Override
	public void pauseButtonPressed() {
		this.playVideoTimer.stop();
	}

	@Override
	public void stopButtonPressed() {
		this.playVideoTimer.stop();
		this.videoMatriarch.stopVideo();
	}

	@Override
	public void showNextFrame() {
		if (!this.videoMatriarch.isRunning()) {
			stopButtonPressed();
			return;
		}

		final Mat currentFrame = this.videoMatriarch.grabCurrentFrame();
		this.mainWindow.displayImage(currentFrame);
	}

	@Override
	public void setVideo(final VideoInterface video) {
		this.videoMatriarch.setVideo(video);
		this.mainWindow.displayImage(video.getThumbnail());

		final int newDelay = (int) (1000 / video.getFrameRate());
		this.playVideoTimer.setDelay(newDelay);
	}

	public AbstractMainWindow getMainWindow() {
		return this.mainWindow;
	}

	public VideoMatriarchInterface getVideoMatriarch() {
		return this.videoMatriarch;
	}

	public Timer getPlayVideoTimer() {
		return this.playVideoTimer;
	}
}
