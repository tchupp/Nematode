package com.nematode.gui;

public class NematodeTrackingLauncher {
	public static void main(final String[] args) {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		nematodeMainViewController.getNematodeMainView().setVisible(true);
	}
}