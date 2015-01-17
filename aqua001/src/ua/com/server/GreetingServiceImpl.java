package ua.com.server;

import ua.com.client.GreetingService;
import ua.com.client.dto.EveryDayBonus;
import ua.com.client.dto.Planet;
import ua.com.client.dto.Plant;
import ua.com.server.factory.BonusFactory;
import ua.com.server.factory.PlanetFactory;
import ua.com.server.factory.PlantFactory;

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
		return HardBase.getInstance().getPlant();
	}



	@Override
	public EveryDayBonus getBonus() {
		return BonusFactory.getEveryDayBonus();
	}



	@Override
	public Planet getPlanet() {
		// TODO Auto-generated method stub
		return PlanetFactory.getRandPlanet();
	}
}
