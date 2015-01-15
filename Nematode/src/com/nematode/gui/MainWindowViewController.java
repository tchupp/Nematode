package com.nematode.gui;

import com.nematode.image.processing.ImageResizer;
import com.nematode.model.VideoMatriarchInterface;
import com.nematode.model.VideoObserverInterface;
import com.nematode.model.VideoSetObserver;

public class MainWindowViewController implements MainWindowControllerInterface {

	private final ProjectPanelViewControllerInterface projectPanelViewController;
	private final VideoPanelViewControllerInterface videoPanelViewController;
	private final TrackingPanelViewControllerInterface trackingPanelViewController;
	private final ToolbarPanelViewControllerInterface toolbarPanelViewController;
	private final StatusPanelViewControllerInterface statusPanelViewController;
	private final ExtendableJFrame mainWindow;
	private final VideoMatriarchInterface videoMatriarch;
	private final VideoObserverInterface videoSetObserver;
	private final ToolbarObserverInterface playButtonObserver;

	public MainWindowViewController(final ExtendableJFrame mainWindow,
			final VideoMatriarchInterface videoMatriarch) {
		this.mainWindow = mainWindow;
		this.mainWindow.addWindowListener(new MainWindowCloseListener(this));

		this.videoMatriarch = videoMatriarch;

		this.projectPanelViewController = new ProjectPanelViewController(this.videoMatriarch);
		this.videoPanelViewController = new VideoPanelViewController(new ImageResizer());
		this.trackingPanelViewController = new TrackingPanelViewController();
		this.toolbarPanelViewController = new ToolbarPanelViewController();
		this.statusPanelViewController = new StatusPanelViewController();

		this.videoSetObserver = new VideoSetObserver(this.videoPanelViewController);
		this.videoMatriarch.addObserver(this.videoSetObserver);

		this.playButtonObserver = new PlayButtonObserver();
		this.toolbarPanelViewController.addObserver(this.playButtonObserver);
	}

	@Override
	public void showView() {
		this.mainWindow.setVisible(true);
	}

	@Override
	public void dispose() {
		this.videoMatriarch.removeObserver(this.videoSetObserver);
		this.toolbarPanelViewController.removeObserver(this.playButtonObserver);
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

	public VideoMatriarchInterface getVideoMatriarch() {
		return this.videoMatriarch;
	}

	public VideoObserverInterface getVideoSetObserver() {
		return this.videoSetObserver;
	}

	public ToolbarObserverInterface getPlayButtonObserver() {
		return this.playButtonObserver;
	}

	public ExtendableJFrame getMainWindow() {
		return this.mainWindow;
	}
}
