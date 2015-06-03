/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.rankhandler.bukkit.objects;

import com.samistine.rankhandler.bukkit.Main;
import org.bukkit.entity.Player;

/**
 * Player must be online for this to work
 *
 * @author Samuel
 */
public class RankInfo {

    private final String[] groups;

    public RankInfo(Player p) {
        this.groups = Main.plugin.perms.getPlayerGroups(p);
    }

    public String[] getGroups() {
        return groups;
    }

}
