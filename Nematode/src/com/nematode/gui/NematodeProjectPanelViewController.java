package com.nematode.gui;

import javax.swing.JButton;

import com.nematode.fileIO.ImageFileChooser;
import com.nematode.fileIO.OpenImageButtonActionListener;
import com.nematode.imaging.VideoFrameHandlerInterface;

public class NematodeProjectPanelViewController implements
		NematodePanelViewControllerInterface {

	private final NematodeProjectPanel nematodeProjectPanel = new NematodeProjectPanel();
	private final VideoFrameHandlerInterface videoFrameHandler;

	public NematodeProjectPanelViewController(
			final VideoFrameHandlerInterface videoFrameHandler) {
		this.videoFrameHandler = videoFrameHandler;
		addListenerToOpenImageButton();
	}

	private void addListenerToOpenImageButton() {
		final OpenImageButtonActionListener openImageButtonActionListener = new OpenImageButtonActionListener(
				new ImageFileChooser(), this.videoFrameHandler);
		final JButton openImageButton = this.nematodeProjectPanel
				.getOpenImageButton();
		openImageButton.addActionListener(openImageButtonActionListener);
	}

	@Override
	public NematodePanel getNematodePanel() {
		return this.nematodeProjectPanel;
	}

	@Override
	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}

	@Override
	public void updateImage() {
	}

}
