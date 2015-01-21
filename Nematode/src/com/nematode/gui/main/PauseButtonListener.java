package com.nematode.gui.main;

import java.awt.event.ActionEvent;

public class PauseButtonListener implements MainWindowActionListener {

	private final MainWindowControllerInterface viewController;

	public PauseButtonListener(final MainWindowControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		this.viewController.pauseButtonPressed();
	}

	public MainWindowControllerInterface getViewController() {
		return this.viewController;
	}
}
