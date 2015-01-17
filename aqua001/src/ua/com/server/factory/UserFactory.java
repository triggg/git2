package ua.com.server.factory;

import ua.com.client.dto.UserDTO;

public class UserFactory {
	
	public static UserDTO getUserDTO(){
		UserDTO user = new UserDTO();
		
		user.setName("userName");
		user.setGold(100);
		user.setActionPoints(100);
		
		return user;
	}

}
