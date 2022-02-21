package com.gmail.moonmasters200.betternetherite;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("BetterNetherite Plugin has started!");

        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new ExplosionListener(this), this);
        this.getServer().getPluginManager().registerEvents(new FireDamageListener(this), this);
        this.getServer().getPluginManager().registerEvents(new CactusDamageListener(), this);
    }

}
