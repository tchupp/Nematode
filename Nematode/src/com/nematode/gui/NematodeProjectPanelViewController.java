package com.nematode.gui;

import javax.swing.JButton;

import com.nematode.fileIO.ImageFileChooser;
import com.nematode.fileIO.OpenImageButtonActionListener;
import com.nematode.imaging.VideoFrameBuilderInterface;

public class NematodeProjectPanelViewController implements
		NematodePanelViewControllerInterface {

	private final NematodeProjectPanel nematodeProjectPanel = new NematodeProjectPanel();
	private final VideoFrameBuilderInterface videoFrameBuilder;

	public NematodeProjectPanelViewController(
			final VideoFrameBuilderInterface videoFrameBuilder) {
		this.videoFrameBuilder = videoFrameBuilder;
		addListenerToOpenImageButton();
	}

	private void addListenerToOpenImageButton() {
		final OpenImageButtonActionListener openImageButtonActionListener = new OpenImageButtonActionListener(
				new ImageFileChooser(), this.videoFrameBuilder);
		final JButton openImageButton = this.nematodeProjectPanel
				.getOpenImageButton();
		openImageButton.addActionListener(openImageButtonActionListener);
	}

	@Override
	public NematodePanel getNematodePanel() {
		return this.nematodeProjectPanel;
	}

	public VideoFrameBuilderInterface getVideoFrameBuilder() {
		return this.videoFrameBuilder;
	}

}
