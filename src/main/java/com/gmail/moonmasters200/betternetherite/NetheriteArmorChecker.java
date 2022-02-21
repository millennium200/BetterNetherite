package com.gmail.moonmasters200.betternetherite;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class NetheriteArmorChecker {
    public static boolean isPlayerWearingAllNetherite(Player player) {
        var equipment = player.getEquipment();

        var helmet = equipment.getHelmet();

        if (helmet == null || helmet.getType() != Material.NETHERITE_HELMET) {
            return false;
        }

        var chestplate = equipment.getChestplate();

        if (chestplate == null || chestplate.getType() != Material.NETHERITE_CHESTPLATE) {
            return false;
        }

        var leggings = equipment.getLeggings();

        if (leggings == null || leggings.getType() != Material.NETHERITE_LEGGINGS) {
            return false;
        }

        var boots = equipment.getBoots();

        if (boots == null || boots.getType() != Material.NETHERITE_BOOTS) {
            return false;
        }

        return true;
    }
}
