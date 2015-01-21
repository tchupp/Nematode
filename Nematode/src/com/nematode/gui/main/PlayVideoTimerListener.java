package com.nematode.gui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayVideoTimerListener implements ActionListener {

	private final MainWindowControllerInterface viewController;

	public PlayVideoTimerListener(final MainWindowControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		this.viewController.showNextFrame();
	}

	public MainWindowControllerInterface getViewController() {
		return this.viewController;
	}

}
