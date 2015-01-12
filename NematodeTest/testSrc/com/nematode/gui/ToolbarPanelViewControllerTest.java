package com.nematode.gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;

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

	@Test
	public void testAddObserverCorrectlyAddsTheObserver() throws Exception {
		final ToolbarPanelViewController viewController = new ToolbarPanelViewController();
		final ArrayList<ToolbarObserverInterface> observerList = viewController.getObserverList();

		final MockToolbarObserver observer = new MockToolbarObserver();

		assertEquals(0, observerList.size());

		viewController.addObserver(observer);

		assertEquals(1, observerList.size());
		assertSame(observer, observerList.get(0));
	}

	@Test
	public void testRemoveObserverRemovesTheCorrectObserver() throws Exception {
		final ToolbarPanelViewController viewController = new ToolbarPanelViewController();
		final ArrayList<ToolbarObserverInterface> observerList = viewController.getObserverList();

		final MockToolbarObserver mockObserverOne = new MockToolbarObserver();
		final MockToolbarObserver mockObserverTwo = new MockToolbarObserver();

		viewController.addObserver(mockObserverOne);
		viewController.addObserver(mockObserverTwo);

		assertEquals(2, observerList.size());

		viewController.removeObserver(mockObserverOne);

		assertEquals(1, observerList.size());
		assertFalse(observerList.contains(mockObserverOne));
		assertTrue(observerList.contains(mockObserverTwo));
	}

	@Test
	public void testPlayButtonPressedNotifiesObserversCorrectly() throws Exception {
		final ToolbarPanelViewController viewController = new ToolbarPanelViewController();
		final ArrayList<ToolbarObserverInterface> observerList = viewController.getObserverList();

		final MockToolbarObserver observerOne = new MockToolbarObserver();
		final MockToolbarObserver observerTwo = new MockToolbarObserver();

		viewController.addObserver(observerOne);
		viewController.addObserver(observerTwo);
		assertEquals(2, observerList.size());

		assertFalse(observerOne.wasNotifyPlayButtonPressedCalled());
		assertFalse(observerTwo.wasNotifyPlayButtonPressedCalled());

		viewController.playButtonPressed();

		assertTrue(observerOne.wasNotifyPlayButtonPressedCalled());
		assertTrue(observerTwo.wasNotifyPlayButtonPressedCalled());
	}
}
