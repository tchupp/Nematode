package com.nematode.gui;

import javax.swing.JButton;

import com.nematode.fileIO.ImageFileChooser;
import com.nematode.model.VideoFrameHandlerInterface;

public class ProjectPanelViewController implements ProjectPanelViewControllerInterface {

	private final ProjectPanel projectPanel = new ProjectPanel();
	private final VideoFrameHandlerInterface videoFrameHandler;

	public ProjectPanelViewController(final VideoFrameHandlerInterface videoFrameHandler) {
		this.videoFrameHandler = videoFrameHandler;
		addListenerToOpenImageButton();
	}

	private void addListenerToOpenImageButton() {
		final OpenImageButtonActionListener openImageButtonActionListener = new OpenImageButtonActionListener(
				new ImageFileChooser(), this.videoFrameHandler);
		final JButton openImageButton = this.projectPanel.getOpenImageButton();
		openImageButton.addActionListener(openImageButtonActionListener);
	}

	@Override
	public ExtendableJPanel getProjectPanel() {
		return this.projectPanel;
	}

	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}
}
