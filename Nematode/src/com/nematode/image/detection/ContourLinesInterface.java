package com.nematode.image.detection;

import java.util.List;

public interface ContourLinesInterface {

	public List<ContourPointInterface> getListOfContourPoints();

	public List<ContourPointInterface> getPointsAtX(int x);

	public List<ContourPointInterface> getPointsAtY(int y);

	public boolean isEmpty();

}
