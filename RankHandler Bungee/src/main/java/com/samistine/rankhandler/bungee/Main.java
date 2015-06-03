package com.samistine.rankhandler.bungee;

import com.samistine.rankhandler.bungee.objects.SamPlayer;
import com.google.common.base.Charsets;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener {

    public static Main main;
    
    @Override
    public void onEnable() {
        getLogger().info("Enabled RankHandler-BungeeCord");
        getProxy().registerChannel("RankHandler_SendRank");
        getProxy().getPluginManager().registerListener(this, this);
        main = this;
    }

    HashMap<UUID, String[]> ranks = new HashMap<>();

    @EventHandler
    public void onPluginMessage(PluginMessageEvent e) {
        if (e.getSender() instanceof Server) {
            if (e.getTag().equalsIgnoreCase("RankHandler_SendRank")) {
                String message = new String(e.getData(), Charsets.UTF_8);
                Gson myGson = new Gson();
                System.out.println(message); //Debug message
                SamPlayer samPlayer = myGson.fromJson(message, SamPlayer.class);
                addRank(samPlayer);
            }
        }
    }

    @EventHandler
    public void serverDisconnect(ServerDisconnectEvent e) {
        UUID uuid = e.getPlayer().getUniqueId();
        remRank(uuid);
    }

    private synchronized void addRank(SamPlayer p) {
        ranks.put(p.getUuid(), p.getRankInfo().getGroups());
    }

    private synchronized void remRank(UUID uuid) {
        if (ranks.containsKey(uuid)) {
            ranks.remove(uuid);
        }
    }
    private synchronized String[] getRanksCopy(UUID uuid) {
        String[] result;
        if (ranks.containsKey(uuid)) {
            result = ranks.get(uuid);
        } else {
            result = new String[] {"NotYetInitialized"};
        }
        return Arrays.copyOf(result, result.length);
    }
    
    /**
     * EXTERNAL API ACCESS
     * @param uuid
     * @return ranks String[], if data non-existent it will return a new String[] containing NotYetInitialized
     */
    public String[] getRanksByUUID(UUID uuid) {
        return getRanksCopy(uuid);
    }
}
