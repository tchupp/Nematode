package com.nematode.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import com.nematode.image.detection.ContourAreaCalculator;
import com.nematode.image.detection.EdgeDetectionRunner;
import com.nematode.image.detection.SquareContourTracer;
import com.nematode.image.processing.ImageProcessingHelper;
import com.nematode.image.processing.ImageProcessingRunner;
import com.nematode.model.VideoFrame;
import com.nematode.model.VideoFrameHandler;
import com.nematode.model.VideoFrameHandlerInterface;
import com.nematode.model.factory.FrameImageAssembler;
import com.nematode.model.factory.NematodeWormBuilder;

public class NematodeMainViewController implements MainViewControllerInterface {

	private final NematodePanelViewControllerInterface nematodeProjectPanelViewController;
	private final NematodePanelViewControllerInterface nematodeVideoPanelViewController;
	private final NematodePanelViewControllerInterface nematodeTrackingPanelViewController;
	private final ExtendableJFrame nematodeMainView;
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
		final VideoFrame videoFrame = new VideoFrame();

		final ImageProcessingRunner imageProcessingRunner = new ImageProcessingRunner(
				new ImageProcessingHelper());
		NematodeWormBuilder nematodeWormBuilder = new NematodeWormBuilder(
				new ContourAreaCalculator());
		final EdgeDetectionRunner edgeDetectionRunner = new EdgeDetectionRunner(
				new SquareContourTracer(), nematodeWormBuilder,
				new ImageProcessingHelper());

		this.videoFrameHandler = new VideoFrameHandler(videoFrame,
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
	public ExtendableJFrame getNematodeMainView() {
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
