package ua.com.server.factory;

import java.util.Random;

import ua.com.client.dto.Planet;

public class PlanetFactory {

	public static Planet getRandPlanet() {
		Random random = new Random();

		Planet planet = new Planet();

		planet.setName("Земля");

		planet.setParam0(random.nextInt(20) * 5);
		planet.setParam1(random.nextInt(20) * 5);
		planet.setParam2(random.nextInt(20) * 5);
		planet.setParam3(random.nextInt(20) * 5);
		planet.setParam4(random.nextInt(20) * 5);
		planet.setParam5(random.nextInt(20) * 5);
		planet.setParam6(random.nextInt(20) * 5);
		planet.setParam7(random.nextInt(20) * 5);
		planet.setParam8(random.nextInt(20) * 5);
		planet.setParam9(random.nextInt(20) * 5);

		return planet;
	}

}
