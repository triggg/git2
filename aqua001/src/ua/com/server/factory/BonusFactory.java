package ua.com.server.factory;

import java.util.Random;

import ua.com.client.dto.EveryDayBonus;

public class BonusFactory {
	
	private static Random random = new Random();
	
	public static EveryDayBonus getEveryDayBonus(){
		EveryDayBonus bonus = new EveryDayBonus();
		
		bonus.setGoldBonus(random.nextInt(20)+5);
		
		return bonus;
	}

}
