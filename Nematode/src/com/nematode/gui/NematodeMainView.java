package com.nematode.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class NematodeMainView extends JFrame {

	private static final long serialVersionUID = 1L;

	public NematodeMainView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		final Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		this.setSize(800, 800);
	}
}