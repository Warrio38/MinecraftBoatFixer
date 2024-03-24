package org.warrio38.mc.boatfixer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.warrio38.mc.boatfixer.events.BoatEvents;

public final class BoatFixer extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BoatEvents(),this);
    }
}
