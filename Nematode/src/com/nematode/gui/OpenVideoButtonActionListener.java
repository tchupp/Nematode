package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.nematode.fileIO.AbstractFileChooser;
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
		}
	}

	public AbstractFileChooser getFileChooser() {
		return this.fileChooser;
	}

	public VideoMatriarchInterface getVideoMatriarch() {
		return this.videoMatriarch;
	}
}
