package com.nematode.fileIO;

import com.nematode.image.VideoFrameImageInterface;
import com.nematode.model.VideoFrame;
import com.nematode.model.VideoFrameSequenceInterface;
import com.nematode.model.factory.FrameImageAssemblerInterface;

public class VideoFrameAssembler implements VideoFrameAssemblerInterface {

	private final VideoFrameSequenceInterface videoFrameSequence;
	private final FrameImageAssemblerInterface frameImageAssembler;

	public VideoFrameAssembler(final VideoFrameSequenceInterface videoFrameSequence,
			final FrameImageAssemblerInterface frameAssembler) {
		this.videoFrameSequence = videoFrameSequence;
		this.frameImageAssembler = frameAssembler;
	}

	@Override
	public void addNewVideoFrame(final ValidatedImageFileInterface imageFile, final int index) {
		if (imageFile.isFileValid()) {
			final VideoFrameImageInterface videoFrameImage = this.frameImageAssembler
					.createVideoFrameImage(imageFile.getFileImage());

			final VideoFrame videoFrame = new VideoFrame(videoFrameImage);

			this.videoFrameSequence.addVideoFrame(index, videoFrame);
		}
	}

	public FrameImageAssemblerInterface getFrameImageAssembler() {
		return this.frameImageAssembler;
	}

	public VideoFrameSequenceInterface getVideoFrameSequence() {
		return this.videoFrameSequence;
	}
}
