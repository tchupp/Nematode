package com.nematode.gui;

import javax.swing.JButton;

import org.junit.Test;

import com.nematode.image.MockVideoFrameHandler;
import com.nematode.model.VideoFrameHandlerInterface;
import com.nematode.unittesting.AssertTestCase;

public class ProjectPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ProjectPanelViewControllerInterface.class,
				ProjectPanelViewController.class);
	}

	@Test
	public void testGetsNematodeProjectPanel() throws Exception {
		final ProjectPanelViewController projectViewController = new ProjectPanelViewController(
				new MockVideoFrameHandler());

		assertIsOfTypeAndGet(ProjectPanel.class, projectViewController.getProjectPanel());
	}

	@Test
	public void testGetsVideoFrameHandler() throws Exception {
		final MockVideoFrameHandler expectedVideoFrameHandler = new MockVideoFrameHandler();
		final ProjectPanelViewController projectPanelViewController = new ProjectPanelViewController(
				expectedVideoFrameHandler);

		final VideoFrameHandlerInterface actualVideoFrameHandler = projectPanelViewController
				.getVideoFrameHandler();
		assertSame(expectedVideoFrameHandler, actualVideoFrameHandler);
	}

	@Test
	public void testConstructionAddsListener_OpenImageButtonOnPanel() throws Exception {
		final MockVideoFrameHandler expectedVideoFrameHandler = new MockVideoFrameHandler();
		final ProjectPanelViewController projectPanelViewController = new ProjectPanelViewController(
				expectedVideoFrameHandler);

		final ProjectPanel projectPanel = assertIsOfTypeAndGet(ProjectPanel.class,
				projectPanelViewController.getProjectPanel());

		final JButton openImageButton = projectPanel.getOpenImageButton();
		assertEquals(1, openImageButton.getActionListeners().length);

		final OpenImageButtonActionListener imageButtonActionListener = assertIsOfTypeAndGet(
				OpenImageButtonActionListener.class, openImageButton.getActionListeners()[0]);

		final VideoFrameHandlerInterface actualVideoFrameHandler = imageButtonActionListener
				.getVideoFrameHandler();
		assertSame(expectedVideoFrameHandler, actualVideoFrameHandler);
	}
}
