package com.nematode.gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.nematode.fileIO.ImageFileChooser;
import com.nematode.model.VideoInfoMatriarchInterface;

public class ProjectPanelViewController implements ProjectPanelViewControllerInterface {

	private final ProjectPanel projectPanel;
	private final VideoInfoMatriarchInterface videoInfoMatriarch;

	public ProjectPanelViewController(final VideoInfoMatriarchInterface videoInfoMatriarch) {
		this.videoInfoMatriarch = videoInfoMatriarch;
		this.projectPanel = new ProjectPanel();

		addListenerToOpenImageButton();
	}

	private void addListenerToOpenImageButton() {
		final ActionListener openImageButtonActionListener = new OpenImageButtonActionListener(
				new ImageFileChooser(), this.videoInfoMatriarch.getVideoFrameAssembler());

		final JButton openImageButton = this.projectPanel.getOpenImageButton();
		openImageButton.addActionListener(openImageButtonActionListener);
	}

	@Override
	public ExtendableJPanel getProjectPanel() {
		return this.projectPanel;
	}

	public VideoInfoMatriarchInterface getVideoInfoMatriarch() {
		return this.videoInfoMatriarch;
	}

}
