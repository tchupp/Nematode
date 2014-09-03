package com.nematode.fileIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenImageButtonActionListener implements ActionListener {

	private final AbstractFileChooser fileChooser;

	public OpenImageButtonActionListener(final AbstractFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		this.fileChooser.showDialog(null, null);
	}

	public AbstractFileChooser getFileChooser() {
		return this.fileChooser;
	}

}
