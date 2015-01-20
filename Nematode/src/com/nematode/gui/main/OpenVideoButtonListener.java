package com.nematode.gui.main;

import java.awt.event.ActionEvent;

import com.nematode.fileIO.AbstractFileChooser;
import com.nematode.gui.MainWindowControllerInterface;

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
	}

	public MainWindowControllerInterface getViewController() {
		return this.viewController;
	}

	public AbstractFileChooser getFileChooser() {
		return this.fileChooser;
	}
}
