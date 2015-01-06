package com.nematode.gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.junit.Test;

import com.nematode.unittesting.AssertTestCase;

public class ToolbarPanelViewControllerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(ToolbarPanelViewControllerInterface.class,
				ToolbarPanelViewController.class);
	}

	@Test
	public void testGetsToolbarPanel() throws Exception {
		final ToolbarPanelViewController toolbarViewController = new ToolbarPanelViewController();

		assertIsOfTypeAndGet(ToolbarPanel.class, toolbarViewController.getToolbarPanel());
	}

	@Test
	public void testConstructionAddsCorrectListener_PlayButtonOnPanel() throws Exception {
		final ToolbarPanelViewController toolbarViewController = new ToolbarPanelViewController();

		final ToolbarPanel toolbarPanel = assertIsOfTypeAndGet(ToolbarPanel.class,
				toolbarViewController.getToolbarPanel());

		final JButton playButton = toolbarPanel.getPlayButton();

		final ActionListener[] actionListeners = playButton.getActionListeners();
		assertEquals(1, actionListeners.length);

		final PlayButtonActionListener playButtonActionListener = assertIsOfTypeAndGet(
				PlayButtonActionListener.class, actionListeners[0]);

		assertSame(toolbarViewController, playButtonActionListener.getViewController());
	}
}
