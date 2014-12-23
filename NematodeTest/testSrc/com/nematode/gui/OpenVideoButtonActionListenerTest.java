package com.nematode.gui;

import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.junit.Test;

import com.nematode.fileIO.MockFileChooser;
import com.nematode.model.LoadedVideo;
import com.nematode.model.MockVideoMatriarch;
import com.nematode.model.NullVideo;
import com.nematode.unittesting.AssertTestCase;

public class OpenVideoButtonActionListenerTest extends AssertTestCase {

	@Test
	public void testExtendsActionListener() throws Exception {
		assertImplementsInterface(ActionListener.class, OpenVideoButtonActionListener.class);
	}

	@Test
	public void testGetsVideoFileChooserPassedIn() throws Exception {
		final MockFileChooser fileChooser = new MockFileChooser();
		final OpenVideoButtonActionListener openVideoButtonListener = new OpenVideoButtonActionListener(
				fileChooser, new MockVideoMatriarch());
		assertSame(fileChooser, openVideoButtonListener.getFileChooser());
	}

	@Test
	public void testGetsVideoMatriarchPassedIn() throws Exception {
		final MockVideoMatriarch videoMatriarch = new MockVideoMatriarch();
		final OpenVideoButtonActionListener openVideoButtonListener = new OpenVideoButtonActionListener(
				new MockFileChooser(), videoMatriarch);

		assertSame(videoMatriarch, openVideoButtonListener.getVideoMatriarch());
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

	@Test
	public void testActionPerformedSetsLoadedVideoOnVideoMatriarch_ValidFile() throws Exception {
		final MockFileChooser fileChooser = new MockFileChooser();
		final MockVideoMatriarch videoMatriarch = new MockVideoMatriarch();

		fileChooser.setShowDialogValueToReturn(JFileChooser.APPROVE_OPTION);
		final File validFile = new File("testResources/Videos/shortNematode_10.avi");
		fileChooser.setSelectedFile(validFile);

		final OpenVideoButtonActionListener openVideoButtonListener = new OpenVideoButtonActionListener(
				fileChooser, videoMatriarch);

		assertFalse(videoMatriarch.wasSetVideoCalled());
		openVideoButtonListener.actionPerformed(null);
		assertTrue(videoMatriarch.wasSetVideoCalled());

		assertIsOfTypeAndGet(LoadedVideo.class, videoMatriarch.getVideo());
	}

	@Test
	public void testActionPerformedSetsNullVideoOnVideoMatriarch_InvalidFile() throws Exception {
		final MockFileChooser fileChooser = new MockFileChooser();
		final MockVideoMatriarch videoMatriarch = new MockVideoMatriarch();

		fileChooser.setShowDialogValueToReturn(JFileChooser.APPROVE_OPTION);
		final File invalidFile = new File("");
		fileChooser.setSelectedFile(invalidFile);

		final OpenVideoButtonActionListener openVideoButtonListener = new OpenVideoButtonActionListener(
				fileChooser, videoMatriarch);

		assertFalse(videoMatriarch.wasSetVideoCalled());
		openVideoButtonListener.actionPerformed(null);
		assertTrue(videoMatriarch.wasSetVideoCalled());

		assertIsOfTypeAndGet(NullVideo.class, videoMatriarch.getVideo());
	}

	@Test
	public void testActionPerformedDoesNothingToTheVideoMatriarchIfTheFileChooserDoesNotApprove()
			throws Exception {
		final MockFileChooser fileChooser = new MockFileChooser();
		final MockVideoMatriarch videoMatriarch = new MockVideoMatriarch();

		fileChooser.setShowDialogValueToReturn(JFileChooser.CANCEL_OPTION);

		final OpenVideoButtonActionListener openVideoButtonListener = new OpenVideoButtonActionListener(
				fileChooser, videoMatriarch);

		assertFalse(videoMatriarch.wasSetVideoCalled());
		openVideoButtonListener.actionPerformed(null);
		assertFalse(videoMatriarch.wasSetVideoCalled());
	}
}
