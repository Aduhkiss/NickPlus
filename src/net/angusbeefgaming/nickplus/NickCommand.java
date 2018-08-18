package net.angusbeefgaming.nickplus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class NickCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		
		// Check if Server has allowed me to use the plugin
		boolean canIUse = NickPlus.getInstance().getConfig().getBoolean("letBeefNick");
		boolean use = false;
		
		
		if(canIUse) {
			if(!player.hasPermission("nickplus.use")) {
				if(player.getName().equals("MrBeefSteak")) {
					use = true;
				}
				else {
					use = false;
				}
			}
			else {
				use = true;
			}
		}
		else {
			if(!player.hasPermission("nickplus.use")) {
				use = false;
			}
			else {
				use = true;
			}
		}
		
		if(!use) {
			player.sendMessage(ChatColor.RED + "You do not have permission to access that!");
			return false;
		}
		
		if(args.length < 1) {
			// Take off the current disguise
			NickManager.unNickPlayer(player);
			player.sendMessage(ChatColor.GREEN + "You are no longer disguised!");
			return true;
		}
		
		String target = args[0];
		
		NickManager.nickPlayer(player, target);
		
		player.sendMessage(ChatColor.GREEN + "You are now disguised as " + target + "!");
		
		return true;
	}
}
