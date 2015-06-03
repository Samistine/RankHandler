/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.rankhandler.bukkit.eventlisteners;

import com.samistine.rankhandler.bukkit.Main;
import com.samistine.rankhandler.bukkit.messagehandlers.SendRankInfo;
import com.samistine.rankhandler.bukkit.objects.RankInfo;
import com.samistine.rankhandler.bukkit.objects.SamPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRegisterChannelEvent;

/**
 * Send RankInfo encapsulated in SamPlayer, to Bungee, as soon as a player
 * registers with the Channel
 *
 * @author Samuel
 */
public class PluginChannelUserRegistration implements Listener {
    
    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onRegisterChannelEvent(PlayerRegisterChannelEvent e) {
        if (e.getChannel().equals("RankHandler_SendRank")) {
            
            Player p = e.getPlayer();
            
            RankInfo rankInfo = new RankInfo(p);
            SamPlayer samPlayer = new SamPlayer(p.getUniqueId(), p.getName(), rankInfo);
            
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin,
                    new SendRankInfo(samPlayer));
        }
    }
}
