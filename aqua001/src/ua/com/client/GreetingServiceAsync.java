package ua.com.client;

import ua.com.client.dto.EveryDayBonus;
import ua.com.client.dto.Planet;
import ua.com.client.dto.Plant;
import ua.com.client.dto.UserDTO;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void getPlant(AsyncCallback<Plant> callback);

	void getBonus(AsyncCallback<EveryDayBonus> callback);

	void getPlanet(AsyncCallback<Planet> callback);

	void getUserDTO(AsyncCallback<UserDTO> callback);
}
