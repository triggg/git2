package ua.com.client.dto;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class EveryDayBonus implements IsSerializable, Serializable{
	
	private Integer goldBonus;

	public Integer getGoldBonus() {
		return goldBonus;
	}

	public void setGoldBonus(Integer goldBonus) {
		this.goldBonus = goldBonus;
	}

}
