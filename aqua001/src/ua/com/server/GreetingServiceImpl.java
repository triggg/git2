package ua.com.server;

import ua.com.client.GreetingService;
import ua.com.client.dto.EveryDayBonus;
import ua.com.client.dto.Plant;
import ua.com.server.factory.BonusFactory;
import ua.com.server.factory.PlantFactory;
import ua.com.shared.FieldVerifier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		return "Hello";
	}



	@Override
	public Plant getPlant() {
		return PlantFactory.getRandPlant();
	}



	@Override
	public EveryDayBonus getBonus() {
		return BonusFactory.getEveryDayBonus();
	}
}
