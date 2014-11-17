package com.nematode.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.nematode.fileIO.AbstractFileChooser;

public class OpenVideoButtonActionListener implements ActionListener {

	private final AbstractFileChooser fileChooser;

	public OpenVideoButtonActionListener(final AbstractFileChooser fileChooser) {
		this.fileChooser = fileChooser;
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
}
