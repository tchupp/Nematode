package com.nematode.gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.nematode.fileIO.ImageFileChooser;
import com.nematode.fileIO.VideoFileChooser;
import com.nematode.model.VideoMatriarchInterface;

public class ProjectPanelViewController implements ProjectPanelViewControllerInterface {

	private final ProjectPanel projectPanel;
	private final VideoMatriarchInterface videoMatriarch;

	public ProjectPanelViewController(final VideoMatriarchInterface videoMatriarch) {
		this.videoMatriarch = videoMatriarch;
		this.projectPanel = new ProjectPanel();

		addListenerToOpenImageButton();
		addListenerToOpenVideoButton();
	}

	private void addListenerToOpenVideoButton() {
		final OpenVideoButtonActionListener openVideoButtonActionListener = new OpenVideoButtonActionListener(
				new VideoFileChooser(), this.videoMatriarch);

		final JButton openVideoButton = this.projectPanel.getOpenVideoButton();
		openVideoButton.addActionListener(openVideoButtonActionListener);
	}

	private void addListenerToOpenImageButton() {
		final ActionListener openImageButtonActionListener = new OpenImageButtonActionListener(
				new ImageFileChooser());

		final JButton openImageButton = this.projectPanel.getOpenImageButton();
		openImageButton.addActionListener(openImageButtonActionListener);
	}

	@Override
	public ExtendableJPanel getProjectPanel() {
		return this.projectPanel;
	}

	public VideoMatriarchInterface getVideoMatriarch() {
		return this.videoMatriarch;
	}
}
