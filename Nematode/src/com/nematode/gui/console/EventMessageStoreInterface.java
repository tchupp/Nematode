package com.nematode.gui.console;

public interface EventMessageStoreInterface {

	public void addMessage(StatusMessage message);

	public StatusMessage getLastMessage();

}
