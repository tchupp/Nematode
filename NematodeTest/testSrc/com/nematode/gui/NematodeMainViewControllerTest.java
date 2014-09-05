package com.nematode.gui;

import java.awt.Component;
import java.awt.Container;

import org.junit.Test;

import com.nematode.imaging.VideoFrameBuilder;
import com.nematode.imaging.VideoFrameBuilderInterface;
import com.nematode.model.NematodeVideoFrameInterface;
import com.nematode.unittesting.AssertTestCase;

public class NematodeMainViewControllerTest extends AssertTestCase {

	@Test
	public void testConstructionAddsPanelsToViewCorrectly() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		final NematodeMainView nematodeMainView = nematodeMainViewController
				.getNematodeMainView();

		final Container contentPane = nematodeMainView.getContentPane();
		final Component[] components = contentPane.getComponents();
		assertEquals(3, components.length);

		assertIsOfTypeAndGet(NematodeProjectPanel.class, components[0]);
		assertIsOfTypeAndGet(NematodeVideoPanel.class, components[1]);
		assertIsOfTypeAndGet(NematodeTrackingPanel.class, components[2]);
	}

	@Test
	public void testGetVideoFrameBuilder() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		assertIsOfTypeAndGet(VideoFrameBuilder.class,
				nematodeMainViewController.getVideoFrameBuilder());
	}

	@Test
	public void testGetsNematodeMainView() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		assertIsOfTypeAndGet(NematodeMainView.class,
				nematodeMainViewController.getNematodeMainView());
	}

	@Test
	public void testGetPanelViewControllers() throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();

		assertIsOfTypeAndGet(NematodeProjectPanelViewController.class,
				nematodeMainViewController
				.getNematodeProjectPanelViewController());

		assertIsOfTypeAndGet(NematodeTrackingPanelViewController.class,
				nematodeMainViewController
				.getNematodeTrackingPanelViewController());

		assertIsOfTypeAndGet(NematodeVideoPanelViewController.class,
				nematodeMainViewController
				.getNematodeVideoPanelViewController());
	}

	@Test
	public void testProjectPanelViewControllerIsCreatedWithCorrectVideoFrameBuilder()
			throws Exception {
		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		final NematodeProjectPanelViewController projectPanelViewController = assertIsOfTypeAndGet(
				NematodeProjectPanelViewController.class,
				nematodeMainViewController
				.getNematodeProjectPanelViewController());

		final VideoFrameBuilderInterface actualVideoFrameBuilder = projectPanelViewController
				.getVideoFrameBuilder();

		assertSame(nematodeMainViewController.getVideoFrameBuilder(),
				actualVideoFrameBuilder);
	}

	@Test
	public void testVideoPanelControllerIsCreatedWithCorrectVideoFrameModel()
			throws Exception {

		final NematodeMainViewController nematodeMainViewController = new NematodeMainViewController();
		final NematodeVideoPanelViewController videoPanelViewController = assertIsOfTypeAndGet(
				NematodeVideoPanelViewController.class,
				nematodeMainViewController
						.getNematodeVideoPanelViewController());

		final VideoFrameBuilder videoFrameBuilder = assertIsOfTypeAndGet(
				VideoFrameBuilder.class,
				nematodeMainViewController.getVideoFrameBuilder());
		final NematodeVideoFrameInterface expectedNematodeVideoFrame = videoFrameBuilder
				.getNematodeVideoFrame();
		final NematodeVideoFrameInterface actualNematodeVideoFrame = videoPanelViewController
				.getNematodeVideoFrame();

		assertSame(expectedNematodeVideoFrame, actualNematodeVideoFrame);

	}
}
