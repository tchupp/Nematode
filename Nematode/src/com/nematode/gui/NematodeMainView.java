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

		this.contentPane.add(new NematodeProjectPanel(), BorderLayout.WEST);
		this.contentPane.add(new NematodeVideoPanel(), BorderLayout.CENTER);
		this.contentPane.add(new NematodeTrackingPanel(), BorderLayout.EAST);

		this.setSize(800, 800);
	}

}