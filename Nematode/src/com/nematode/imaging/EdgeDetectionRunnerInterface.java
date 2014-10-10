package com.nematode.imaging;

import java.util.List;

import com.nematode.model.NematodeWormInterface;

public interface EdgeDetectionRunnerInterface {

	public List<NematodeWormInterface> findAllObjectsInImage(
			ProcessedFrameImageInterface processedFrameImage);

}
