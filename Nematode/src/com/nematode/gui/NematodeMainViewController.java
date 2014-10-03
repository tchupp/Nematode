package com.nematode.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import com.nematode.imaging.EdgeDetectionRunner;
import com.nematode.imaging.FrameImageAssembler;
import com.nematode.imaging.ImageProcessingHelper;
import com.nematode.imaging.ImageProcessingRunner;
import com.nematode.imaging.SquareContourTracer;
import com.nematode.imaging.VideoFrameHandler;
import com.nematode.imaging.VideoFrameHandlerInterface;
import com.nematode.model.NematodeVideoFrame;
import com.nematode.model.NematodeWormBuilder;

public class NematodeMainViewController implements MainViewControllerInterface {

	private final NematodePanelViewControllerInterface nematodeProjectPanelViewController;
	private final NematodePanelViewControllerInterface nematodeVideoPanelViewController;
	private final NematodePanelViewControllerInterface nematodeTrackingPanelViewController;
	private final NematodeFrame nematodeMainView;
	private VideoFrameHandlerInterface videoFrameHandler;

	public NematodeMainViewController() {
		this.nematodeMainView = new NematodeMainView();

		setUpVideoFrameHandler();

		this.nematodeProjectPanelViewController = new NematodeProjectPanelViewController(
				this.videoFrameHandler);
		this.nematodeVideoPanelViewController = new NematodeVideoPanelViewController(
				this.videoFrameHandler);
		this.nematodeTrackingPanelViewController = new NematodeTrackingPanelViewController(
				this.videoFrameHandler);

		addPanelsToFrame();
	}

	private void setUpVideoFrameHandler() {
		final NematodeVideoFrame nematodeVideoFrame = new NematodeVideoFrame();
		final ImageProcessingRunner imageProcessingRunner = new ImageProcessingRunner(
				new ImageProcessingHelper());
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				new SquareContourTracer(), new NematodeWormBuilder(),
				new ImageProcessingHelper());

		this.videoFrameHandler = new VideoFrameHandler(nematodeVideoFrame,
				new FrameImageAssembler(), imageProcessingRunner,
				edgeDetectionRunner);
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

	@Override
	public NematodeFrame getNematodeMainView() {
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

	public VideoFrameHandlerInterface getVideoFrameHandler() {
		return this.videoFrameHandler;
	}
}
