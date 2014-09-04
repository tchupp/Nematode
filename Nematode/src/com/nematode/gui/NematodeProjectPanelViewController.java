package com.nematode.gui;

import javax.swing.JButton;

import com.nematode.fileIO.ImageFileChooser;
import com.nematode.fileIO.OpenImageButtonActionListener;

public class NematodeProjectPanelViewController implements
NematodePanelViewControllerInterface {

	private final NematodeProjectPanel nematodeProjectPanel = new NematodeProjectPanel();

	public NematodeProjectPanelViewController() {
		addListenerToOpenImageButton();
	}

	private void addListenerToOpenImageButton() {
		final OpenImageButtonActionListener openImageButtonActionListener = new OpenImageButtonActionListener(
				new ImageFileChooser());
		final JButton openImageButton = this.nematodeProjectPanel
				.getOpenImageButton();
		openImageButton.addActionListener(openImageButtonActionListener);
	}

	@Override
	public NematodePanel getNematodePanel() {
		return this.nematodeProjectPanel;
	}

}
