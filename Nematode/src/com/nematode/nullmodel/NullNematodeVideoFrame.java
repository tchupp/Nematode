package com.nematode.nullmodel;

import com.nematode.model.NematodeVideoFrameInterface;

public class NullNematodeVideoFrame implements NematodeVideoFrameInterface {

	public static NullNematodeVideoFrame NULL = new NullNematodeVideoFrame();

	private NullNematodeVideoFrame() {
	}

}
