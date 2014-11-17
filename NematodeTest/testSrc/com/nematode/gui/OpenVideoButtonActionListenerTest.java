package com.nematode.gui;

import java.awt.event.ActionListener;

import org.junit.Test;
import org.opencv.core.Core;

import com.nematode.fileIO.MockFileChooser;
import com.nematode.unittesting.AssertTestCase;

public class OpenVideoButtonActionListenerTest extends AssertTestCase {

	@Test
	public void testExtendsActionListener() throws Exception {
		assertImplementsInterface(ActionListener.class, OpenVideoButtonActionListener.class);
	}

	@Test
	public void testGetsVideoFileChooserPassedIn() throws Exception {
		final MockFileChooser fileChooser = new MockFileChooser();
		final OpenVideoButtonActionListener openVideoButtonActionListener = new OpenVideoButtonActionListener(
				fileChooser);
		assertSame(fileChooser, openVideoButtonActionListener.getFileChooser());
	}

	@Test
	public void testActionPerformedCallsShowDialog() throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		final MockFileChooser fileChooser = new MockFileChooser();
		final OpenVideoButtonActionListener openVideoButtonListener = new OpenVideoButtonActionListener(
				fileChooser);

		assertFalse(fileChooser.wasShowDialogCalled());
		openVideoButtonListener.actionPerformed(null);
		assertTrue(fileChooser.wasShowDialogCalled());
	}

	@Test
	public void testActually() throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		final OpenVideoButtonActionListener openVideoButtonActionListener = new OpenVideoButtonActionListener(
				new MockFileChooser());

		openVideoButtonActionListener.actionPerformed(null);
	}

}
