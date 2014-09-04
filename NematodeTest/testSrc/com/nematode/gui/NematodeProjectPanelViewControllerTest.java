package com.nematode.gui;

import javax.swing.JButton;

import org.junit.Test;

import com.nematode.fileIO.OpenImageButtonActionListener;
import com.nematode.imaging.MockVideoFrameBuilder;
import com.nematode.imaging.VideoFrameBuilderInterface;
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
				new MockVideoFrameBuilder());

		assertIsOfTypeAndGet(NematodeProjectPanel.class,
				nematodeProjectViewController.getNematodePanel());
	}

	@Test
	public void testGetsVideoFrameBuilder() throws Exception {
		final MockVideoFrameBuilder expectedVideoFrameBuilder = new MockVideoFrameBuilder();
		final NematodeProjectPanelViewController nematodeProjectPanelViewController = new NematodeProjectPanelViewController(
				expectedVideoFrameBuilder);

		final VideoFrameBuilderInterface actualVideoFrameBuilder = nematodeProjectPanelViewController
				.getVideoFrameBuilder();
		assertSame(expectedVideoFrameBuilder, actualVideoFrameBuilder);

	}

	@Test
	public void testConstructionAddsListener_OpenImageButtonOnPanel()
			throws Exception {
		final MockVideoFrameBuilder expectedVideoFrameBuilder = new MockVideoFrameBuilder();
		final NematodeProjectPanelViewController nematodeProjectPanelViewController = new NematodeProjectPanelViewController(
				expectedVideoFrameBuilder);

		final NematodeProjectPanel nematodeProjectPanel = assertIsOfTypeAndGet(
				NematodeProjectPanel.class,
				nematodeProjectPanelViewController.getNematodePanel());

		final JButton openImageButton = nematodeProjectPanel
				.getOpenImageButton();
		assertEquals(1, openImageButton.getActionListeners().length);

		final OpenImageButtonActionListener imageButtonActionListener = assertIsOfTypeAndGet(
				OpenImageButtonActionListener.class,
				openImageButton.getActionListeners()[0]);

		final VideoFrameBuilderInterface actualVideoFrameBuilder = imageButtonActionListener
				.getVideoFrameBuilder();
		assertSame(expectedVideoFrameBuilder, actualVideoFrameBuilder);
	}
}
