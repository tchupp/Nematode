package com.nematode.gui.main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import org.bytedeco.javacpp.opencv_core.Mat;

import com.nematode.gui.ExtendableJPanel;
import com.nematode.gui.GuiConstants;
import com.nematode.gui.ImagePanel;
import com.nematode.image.NullBufferedImage;

public class MainWindow extends AbstractMainWindow {

	private static final long serialVersionUID = 1L;
	private JButton playButton;
	private JButton pauseButton;
	private JLabel videoLabel;
	private JButton openVideoButton;

	public MainWindow() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(GuiConstants.VIDEO_FRAME_WIDTH, GuiConstants.VIDEO_FRAME_HEIGHT);

		setupPlayButton();
		setupPauseButton();
		setupVideoLabel();
		setupOpenVideoButton();

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

		final ExtendableJPanel projectPanel = new ExtendableJPanel();
		projectPanel.setName("projectPanel");
		projectPanel.setLayout(new GridBagLayout());
		projectPanel.setBackground(GuiConstants.backgroundColor);
		addCompoundBorder(projectPanel);

		final GridBagConstraints openVideoButtonConstraints = new GridBagConstraints();
		openVideoButtonConstraints.gridx = 0;
		openVideoButtonConstraints.gridy = 0;
		openVideoButtonConstraints.weighty = 1.0;
		openVideoButtonConstraints.fill = GridBagConstraints.HORIZONTAL;
		openVideoButtonConstraints.anchor = GridBagConstraints.NORTH;
		openVideoButtonConstraints.insets = new Insets(5, 5, 5, 5);
		projectPanel.add(this.openVideoButton, openVideoButtonConstraints);

		controlPanel.add(projectPanel, projectPanelConstraints);
	}

	private void addTrackingPanel(final ExtendableJPanel controlPanel) {
		final GridBagConstraints trackingPanelConstraints = new GridBagConstraints();
		trackingPanelConstraints.gridx = 0;
		trackingPanelConstraints.gridy = 1;
		trackingPanelConstraints.weighty = 0.5;
		trackingPanelConstraints.fill = GridBagConstraints.BOTH;

		final ExtendableJPanel trackingPanel = new ExtendableJPanel();
		trackingPanel.setName("trackingPanel");
		trackingPanel.setLayout(new GridBagLayout());
		trackingPanel.setBackground(GuiConstants.backgroundColor);
		addCompoundBorder(trackingPanel);

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

		final ExtendableJPanel videoPanel = new ExtendableJPanel();
		videoPanel.setName("videoPanel");
		videoPanel.setLayout(new GridBagLayout());
		videoPanel.setBackground(GuiConstants.backgroundColor);
		addCompoundBorder(videoPanel);

		final GridBagConstraints videoLabelConstraints = new GridBagConstraints();
		videoLabelConstraints.anchor = GridBagConstraints.CENTER;
		videoLabelConstraints.insets = new Insets(1, 1, 1, 1);
		videoPanel.add(this.videoLabel, videoLabelConstraints);

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

		final ExtendableJPanel toolbarPanel = new ExtendableJPanel();
		toolbarPanel.setName("toolbarPanel");
		toolbarPanel.setLayout(new GridBagLayout());
		toolbarPanel.setBackground(GuiConstants.backgroundColor);
		addCompoundBorder(toolbarPanel);

		final GridBagConstraints playButtonConstraints = new GridBagConstraints();
		playButtonConstraints.gridx = 0;
		playButtonConstraints.gridy = 0;
		playButtonConstraints.weightx = 0.0;
		playButtonConstraints.anchor = GridBagConstraints.WEST;
		playButtonConstraints.insets = new Insets(5, 5, 5, 5);
		toolbarPanel.add(this.playButton, playButtonConstraints);

		final GridBagConstraints pauseButtonConstraints = new GridBagConstraints();
		pauseButtonConstraints.gridx = 1;
		pauseButtonConstraints.gridy = 0;
		pauseButtonConstraints.weightx = 1.0;
		pauseButtonConstraints.anchor = GridBagConstraints.WEST;
		pauseButtonConstraints.insets = new Insets(5, 5, 5, 5);
		toolbarPanel.add(this.pauseButton, pauseButtonConstraints);

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

		final ExtendableJPanel statusPanel = new ExtendableJPanel();
		statusPanel.setName("statusPanel");
		statusPanel.setBackground(GuiConstants.backgroundColor);
		addCompoundBorder(statusPanel);

		scanningPanel.add(statusPanel, statusPanelConstraints);
	}

	private void addCompoundBorder(final ExtendableJPanel panel) {
		final Border raisedBevelBorder = BorderFactory.createRaisedBevelBorder();
		final Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
		final CompoundBorder compoundBorder = BorderFactory.createCompoundBorder(raisedBevelBorder,
				loweredBevelBorder);

		panel.setBorder(compoundBorder);
	}

	private void setupPlayButton() {
		this.playButton = new JButton();
		this.playButton.setName("playButton");
		this.playButton.setPreferredSize(new Dimension(20, 20));

		final ImageIcon playButtonImageIcon = new ImageIcon(GuiConstants.PLAY_BUTTON_IMAGE_PATH);
		this.playButton.setIcon(playButtonImageIcon);
	}

	private void setupPauseButton() {
		this.pauseButton = new JButton();
		this.pauseButton.setName("pauseButton");
		this.pauseButton.setPreferredSize(new Dimension(20, 20));

		final ImageIcon pauseButtonImageIcon = new ImageIcon(GuiConstants.PAUSE_BUTTON_IMAGE_PATH);
		this.pauseButton.setIcon(pauseButtonImageIcon);
	}

	private void setupVideoLabel() {
		final ImageIcon defaultImageIcon = new ImageIcon(new BufferedImage(
				GuiConstants.DISPLAY_WIDTH, GuiConstants.DISPLAY_HEIGHT,
				BufferedImage.TYPE_INT_ARGB));

		this.videoLabel = new JLabel(defaultImageIcon);
		this.videoLabel.setName("videoLabel");
		this.videoLabel.setSize(GuiConstants.DISPLAY_WIDTH, GuiConstants.DISPLAY_HEIGHT);
	}

	private void setupOpenVideoButton() {
		this.openVideoButton = new JButton();
		this.openVideoButton.setName("openVideoButton");
		this.openVideoButton.setText("Open Video");
	}

	@Override
	public void addListenerToPlayButton(final MainWindowActionListener listener) {
		this.playButton.addActionListener(listener);
	}

	@Override
	public void addListenerToPauseButton(final MainWindowActionListener listener) {
		this.pauseButton.addActionListener(listener);
	}

	@Override
	public void addListenerToOpenVideoButton(final MainWindowActionListener listener) {
		this.openVideoButton.addActionListener(listener);
	}

	@Override
	public void displayImage(final Mat displayImage) {
		final ImageIcon newImageIcon = new ImageIcon(displayImage.getBufferedImage());
		this.videoLabel.setIcon(newImageIcon);
	}

	public JButton getPlayButton() {
		return this.playButton;
	}

	public JButton getPauseButton() {
		return this.pauseButton;
	}

	public JLabel getVideoLabel() {
		return this.videoLabel;
	}

	public JButton getOpenVideoButton() {
		return this.openVideoButton;
	}

}
