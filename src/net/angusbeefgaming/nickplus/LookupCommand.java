package net.angusbeefgaming.nickplus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.nickplus.account.Account;
import net.angusbeefgaming.nickplus.account.AccountManager;
import net.md_5.bungee.api.ChatColor;

public class LookupCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;

		boolean use = false;
		
		if(!player.hasPermission("nickplus.lookup")) {
			use = false;
		}
		else {
			use = true;
		}
		
		if(!use) {
			player.sendMessage(ChatColor.RED + "You do not have permission to access that!");
			return false;
		}
		
		if(args.length < 1) {
			player.sendMessage(ChatColor.RED + "Please enter a Player Name.");
			return false;
		}
		
		Account target = AccountManager.getAccountFromDisguise(args[0]);
		
		if(target == null) {
			player.sendMessage(ChatColor.RED + "Player Not found!");
			return false;
		}
		
		player.sendMessage(ChatColor.GREEN + "Showing Information for: " + ChatColor.GOLD + target.getDisguisedName());
		if(target.isDisguised()) {
			player.sendMessage(ChatColor.GREEN + "Is Nicked: " + ChatColor.GOLD + "YES" + ChatColor.GREEN + "(" + target.getDisguisedName() + ")");
		}
		else {
			player.sendMessage(ChatColor.GREEN + "Is Nicked: " + ChatColor.RED + "NO");
		}
		
		player.sendMessage(ChatColor.GREEN + "Real Account Name: " + ChatColor.GOLD + target.getRealName());
		
		return true;
	}
}
