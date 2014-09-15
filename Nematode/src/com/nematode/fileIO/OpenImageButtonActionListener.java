package com.nematode.fileIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.nematode.imaging.VideoFrameHandlerInterface;

public class OpenImageButtonActionListener implements ActionListener {

	private final AbstractFileChooser fileChooser;
	private final VideoFrameHandlerInterface videoFrameHandler;

	public OpenImageButtonActionListener(final AbstractFileChooser fileChooser,
			final VideoFrameHandlerInterface videoFrameHandler) {
		this.fileChooser = fileChooser;
		this.videoFrameHandler = videoFrameHandler;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final int dialogResult = this.fileChooser.showDialog(null, null);

		if (dialogResult == JFileChooser.APPROVE_OPTION) {
			final ValidatedImageFile validatedImageFile = new ValidatedImageFile(
					this.fileChooser.getSelectedFile());
			this.videoFrameHandler
			.buildNewFrameImageFromFile(validatedImageFile);
		}
	}

	public AbstractFileChooser getFileChooser() {
		return this.fileChooser;
	}

	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}
}
