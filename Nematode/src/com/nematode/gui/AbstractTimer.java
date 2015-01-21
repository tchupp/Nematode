package com.nematode.gui;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public abstract class AbstractTimer extends Timer {

	private static final long serialVersionUID = 1L;

	public AbstractTimer(final int delay, final ActionListener listener) {
		super(delay, listener);
	}
}
