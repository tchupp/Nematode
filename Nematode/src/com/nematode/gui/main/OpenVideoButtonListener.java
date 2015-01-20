package com.nematode.gui.main;

import java.awt.event.ActionEvent;

import com.nematode.gui.MainWindowControllerInterface;

public class OpenVideoButtonListener implements MainWindowActionListener {

	private final MainWindowControllerInterface viewController;

	public OpenVideoButtonListener(final MainWindowControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
	}

	public MainWindowControllerInterface getViewController() {
		return this.viewController;
	}
}
