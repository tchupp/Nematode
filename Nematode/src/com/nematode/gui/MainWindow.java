package com.nematode.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nematode.image.NullBufferedImage;

public class MainWindow extends ExtendableJFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(GuiConstants.VIDEO_FRAME_WIDTH, GuiConstants.VIDEO_FRAME_HEIGHT);

		addContentPane();
		addPanelsToContentPane();
	}

	private void addContentPane() {
		BufferedImage backgroundImage = new NullBufferedImage();
		try {
			backgroundImage = ImageIO
					.read(new File(GuiConstants.MAIN_WINDOW_BACKGROUND_IMAGE_PATH));
		} catch (final IOException exception) {
		}

		final Container contentPane = new ImagePanel(backgroundImage);
		contentPane.setLayout(new GridBagLayout());
		this.setContentPane(contentPane);
	}

	private void addPanelsToContentPane() {
		final ExtendableJPanel controlPanel = new ExtendableJPanel();
		controlPanel.setName("controlPanel");
		controlPanel.setLayout(new GridBagLayout());
		controlPanel.setOpaque(false);

		addProjectPanel(controlPanel);
		addTrackingPanel(controlPanel);

		final GridBagConstraints controlPanelConstraints = new GridBagConstraints();
		controlPanelConstraints.gridx = 0;
		controlPanelConstraints.gridy = 0;
		controlPanelConstraints.weighty = 1;
		controlPanelConstraints.fill = GridBagConstraints.VERTICAL;
		controlPanelConstraints.anchor = GridBagConstraints.LINE_START;

		this.add(controlPanel, controlPanelConstraints);

		final ExtendableJPanel scanningPanel = new ExtendableJPanel();
		scanningPanel.setName("scanningPanel");
		scanningPanel.setLayout(new GridBagLayout());
		scanningPanel.setOpaque(false);

		addVideoPanel(scanningPanel);
		addToolbarPanel(scanningPanel);
		addStatusPanel(scanningPanel);

		final GridBagConstraints scanningPanelConstraints = new GridBagConstraints();
		scanningPanelConstraints.gridx = 1;
		scanningPanelConstraints.gridy = 0;
		scanningPanelConstraints.weightx = 0.8;
		scanningPanelConstraints.weighty = 1;
		scanningPanelConstraints.fill = GridBagConstraints.BOTH;
		scanningPanelConstraints.anchor = GridBagConstraints.LINE_END;

		this.add(scanningPanel, scanningPanelConstraints);
	}

	private void addProjectPanel(final ExtendableJPanel controlPanel) {
		final GridBagConstraints projectPanelConstraints = new GridBagConstraints();
		projectPanelConstraints.gridx = 0;
		projectPanelConstraints.gridy = 0;
		projectPanelConstraints.weighty = 0.5;
		projectPanelConstraints.fill = GridBagConstraints.BOTH;

		final ExtendableJPanel projectPanel = new ProjectPanel();
		controlPanel.add(projectPanel, projectPanelConstraints);
	}

	private void addTrackingPanel(final ExtendableJPanel controlPanel) {
		final GridBagConstraints trackingPanelConstraints = new GridBagConstraints();
		trackingPanelConstraints.gridx = 0;
		trackingPanelConstraints.gridy = 1;
		trackingPanelConstraints.weighty = 0.5;
		trackingPanelConstraints.fill = GridBagConstraints.BOTH;

		final ExtendableJPanel trackingPanel = new TrackingPanel();
		controlPanel.add(trackingPanel, trackingPanelConstraints);
	}

	private void addVideoPanel(final ExtendableJPanel scanningPanel) {
		final GridBagConstraints videoPanelConstraints = new GridBagConstraints();
		videoPanelConstraints.gridx = 1;
		videoPanelConstraints.gridy = 1;
		videoPanelConstraints.gridheight = 4;
		videoPanelConstraints.weightx = 1.0;
		videoPanelConstraints.weighty = 0.1;
		videoPanelConstraints.fill = GridBagConstraints.BOTH;

		final ExtendableJPanel videoPanel = new VideoPanel();
		scanningPanel.add(videoPanel, videoPanelConstraints);
	}

	private void addToolbarPanel(final ExtendableJPanel scanningPanel) {
		final GridBagConstraints toolbarPanelConstraints = new GridBagConstraints();
		toolbarPanelConstraints.gridx = 1;
		toolbarPanelConstraints.gridy = 0;
		toolbarPanelConstraints.weightx = 1.0;
		toolbarPanelConstraints.weighty = 0.1;
		toolbarPanelConstraints.anchor = GridBagConstraints.PAGE_START;
		toolbarPanelConstraints.fill = GridBagConstraints.BOTH;

		final ExtendableJPanel toolbarPanel = new ToolbarPanel();
		scanningPanel.add(toolbarPanel, toolbarPanelConstraints);
	}

	private void addStatusPanel(final ExtendableJPanel scanningPanel) {
		final GridBagConstraints statusPanelConstraints = new GridBagConstraints();
		statusPanelConstraints.gridx = 1;
		statusPanelConstraints.gridy = 5;
		statusPanelConstraints.weightx = 1.0;
		statusPanelConstraints.weighty = 0.5;
		statusPanelConstraints.anchor = GridBagConstraints.PAGE_END;
		statusPanelConstraints.fill = GridBagConstraints.BOTH;

		final ExtendableJPanel statusPanel = new StatusPanel();
		scanningPanel.add(statusPanel, statusPanelConstraints);
	}
}
