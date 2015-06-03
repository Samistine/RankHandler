/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.rankhandler.bukkit.messagehandlers;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.samistine.rankhandler.bukkit.Main;
import com.samistine.rankhandler.bukkit.objects.SamPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 *
 * Please run this in a Sync task as not to cause problems
 * Call about 10-20ms after login or when the plugin channel is registered
 *
 * @author Samuel
 */
public class SendRankInfo implements Runnable {

    private final SamPlayer player;

    public SendRankInfo(SamPlayer player) {
        this.player = player;
    }

    @Override
    public void run() {
        //Verify user is still online
        if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(player.getUuid()))) {
            sendRankInfo(Bukkit.getPlayer(player.getUuid()));
        }
    }

    private void sendRankInfo(Player p) {
        Gson gson = new Gson();
        String json = gson.toJson(player);
        p.sendPluginMessage(Main.plugin, "RankHandler_SendRank", json.getBytes(Charsets.UTF_8));
        //TODO: Debug output here
    }

} 
