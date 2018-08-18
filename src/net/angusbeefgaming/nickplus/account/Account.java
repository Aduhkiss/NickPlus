package net.angusbeefgaming.nickplus.account;

import org.bukkit.entity.Player;

public class Account {
	Player myPlayer;
	boolean isDisguised;
	String disguisedName;
	
	public Account(Player player) {
		this.myPlayer = player;
	}
	public Player getPlayer() {
		return myPlayer;
	}
	public boolean isDisguised() {
		return isDisguised;
	}
	
	public void setDisguised(boolean isDisguised) {
		this.isDisguised = isDisguised;
	}
	public String getDisguisedName() {
		if(isDisguised()) {
			return disguisedName;
		}
		else {
			return getPlayer().getName();
		}
	}
	public String getRealName() {
		return myPlayer.getName();
	}
	public void setDisguisedName(String disguisedName) {
		this.disguisedName = disguisedName;
	}
	
}
