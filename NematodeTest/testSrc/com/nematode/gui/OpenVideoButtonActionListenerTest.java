package com.nematode.gui;

import java.awt.event.ActionListener;

import org.junit.Test;

import com.nematode.fileIO.MockFileChooser;
import com.nematode.model.MockVideoMatriarch;
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
				fileChooser, new MockVideoMatriarch());
		assertSame(fileChooser, openVideoButtonActionListener.getFileChooser());
	}

	@Test
	public void testGetsVideoMatriarchPassedIn() throws Exception {
		final MockVideoMatriarch videoMatriarch = new MockVideoMatriarch();
		final OpenVideoButtonActionListener openVideoButtonActionListener = new OpenVideoButtonActionListener(
				new MockFileChooser(), videoMatriarch);

		assertSame(videoMatriarch, openVideoButtonActionListener.getVideoMatriarch());
	}

	@Test
	public void testActionPerformedCallsShowDialog() throws Exception {
		final MockFileChooser fileChooser = new MockFileChooser();
		final OpenVideoButtonActionListener openVideoButtonListener = new OpenVideoButtonActionListener(
				fileChooser, new MockVideoMatriarch());

		assertFalse(fileChooser.wasShowDialogCalled());
		openVideoButtonListener.actionPerformed(null);
		assertTrue(fileChooser.wasShowDialogCalled());
	}
}
