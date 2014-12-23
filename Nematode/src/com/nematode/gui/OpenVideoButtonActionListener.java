package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import com.nematode.fileIO.AbstractFileChooser;
import com.nematode.model.LoadedVideo;
import com.nematode.model.NullVideo;
import com.nematode.model.VideoInterface;
import com.nematode.model.VideoMatriarchInterface;

public class OpenVideoButtonActionListener implements ActionListener {

	private final AbstractFileChooser fileChooser;
	private final VideoMatriarchInterface videoMatriarch;

	public OpenVideoButtonActionListener(final AbstractFileChooser fileChooser,
			final VideoMatriarchInterface videoMatriarch) {
		this.fileChooser = fileChooser;
		this.videoMatriarch = videoMatriarch;
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

			this.videoMatriarch.setVideo(video);
		}
	}

	public AbstractFileChooser getFileChooser() {
		return this.fileChooser;
	}

	public VideoMatriarchInterface getVideoMatriarch() {
		return this.videoMatriarch;
	}
}
