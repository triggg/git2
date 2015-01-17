package ua.com.server;

import java.util.Date;

import ua.com.client.dto.Plant;
import ua.com.client.dto.UserDTO;
import ua.com.server.factory.PlantFactory;
import ua.com.server.factory.UserFactory;

public class HardBase {

	private static HardBase instance = null;

	public static HardBase getInstance() {
		if (instance == null) {
			instance = new HardBase();
		}
		return instance;
	}

	private Plant plant;
	private UserDTO user;
	
	private Date lastDateBonus;

	private HardBase() {
		plant = PlantFactory.getRandPlant();
		user = UserFactory.getUserDTO();
		//if currentDate after lastDate or equals then bonus available 
		lastDateBonus = new Date();
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Date getLastDateBonus() {
		return lastDateBonus;
	}

	public void setLastDateBonus(Date lastDateBonus) {
		this.lastDateBonus = lastDateBonus;
	}

}
