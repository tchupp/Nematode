package com.nematode.gui;

import javax.swing.JButton;

import com.nematode.fileIO.ImageFileChooser;
import com.nematode.fileIO.OpenImageButtonActionListener;

public class NematodeProjectPanelViewController {

	private final NematodeProjectPanel nematodeProjectPanel;

	public NematodeProjectPanelViewController() {
		this.nematodeProjectPanel = new NematodeProjectPanel();
		addListenerToOpenImageButton();
	}

	private void addListenerToOpenImageButton() {
		final JButton openImageButton = this.nematodeProjectPanel
				.getOpenImageButton();

		final OpenImageButtonActionListener openImageButtonActionListener = new OpenImageButtonActionListener(
				new ImageFileChooser());
		openImageButton.addActionListener(openImageButtonActionListener);
	}

	public NematodeProjectPanel getNematodeProjectPanel() {
		return this.nematodeProjectPanel;
	}

}
