package com.nematode.gui;

import javax.swing.JButton;

import org.junit.Test;

import com.nematode.fileIO.OpenImageButtonActionListener;
import com.nematode.unittesting.AssertTestCase;

public class NematodeProjectPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(NematodePanelViewControllerInterface.class,
				NematodeProjectPanelViewController.class);
	}

	@Test
	public void testGetsNematodeProjectPanel() throws Exception {
		final NematodeProjectPanelViewController nematodeProjectViewController = new NematodeProjectPanelViewController();

		assertIsOfTypeAndGet(NematodeProjectPanel.class,
				nematodeProjectViewController.getNematodePanel());
	}

	@Test
	public void testConstructionAddsListener_OpenImageButtonOnPanel()
			throws Exception {
		final NematodeProjectPanelViewController nematodeProjectPanelViewController = new NematodeProjectPanelViewController();

		final NematodeProjectPanel nematodeProjectPanel = assertIsOfTypeAndGet(
				NematodeProjectPanel.class,
				nematodeProjectPanelViewController.getNematodePanel());

		final JButton openImageButton = nematodeProjectPanel
				.getOpenImageButton();
		assertEquals(1, openImageButton.getActionListeners().length);
		assertIsOfTypeAndGet(OpenImageButtonActionListener.class,
				openImageButton.getActionListeners()[0]);
	}
}
