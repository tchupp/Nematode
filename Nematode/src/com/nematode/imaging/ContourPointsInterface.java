package com.nematode.imaging;

import java.util.List;

public interface ContourPointsInterface {

	public List<? extends ContourPointInterface> getListOfContourPoints();

	public List<? extends ContourPointInterface> getPointsAtX(int x);

	public List<? extends ContourPointInterface> getPointsAtY(int y);

}
