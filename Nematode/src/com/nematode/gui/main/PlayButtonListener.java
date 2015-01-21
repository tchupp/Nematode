package com.nematode.gui.main;

import java.awt.event.ActionEvent;

public class PlayButtonListener implements MainWindowActionListener {

	private final MainWindowControllerInterface viewController;

	public PlayButtonListener(final MainWindowControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		this.viewController.playButtonPressed();
	}

	public MainWindowControllerInterface getViewController() {
		return this.viewController;
	}
}
