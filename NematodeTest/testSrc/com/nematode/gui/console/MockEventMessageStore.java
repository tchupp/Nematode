package com.nematode.gui.console;

public class MockEventMessageStore implements EventMessageStoreInterface {

	@Override
	public void addMessage(final StatusMessage message) {
	}

	@Override
	public StatusMessage getLastMessage() {
		return null;
	}

}
