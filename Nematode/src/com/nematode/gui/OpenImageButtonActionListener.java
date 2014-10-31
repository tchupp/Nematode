package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.nematode.fileIO.AbstractFileChooser;
import com.nematode.fileIO.ValidatedImageFile;
import com.nematode.model.VideoFrameHandlerInterface;

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
			this.videoFrameHandler.buildNewFrameImageFromFile(validatedImageFile);
		}
	}

	public AbstractFileChooser getFileChooser() {
		return this.fileChooser;
	}

	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}
}
