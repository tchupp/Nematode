package com.nematode.bucket;

import com.nematode.gui.ImageStoreInterface;
import com.nematode.gui.console.EventMessageStore;
import com.nematode.gui.console.EventMessageStoreInterface;

public class StrategyBucket {

	private static EventMessageStoreInterface eventMessageStore = new EventMessageStore();
	private static ImageStoreInterface imageStore;

	private StrategyBucket() {
	}

	public static EventMessageStoreInterface getEventMessageStore() {
		return StrategyBucket.eventMessageStore;
	}

	public static void setEventMessageStore(final EventMessageStoreInterface eventMessageStore) {
		StrategyBucket.eventMessageStore = eventMessageStore;
	}

	public static ImageStoreInterface getImageStore() {
		return StrategyBucket.imageStore;
	}

	public static void setImageStore(final ImageStoreInterface imageStore) {
		StrategyBucket.imageStore = imageStore;
	}
}
