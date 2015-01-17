package ua.com.client;

import ua.com.client.dto.EveryDayBonus;
import ua.com.client.dto.Planet;
import ua.com.client.dto.Plant;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	String greetServer(String name) throws IllegalArgumentException;
	
	Plant getPlant();
	
	EveryDayBonus getBonus();
	Planet getPlanet();
}
