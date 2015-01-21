package ua.com.server;

import java.util.Date;

import ua.com.client.GreetingService;
import ua.com.client.dto.EveryDayBonus;
import ua.com.client.dto.Planet;
import ua.com.client.dto.Plant;
import ua.com.client.dto.UserDTO;
import ua.com.server.factory.BonusFactory;
import ua.com.server.factory.PlanetFactory;

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
		if (HardBase.getInstance().getLastDateBonus().compareTo(new Date()) <= 0) {
			EveryDayBonus bonus = BonusFactory.getEveryDayBonus();
			// add gold to user
			HardBase.getInstance().addGoldToUser(bonus.getGoldBonus());
			// up LastDateBonus
			HardBase.getInstance().upLastDateBonus();
			return bonus;
		}
		return BonusFactory.getZeroDayBonus();
	}

	@Override
	public Planet getPlanet() {
		return HardBase.getInstance().getPlanet();
	}

	@Override
	public UserDTO getUserDTO() {
		return HardBase.getInstance().getUser();
	}
}
