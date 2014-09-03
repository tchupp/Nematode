package com.nematode.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class NematodeMainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private final Container contentPane = this.getContentPane();

	public NematodeMainView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.contentPane.setLayout(new BorderLayout());

		final NematodeProjectPanelViewController nematodeProjectPanelViewController = new NematodeProjectPanelViewController();
		final NematodeVideoPanelViewController nematodeVideoPanelViewController = new NematodeVideoPanelViewController();
		final NematodeTrackingPanelViewController nematodeTrackingPanelViewController = new NematodeTrackingPanelViewController();

		this.contentPane.add(
				nematodeProjectPanelViewController.getNematodeProjectPanel(),
				BorderLayout.WEST);
		this.contentPane.add(
				nematodeVideoPanelViewController.getNematodeVideoPanel(),
				BorderLayout.CENTER);
		this.contentPane.add(nematodeTrackingPanelViewController
				.getNematodeTrackingPanel(), BorderLayout.EAST);

		this.setSize(800, 800);
	}
}