package com.nematode.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import com.nematode.image.processing.ImageResizer;
import com.nematode.model.VideoMatriarch;
import com.nematode.model.VideoSetObserver;
import com.nematode.model.factory.FrameImageAssembler;

public class MainWindowViewController implements MainWindowControllerInterface {

	private final ProjectPanelViewControllerInterface projectPanelViewController;
	private final VideoPanelViewControllerInterface videoPanelViewController;
	private final TrackingPanelViewControllerInterface trackingPanelViewController;
	private final ToolbarPanelViewControllerInterface toolbarPanelViewController;
	private final StatusPanelViewControllerInterface statusPanelViewController;
	private final ExtendableJFrame mainWindow;
	private final VideoMatriarch videoMatriarch;

	public MainWindowViewController() {
		this.mainWindow = new MainWindow();

		this.videoMatriarch = new VideoMatriarch();

		this.projectPanelViewController = new ProjectPanelViewController(this.videoMatriarch);
		this.videoPanelViewController = new VideoPanelViewController(new FrameImageAssembler(),
				new ImageResizer());
		this.trackingPanelViewController = new TrackingPanelViewController();
		this.toolbarPanelViewController = new ToolbarPanelViewController();
		this.statusPanelViewController = new StatusPanelViewController();

		addPanelsToFrame();

		final VideoSetObserver videoSetObserver = new VideoSetObserver(
				this.videoPanelViewController);
		this.videoMatriarch.addObserver(videoSetObserver);
	}

	private void addPanelsToFrame() {
		final ExtendableJPanel controlPanel = new ExtendableJPanel();
		controlPanel.setName("controlPanel");
		controlPanel.setLayout(new GridBagLayout());

		addProjectPanel(controlPanel);
		addTrackingPanel(controlPanel);

		final GridBagConstraints controlPanelConstraints = new GridBagConstraints();
		controlPanelConstraints.gridx = 0;
		controlPanelConstraints.gridy = 0;
		controlPanelConstraints.weighty = 1;
		controlPanelConstraints.fill = GridBagConstraints.VERTICAL;
		controlPanelConstraints.anchor = GridBagConstraints.LINE_START;

		this.mainWindow.add(controlPanel, controlPanelConstraints);

		final ExtendableJPanel scanningPanel = new ExtendableJPanel();
		scanningPanel.setName("scanningPanel");
		scanningPanel.setLayout(new GridBagLayout());

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

		this.mainWindow.add(scanningPanel, scanningPanelConstraints);
	}

	private void addProjectPanel(final ExtendableJPanel controlPanel) {

		final GridBagConstraints projectPanelConstraints = new GridBagConstraints();
		projectPanelConstraints.gridx = 0;
		projectPanelConstraints.gridy = 0;
		projectPanelConstraints.weighty = 0.5;
		projectPanelConstraints.fill = GridBagConstraints.BOTH;
		controlPanel
		.add(this.projectPanelViewController.getProjectPanel(), projectPanelConstraints);
	}

	private void addTrackingPanel(final ExtendableJPanel controlPanel) {

		final GridBagConstraints trackingPanelConstraints = new GridBagConstraints();
		trackingPanelConstraints.gridx = 0;
		trackingPanelConstraints.gridy = 1;
		trackingPanelConstraints.weighty = 0.5;
		trackingPanelConstraints.fill = GridBagConstraints.BOTH;
		controlPanel.add(this.trackingPanelViewController.getTrackingPanel(),
				trackingPanelConstraints);
	}

	private void addVideoPanel(final ExtendableJPanel scanningPanel) {

		final GridBagConstraints videoPanelConstraints = new GridBagConstraints();
		videoPanelConstraints.gridx = 1;
		videoPanelConstraints.gridy = 1;
		videoPanelConstraints.gridheight = 4;
		videoPanelConstraints.weightx = 1.0;
		videoPanelConstraints.weighty = 0.1;
		videoPanelConstraints.fill = GridBagConstraints.BOTH;
		scanningPanel.add(this.videoPanelViewController.getVideoPanel(), videoPanelConstraints);
	}

	private void addToolbarPanel(final ExtendableJPanel scanningPanel) {

		final GridBagConstraints toolbarPanelConstraints = new GridBagConstraints();
		toolbarPanelConstraints.gridx = 1;
		toolbarPanelConstraints.gridy = 0;
		toolbarPanelConstraints.weightx = 1.0;
		toolbarPanelConstraints.weighty = 0.1;
		toolbarPanelConstraints.anchor = GridBagConstraints.PAGE_START;
		toolbarPanelConstraints.fill = GridBagConstraints.BOTH;
		scanningPanel.add(this.toolbarPanelViewController.getToolbarPanel(),
				toolbarPanelConstraints);
	}

	private void addStatusPanel(final ExtendableJPanel scanningPanel) {

		final GridBagConstraints statusPanelConstraints = new GridBagConstraints();
		statusPanelConstraints.gridx = 1;
		statusPanelConstraints.gridy = 5;
		statusPanelConstraints.weightx = 1.0;
		statusPanelConstraints.weighty = 0.5;
		statusPanelConstraints.anchor = GridBagConstraints.PAGE_END;
		statusPanelConstraints.fill = GridBagConstraints.BOTH;
		scanningPanel.add(this.statusPanelViewController.getStatusPanel(), statusPanelConstraints);
	}

	@Override
	public ExtendableJFrame getMainWindow() {
		return this.mainWindow;
	}

	public ProjectPanelViewControllerInterface getProjectPanelViewController() {
		return this.projectPanelViewController;
	}

	public TrackingPanelViewControllerInterface getTrackingPanelViewController() {
		return this.trackingPanelViewController;
	}

	public VideoPanelViewControllerInterface getVideoPanelViewController() {
		return this.videoPanelViewController;
	}

	public ToolbarPanelViewControllerInterface getToolbarPanelViewController() {
		return this.toolbarPanelViewController;
	}

	public StatusPanelViewControllerInterface getStatusPanelViewController() {
		return this.statusPanelViewController;
	}

	public VideoMatriarch getVideoMatriarch() {
		return this.videoMatriarch;
	}
}
