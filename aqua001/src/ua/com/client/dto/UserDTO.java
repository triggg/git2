package ua.com.client.dto;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserDTO implements IsSerializable, Serializable {

	private String name;
	private Integer gold;
	private Integer actionPoints;

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActionPoints() {
		return actionPoints;
	}

	public void setActionPoints(Integer actionPoints) {
		this.actionPoints = actionPoints;
	}

}
