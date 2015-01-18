package ua.com.client;

import ua.com.client.dto.EveryDayBonus;
import ua.com.client.dto.Planet;
import ua.com.client.dto.Plant;
import ua.com.client.dto.UserDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	String greetServer(String name) throws IllegalArgumentException;
	
	Plant getPlant();
	
	/**
	 * @return dayBonusMoney if possible else 0
	 * */
	EveryDayBonus getBonus();
	
	Planet getPlanet();
	
	UserDTO getUserDTO();
}
