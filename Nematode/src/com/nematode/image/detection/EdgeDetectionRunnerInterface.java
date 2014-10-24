package com.nematode.image.detection;

import java.util.List;

import com.nematode.image.ProcessedFrameImageInterface;
import com.nematode.model.NematodeWormInterface;

public interface EdgeDetectionRunnerInterface {

	public List<NematodeWormInterface> findAllObjectsInImage(
			ProcessedFrameImageInterface processedFrameImage);

}
