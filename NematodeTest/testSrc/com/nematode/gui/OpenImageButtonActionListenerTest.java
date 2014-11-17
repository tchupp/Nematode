package com.nematode.gui;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.junit.Test;

import com.nematode.fileIO.MockFileChooser;
import com.nematode.fileIO.MockVideoFrameAssembler;
import com.nematode.fileIO.ValidatedImageFile;
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
				fileChooser, new MockVideoFrameAssembler());
		assertSame(fileChooser, openImageButtonListener.getFileChooser());
	}

	@Test
	public void testGetsVideoFrameAssembler() throws Exception {
		final MockVideoFrameAssembler mockVideoFrameAssembler = new MockVideoFrameAssembler();
		final OpenImageButtonActionListener openImageButtonActionListener = new OpenImageButtonActionListener(
				new MockFileChooser(), mockVideoFrameAssembler);
		assertSame(mockVideoFrameAssembler, openImageButtonActionListener.getVideoFrameAssembler());
	}

	@Test
	public void testActionPerformedCallsShowDialog() throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				mockFileChooser, new MockVideoFrameAssembler());

		assertFalse(mockFileChooser.wasShowDialogCalled());
		openImageButtonListener.actionPerformed(null);
		assertTrue(mockFileChooser.wasShowDialogCalled());
	}

	@Test
	public void testOpeningAFile_CallsBuildOnTheVideoFrameHandler() throws Exception {
		final MockFileChooser mockFileChooser = new MockFileChooser();
		mockFileChooser.setShowDialogValueToReturn(JFileChooser.APPROVE_OPTION);

		final File expectedSelectedFile = new File("");
		mockFileChooser.setSelectedFile(expectedSelectedFile);

		final MockVideoFrameAssembler videoFrameAssembler = new MockVideoFrameAssembler();

		final OpenImageButtonActionListener openImageButtonListener = new OpenImageButtonActionListener(
				mockFileChooser, videoFrameAssembler);

		assertFalse(videoFrameAssembler.wasAddNewVideoFrameCalled());

		openImageButtonListener.actionPerformed(null);

		assertTrue(videoFrameAssembler.wasAddNewVideoFrameCalled());
		assertEquals(0, videoFrameAssembler.getIndexToAdd());

		final ValidatedImageFile imageFile = assertIsOfTypeAndGet(ValidatedImageFile.class,
				videoFrameAssembler.getImageFileToAdd());

		assertSame(expectedSelectedFile, imageFile.getImageFile());
	}
}
