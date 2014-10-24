package com.nematode.gui;

import java.awt.Container;
import java.awt.GridBagLayout;

public class MainWindow extends ExtendableJFrame {

	public static final int FRAME_WIDTH = 1920;
	public static final int FRAME_HEIGHT = 1080;

	private static final long serialVersionUID = 1L;

	public MainWindow() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		final Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridBagLayout());

		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
}
