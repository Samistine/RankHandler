/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.rankhandler.bungee.objects;

import com.samistine.rankhandler.bungee.objects.RankInfo;
import java.util.UUID;

/**
 *
 * @author Samuel
 */
public class SamPlayer {
    
    private UUID uuid;
    private String name;
    private RankInfo rankInfo;

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
