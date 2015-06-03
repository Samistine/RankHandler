package com.samistine.rankhandler.bukkit;

import com.samistine.rankhandler.bukkit.eventlisteners.PluginChannelUserRegistration;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;

public class Main extends JavaPlugin implements Listener/*, PluginMessageListener */ {

    public static Main plugin;
    public static Permission perms;

    @Override
    public void onEnable() {
        Main.plugin = this;
        Bukkit.getPluginManager().registerEvents(this, this);
        Server s = this.getServer();
        Messenger m = s.getMessenger();
        setupPermissions();

        //Sending rank data encapsulated in SamPlayer to Bungeecord, Class:@SendRankInfo
        m.registerOutgoingPluginChannel(this, "RankHandler_SendRank");
        s.getPluginManager().registerEvents(new PluginChannelUserRegistration(), this);
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

}
