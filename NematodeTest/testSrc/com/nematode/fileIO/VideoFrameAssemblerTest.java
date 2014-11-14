package com.nematode.fileIO;

import org.junit.Test;

import com.nematode.image.MockFrameImageAssembler;
import com.nematode.image.MockVideoFrameImage;
import com.nematode.image.NullBufferedImage;
import com.nematode.model.MockVideoFrameSequence;
import com.nematode.unittesting.AssertTestCase;

public class VideoFrameAssemblerTest extends AssertTestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertImplementsInterface(VideoFrameAssemblerInterface.class, VideoFrameAssembler.class);
	}

	@Test
	public void testGetsVideoFrameSequencePassedIn() throws Exception {
		final MockVideoFrameSequence videoFrameSequence = new MockVideoFrameSequence();
		final VideoFrameAssembler videoFrameAssembler = new VideoFrameAssembler(videoFrameSequence,
				new MockFrameImageAssembler());
		assertSame(videoFrameSequence, videoFrameAssembler.getVideoFrameSequence());
	}

	@Test
	public void testGetsFrameImageAssemblerPassedIn() throws Exception {
		final MockFrameImageAssembler frameAssembler = new MockFrameImageAssembler();
		final VideoFrameAssembler videoFrameAssembler = new VideoFrameAssembler(
				new MockVideoFrameSequence(), frameAssembler);
		assertSame(frameAssembler, videoFrameAssembler.getFrameImageAssembler());
	}

	@Test
	public void testConstructVideoFrameAddsCorrectVideoFrameToVideoFrameSequence_ValidFile()
			throws Exception {
		final MockValidatedImageFile mockValidatedImageFile = new MockValidatedImageFile();
		final NullBufferedImage expectedImage = new NullBufferedImage();
		mockValidatedImageFile.setFileImage(expectedImage);
		mockValidatedImageFile.setIsFileValid(true);

		final MockVideoFrameSequence mockVideoFrameSequence = new MockVideoFrameSequence();
		final MockFrameImageAssembler frameImageAssembler = new MockFrameImageAssembler();

		final MockVideoFrameImage mockVideoFrameImage = new MockVideoFrameImage();
		frameImageAssembler.setVideoImageToReturn(mockVideoFrameImage);

		final VideoFrameAssembler videoFrameAssembler = new VideoFrameAssembler(
				mockVideoFrameSequence, frameImageAssembler);

		final Integer videoFrameIndex = 2;
		videoFrameAssembler.addNewVideoFrame(mockValidatedImageFile, videoFrameIndex);

		assertTrue(mockValidatedImageFile.wasIsFileValidCalled());

		assertTrue(frameImageAssembler.wasCreateVideoFrameImageCalled());
		assertSame(expectedImage, frameImageAssembler.getVideoImageToUse());

		assertTrue(mockVideoFrameSequence.wasAddVideoFrameCalled());
		assertEquals(videoFrameIndex, mockVideoFrameSequence.getFrameIndexToAdd());
		assertSame(mockVideoFrameImage, mockVideoFrameSequence.getVideoFrameToAdd()
				.getVideoFrameImage());
	}

	@Test
	public void testConstructVideoFrameDoesntAddVideoFrameToVideoFrameSequence_InvalidFile()
			throws Exception {
		final MockValidatedImageFile mockValidatedImageFile = new MockValidatedImageFile();
		mockValidatedImageFile.setFileImage(new NullBufferedImage());
		mockValidatedImageFile.setIsFileValid(false);

		final MockVideoFrameSequence mockVideoFrameSequence = new MockVideoFrameSequence();
		final MockFrameImageAssembler frameImageAssembler = new MockFrameImageAssembler();

		final VideoFrameAssembler videoFrameAssembler = new VideoFrameAssembler(
				mockVideoFrameSequence, frameImageAssembler);

		final int videoFrameIndex = 2;
		videoFrameAssembler.addNewVideoFrame(mockValidatedImageFile, videoFrameIndex);

		assertTrue(mockValidatedImageFile.wasIsFileValidCalled());

		assertFalse(frameImageAssembler.wasCreateVideoFrameImageCalled());
		assertFalse(mockVideoFrameSequence.wasAddVideoFrameCalled());
	}
}
