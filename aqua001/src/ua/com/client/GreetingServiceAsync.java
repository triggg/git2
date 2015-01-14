package ua.com.client;

import ua.com.client.dto.EveryDayBonus;
import ua.com.client.dto.Plant;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void getPlant(AsyncCallback<Plant> callback);

	void getBonus(AsyncCallback<EveryDayBonus> callback);
}
