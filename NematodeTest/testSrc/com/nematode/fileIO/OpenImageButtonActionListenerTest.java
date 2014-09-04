package com.nematode.fileIO;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.junit.Test;

import com.nematode.imaging.MockVideoFrameBuilder;
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
				fileChooser, new MockVideoFrameBuilder());
		assertSame(fileChooser, openImageButtonListener.getFileChooser());
	}

	@Test
	public void testGetsVideoFrameBuilder() throws Exception {
		final MockVideoFrameBuilder videoFrameBuilder = new MockVideoFrameBuilder();
		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				new MockFileChooser(), videoFrameBuilder);
		assertSame(videoFrameBuilder,
				openImageButtonListener.getVideoFrameBuilder());
	}

	@Test
	public void testActionPerformedCallsShowDialog() throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				mockFileChooser, new MockVideoFrameBuilder());
		assertFalse(mockFileChooser.wasShowDialogCalled());
		openImageButtonListener.actionPerformed(null);
		assertTrue(mockFileChooser.wasShowDialogCalled());
	}

	@Test
	public void testOpeningAFile_CallsBuildOnTheVideoFrameBuilder()
			throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		mockFileChooser.setShowDialogValueToReturn(JFileChooser.APPROVE_OPTION);

		final File expectedSelectedFile = new File("");
		mockFileChooser.setSelectedFile(expectedSelectedFile);

		final MockVideoFrameBuilder mockVideoFrameBuilder = new MockVideoFrameBuilder();

		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				mockFileChooser, mockVideoFrameBuilder);

		assertFalse(mockVideoFrameBuilder.wasBuildVideoFrameCalled());
		openImageButtonListener.actionPerformed(null);
		assertTrue(mockVideoFrameBuilder.wasBuildVideoFrameCalled());
	}
}
