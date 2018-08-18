package net.angusbeefgaming.nickplus;

import org.bukkit.entity.Player;
import org.inventivetalent.nicknamer.api.NickNamerAPI;

import net.angusbeefgaming.nickplus.account.AccountManager;

public class NickManager {
	/*
	 * Created by Atticus Zambrana on 8/17/18
	 * Nickname Manager Class
	 */
	
	public static void nickPlayer(Player player, String target) {
		NickNamerAPI.getNickManager().setNick(player.getUniqueId(), target);
		NickNamerAPI.getNickManager().setSkin(player.getUniqueId(), target);
		player.setDisplayName(target);
		NickNamerAPI.getNickManager().refreshPlayer(player);
		System.out.println("Nick+ > " + player.getName() + " has just nicked as " + target + "!");
		
		AccountManager.getAccountFromPlayer(player).setDisguised(true);
		AccountManager.getAccountFromPlayer(player).setDisguisedName(target);
	}
	
	public static void unNickPlayer(Player player) {
		NickNamerAPI.getNickManager().removeNick(player.getUniqueId());
		NickNamerAPI.getNickManager().removeSkin(player.getUniqueId());
		NickNamerAPI.getNickManager().refreshPlayer(player);
		player.setDisplayName(player.getName());
		System.out.println("Nick+ > " + player.getName() + " has removed their nick!");
		
		AccountManager.getAccountFromPlayer(player).setDisguised(false);
		AccountManager.getAccountFromPlayer(player).setDisguisedName(player.getName());
	}

}
