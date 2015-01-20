package com.nematode.gui.main;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;

import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import com.nematode.fileIO.AbstractFileChooser;
import com.nematode.gui.MainWindowControllerInterface;
import com.nematode.model.LoadedVideo;
import com.nematode.model.NullVideo;
import com.nematode.model.VideoInterface;

public class OpenVideoButtonListener implements MainWindowActionListener {

	private final MainWindowControllerInterface viewController;
	private final AbstractFileChooser fileChooser;

	public OpenVideoButtonListener(final MainWindowControllerInterface viewController,
			final AbstractFileChooser fileChooser) {
		this.viewController = viewController;
		this.fileChooser = fileChooser;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final int dialogResult = this.fileChooser.showDialog(null, null);

		if (dialogResult == JFileChooser.APPROVE_OPTION) {
			final File selectedFile = this.fileChooser.getSelectedFile();
			VideoInterface video = new NullVideo();

			if (selectedFile.exists()) {
				final OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber(selectedFile);

				try {
					frameGrabber.start();
					frameGrabber.stop();

					video = new LoadedVideo(frameGrabber);
				} catch (final FrameGrabber.Exception exception) {
				}
			}
			this.viewController.setVideo(video);
		}
	}

	public MainWindowControllerInterface getViewController() {
		return this.viewController;
	}

	public AbstractFileChooser getFileChooser() {
		return this.fileChooser;
	}
}
