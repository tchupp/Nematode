package com.nematode.gui;

import java.awt.event.ActionListener;

import org.junit.Test;

import com.nematode.fileIO.MockFileChooser;
import com.nematode.unittesting.AssertTestCase;

public class OpenImageButtonActionListenerTest extends AssertTestCase {

	@Test
	public void testExtendsActionListener() throws Exception {
		assertImplementsInterface(ActionListener.class, OpenImageButtonActionListener.class);
	}

	@Test
	public void testGetsImageFileChooser() throws Exception {
		final MockFileChooser fileChooser = new MockFileChooser();
		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				fileChooser);
		assertSame(fileChooser, openImageButtonListener.getFileChooser());
	}

	@Test
	public void testActionPerformedCallsShowDialog() throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				mockFileChooser);

		assertFalse(mockFileChooser.wasShowDialogCalled());
		openImageButtonListener.actionPerformed(null);
		assertTrue(mockFileChooser.wasShowDialogCalled());
	}
}
