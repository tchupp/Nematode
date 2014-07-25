package com.nematode.gui;

import java.awt.Container;

import javax.swing.JFrame;

public class NematodeMainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private VideoContainerPanelInterface videoContainerPanel;
	private Container contentPane;

	public NematodeMainWindow(VideoContainerPanelInterface videoContainerPanel) {
		this.contentPane = this.getContentPane();
		this.videoContainerPanel = videoContainerPanel;

		this.setName("NematodeMainWindow");
		// this.contentPane.add(videoContainerPanel);

		this.setVisible(true);
	}

}
