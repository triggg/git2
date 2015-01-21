package ua.com.server.factory;

import java.util.Random;

import ua.com.client.dto.Plant;

public class PlantFactory {

	public static Plant getRandPlant() {
		Random random = new Random();

		Plant plant = new Plant();

		plant.setName("Подорожник");

		plant.setParam0(random.nextInt(10) * 5);
		plant.setParam1(random.nextInt(10) * 5);
		plant.setParam2(random.nextInt(10) * 5);
		plant.setParam3(random.nextInt(10) * 5);
		plant.setParam4(random.nextInt(10) * 5);
		plant.setParam5(random.nextInt(10) * 5);
		plant.setParam6(random.nextInt(10) * 5);
		plant.setParam7(random.nextInt(10) * 5);
		plant.setParam8(random.nextInt(10) * 5);
		plant.setParam9(random.nextInt(10) * 5);

		return plant;
	}

}
