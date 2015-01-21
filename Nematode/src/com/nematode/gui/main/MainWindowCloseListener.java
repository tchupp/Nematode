package com.nematode.gui.main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainWindowCloseListener implements WindowListener {

	private final MainWindowControllerInterface viewController;

	public MainWindowCloseListener(final MainWindowControllerInterface viewController) {
		this.viewController = viewController;
	}

	@Override
	public void windowActivated(final WindowEvent arg0) {
	}

	@Override
	public void windowClosed(final WindowEvent arg0) {
	}

	@Override
	public void windowClosing(final WindowEvent e) {
		this.viewController.dispose();
	}

	@Override
	public void windowDeactivated(final WindowEvent e) {
	}

	@Override
	public void windowDeiconified(final WindowEvent e) {
	}

	@Override
	public void windowIconified(final WindowEvent e) {
	}

	@Override
	public void windowOpened(final WindowEvent e) {
	}

	public MainWindowControllerInterface getViewController() {
		return this.viewController;
	}
}
