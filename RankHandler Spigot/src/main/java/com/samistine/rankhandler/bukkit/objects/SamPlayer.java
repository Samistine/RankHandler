/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.rankhandler.bukkit.objects;

import java.util.UUID;

/**
 *
 * @author Samuel
 */
public class SamPlayer {

    private final UUID uuid;
    private final String name;
    private final RankInfo rankInfo;

    public SamPlayer(UUID uuid, String name, RankInfo rankInfo) {
        this.uuid = uuid;
        this.name = name;
        this.rankInfo = rankInfo;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public RankInfo getRankInfo() {
        return rankInfo;
    }

}
