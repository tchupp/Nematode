package com.nematode.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class NematodeMainView extends JFrame {

	public static final int FRAME_WIDTH = 1920;
	public static final int FRAME_HEIGHT = 1080;

	private static final long serialVersionUID = 1L;

	public NematodeMainView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		final Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
}