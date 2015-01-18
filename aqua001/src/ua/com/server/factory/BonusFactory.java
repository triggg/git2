package ua.com.server.factory;

import java.util.Random;

import ua.com.client.dto.EveryDayBonus;

public class BonusFactory {
	
	private static Random random = new Random();
	
	public static EveryDayBonus getEveryDayBonus(){
		EveryDayBonus bonus = new EveryDayBonus();
		
		bonus.setGoldBonus((random.nextInt(5)+1)*5);
		
		return bonus;
	}
	
	public static EveryDayBonus getZeroDayBonus(){
		EveryDayBonus bonus = new EveryDayBonus();
		bonus.setGoldBonus(0);
		return bonus;
	}

}
