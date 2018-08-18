package net.angusbeefgaming.nickplus.account;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.angusbeefgaming.nickplus.NickManager;

public class AccountManager implements Listener {
	public static List<Account> accounts = new ArrayList<Account>();
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		accounts.add(new Account(e.getPlayer()));
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent e) {
		NickManager.unNickPlayer(e.getPlayer());
		
		Account acc = getAccountFromPlayer(e.getPlayer());
		
		acc.setDisguised(false);
		acc.setDisguisedName(e.getPlayer().getName());
	}
	
	public static Account getAccountFromDisguise(String disguise) {
		for(Account acc : accounts) {
			if(acc.getDisguisedName().equalsIgnoreCase(disguise)) {
				return acc;
			}
		}
		return null;
	}
	
	public static Account getAccountFromPlayer(Player player) {
		for(Account acc : accounts) {
			if(acc.getPlayer() == player) {
				return acc;
			}
		}
		return null;
	}
}
