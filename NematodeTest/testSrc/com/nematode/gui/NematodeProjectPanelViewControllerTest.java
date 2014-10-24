package com.nematode.gui;

import javax.swing.JButton;

import org.junit.Test;

import com.nematode.image.MockVideoFrameHandler;
import com.nematode.model.VideoFrameHandlerInterface;
import com.nematode.unittesting.AssertTestCase;

public class NematodeProjectPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodePanelViewControllerInterface.class,
				NematodeProjectPanelViewController.class);
	}

	@Test
	public void testGetsNematodeProjectPanel() throws Exception {
		final NematodeProjectPanelViewController nematodeProjectViewController = new NematodeProjectPanelViewController(
				new MockVideoFrameHandler());

		assertIsOfTypeAndGet(NematodeProjectPanel.class,
				nematodeProjectViewController.getNematodePanel());
	}

	@Test
	public void testGetsVideoFrameHandler() throws Exception {
		final MockVideoFrameHandler expectedVideoFrameHandler = new MockVideoFrameHandler();
		final NematodeProjectPanelViewController nematodeProjectPanelViewController = new NematodeProjectPanelViewController(
				expectedVideoFrameHandler);

		final VideoFrameHandlerInterface actualVideoFrameHandler = nematodeProjectPanelViewController
				.getVideoFrameHandler();
		assertSame(expectedVideoFrameHandler, actualVideoFrameHandler);
	}

	@Test
	public void testConstructionAddsListener_OpenImageButtonOnPanel() throws Exception {
		final MockVideoFrameHandler expectedVideoFrameHandler = new MockVideoFrameHandler();
		final NematodeProjectPanelViewController nematodeProjectPanelViewController = new NematodeProjectPanelViewController(
				expectedVideoFrameHandler);

		final NematodeProjectPanel nematodeProjectPanel = assertIsOfTypeAndGet(
				NematodeProjectPanel.class, nematodeProjectPanelViewController.getNematodePanel());

		final JButton openImageButton = nematodeProjectPanel.getOpenImageButton();
		assertEquals(1, openImageButton.getActionListeners().length);

		final OpenImageButtonActionListener imageButtonActionListener = assertIsOfTypeAndGet(
				OpenImageButtonActionListener.class, openImageButton.getActionListeners()[0]);

		final VideoFrameHandlerInterface actualVideoFrameHandler = imageButtonActionListener
				.getVideoFrameHandler();
		assertSame(expectedVideoFrameHandler, actualVideoFrameHandler);
	}
}
