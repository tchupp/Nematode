package com.nematode.fileIO;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.junit.Test;

import com.nematode.imaging.MockVideoFrameHandler;
import com.nematode.unittesting.AssertTestCase;

public class OpenImageButtonActionListenerTest extends AssertTestCase {

	@Test
	public void testExtendsActionListener() throws Exception {
		assertImplementsInterface(ActionListener.class,
				OpenImageButtonActionListener.class);
	}

	@Test
	public void testGetImageFileChooser() throws Exception {
		final MockFileChooser fileChooser = new MockFileChooser();
		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				fileChooser, new MockVideoFrameHandler());
		assertSame(fileChooser, openImageButtonListener.getFileChooser());
	}

	@Test
	public void testGetsVideoFrameHandler() throws Exception {
		final MockVideoFrameHandler videoFrameHandler = new MockVideoFrameHandler();
		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				new MockFileChooser(), videoFrameHandler);
		assertSame(videoFrameHandler,
				openImageButtonListener.getVideoFrameHandler());
	}

	@Test
	public void testActionPerformedCallsShowDialog() throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				mockFileChooser, new MockVideoFrameHandler());
		assertFalse(mockFileChooser.wasShowDialogCalled());
		openImageButtonListener.actionPerformed(null);
		assertTrue(mockFileChooser.wasShowDialogCalled());
	}

	@Test
	public void testOpeningAFile_CallsBuildOnTheVideoFrameHandler()
			throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		mockFileChooser.setShowDialogValueToReturn(JFileChooser.APPROVE_OPTION);

		final File expectedSelectedFile = new File("");
		mockFileChooser.setSelectedFile(expectedSelectedFile);

		final MockVideoFrameHandler mockVideoFrameHandler = new MockVideoFrameHandler();

		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				mockFileChooser, mockVideoFrameHandler);

		assertFalse(mockVideoFrameHandler.wasBuildVideoFrameCalled());
		openImageButtonListener.actionPerformed(null);
		assertTrue(mockVideoFrameHandler.wasBuildVideoFrameCalled());
	}
}
