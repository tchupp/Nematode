package com.nematode.fileIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.nematode.imaging.VideoFrameBuilderInterface;

public class OpenImageButtonActionListener implements ActionListener {

	private final AbstractFileChooser fileChooser;
	private final VideoFrameBuilderInterface videoFrameBuilder;

	public OpenImageButtonActionListener(final AbstractFileChooser fileChooser,
			final VideoFrameBuilderInterface videoFrameBuilder) {
		this.fileChooser = fileChooser;
		this.videoFrameBuilder = videoFrameBuilder;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final int dialogResult = this.fileChooser.showDialog(null, null);

		if (dialogResult == JFileChooser.APPROVE_OPTION) {
			final ValidatedImageFile validatedImageFile = new ValidatedImageFile(
					this.fileChooser.getSelectedFile());
			this.videoFrameBuilder.buildNewFrameImageFromFile(validatedImageFile);
		}
	}

	public AbstractFileChooser getFileChooser() {
		return this.fileChooser;
	}

	public VideoFrameBuilderInterface getVideoFrameBuilder() {
		return this.videoFrameBuilder;
	}
}
