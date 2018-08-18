package net.angusbeefgaming.nickplus;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.nickplus.account.AccountManager;

public class NickPlus extends JavaPlugin {
	/*
	 * Nick+
	 * Created by Atticus Zambrana
	 * 
	 * Disguised yourself as another player
	 */
    private File configFile;
    private FileConfiguration config;
    
    static NickPlus instance;
    
	@Override
	public void onEnable() {
		instance = this;
		setupConfig();
		
		getCommand("nick").setExecutor(new NickCommand());
		getCommand("lookup").setExecutor(new LookupCommand());
		
		getServer().getPluginManager().registerEvents(new AccountManager(), this);
	}
	
	public static NickPlus getInstance() {
		return instance;
	}
	
    public FileConfiguration getConfig() {
        return this.config;
    }
	
	private void setupConfig() {
		configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
        	configFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
         }

        config = new YamlConfiguration();
        try {
        	config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
	}
}
