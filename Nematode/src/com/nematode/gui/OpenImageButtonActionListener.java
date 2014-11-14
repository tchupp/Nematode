package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.nematode.fileIO.AbstractFileChooser;
import com.nematode.fileIO.ValidatedImageFile;
import com.nematode.fileIO.VideoFrameAssemblerInterface;

public class OpenImageButtonActionListener implements ActionListener {

	private final AbstractFileChooser fileChooser;
	private final VideoFrameAssemblerInterface videoFrameAssembler;

	public OpenImageButtonActionListener(final AbstractFileChooser fileChooser,
			final VideoFrameAssemblerInterface videoFrameAssembler) {
		this.fileChooser = fileChooser;
		this.videoFrameAssembler = videoFrameAssembler;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final int dialogResult = this.fileChooser.showDialog(null, null);

		if (dialogResult == JFileChooser.APPROVE_OPTION) {
			final ValidatedImageFile validatedImageFile = new ValidatedImageFile(
					this.fileChooser.getSelectedFile());

			this.videoFrameAssembler.addNewVideoFrame(validatedImageFile, 0);
		}
	}

	public AbstractFileChooser getFileChooser() {
		return this.fileChooser;
	}

	public VideoFrameAssemblerInterface getVideoFrameAssembler() {
		return this.videoFrameAssembler;
	}
}
