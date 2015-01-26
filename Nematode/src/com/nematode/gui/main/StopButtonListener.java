package com.nematode.gui.main;

import java.awt.event.ActionEvent;

public class StopButtonListener implements MainWindowActionListener {

	private final MainWindowControllerInterface viewController;

	public StopButtonListener(final MainWindowControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		this.viewController.stopButtonPressed();
	}

	public MainWindowControllerInterface getViewController() {
		return this.viewController;
	}
}
