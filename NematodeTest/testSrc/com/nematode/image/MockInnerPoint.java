package com.nematode.image;

import com.nematode.image.detection.InnerPointInterface;

public class MockInnerPoint implements InnerPointInterface {

	private boolean isValid;
	private int x;
	private int y;

	@Override
	public int getX() {
		return this.x;
	}

	public void setX(final int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	public void setY(final int y) {
		this.y = y;
	}

	@Override
	public boolean isValid() {
		return this.isValid;
	}

	public void setIsValid(final boolean valid) {
		this.isValid = valid;
	}

}
