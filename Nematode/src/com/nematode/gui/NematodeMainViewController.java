package com.nematode.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import com.nematode.imaging.VideoFrameBuilder;
import com.nematode.imaging.VideoFrameBuilderInterface;
import com.nematode.model.NematodeVideoFrame;

public class NematodeMainViewController {

	private final NematodeMainView nematodeMainView;
	private final NematodePanelViewControllerInterface nematodeProjectPanelViewController;
	private final NematodePanelViewControllerInterface nematodeVideoPanelViewController;
	private final NematodePanelViewControllerInterface nematodeTrackingPanelViewController;
	private final VideoFrameBuilder videoFrameBuilder;

	public NematodeMainViewController() {
		this.nematodeMainView = new NematodeMainView();

		final NematodeVideoFrame nematodeVideoFrame = new NematodeVideoFrame();
		this.videoFrameBuilder = new VideoFrameBuilder(nematodeVideoFrame);

		this.nematodeProjectPanelViewController = new NematodeProjectPanelViewController(
				this.videoFrameBuilder);
		this.nematodeVideoPanelViewController = new NematodeVideoPanelViewController(
				nematodeVideoFrame);
		this.nematodeTrackingPanelViewController = new NematodeTrackingPanelViewController();
		addPanelsToFrame();
	}

	private void addPanelsToFrame() {
		final Container contentPane = this.nematodeMainView.getContentPane();

		contentPane.add(
				this.nematodeProjectPanelViewController.getNematodePanel(),
				BorderLayout.WEST);
		contentPane.add(
				this.nematodeVideoPanelViewController.getNematodePanel(),
				BorderLayout.CENTER);
		contentPane.add(
				this.nematodeTrackingPanelViewController.getNematodePanel(),
				BorderLayout.EAST);
	}

	public NematodeMainView getNematodeMainView() {
		return this.nematodeMainView;
	}

	public NematodePanelViewControllerInterface getNematodeProjectPanelViewController() {
		return this.nematodeProjectPanelViewController;
	}

	public NematodePanelViewControllerInterface getNematodeTrackingPanelViewController() {
		return this.nematodeTrackingPanelViewController;
	}

	public NematodePanelViewControllerInterface getNematodeVideoPanelViewController() {
		return this.nematodeVideoPanelViewController;
	}

	public VideoFrameBuilderInterface getVideoFrameBuilder() {
		return this.videoFrameBuilder;
	}
}
