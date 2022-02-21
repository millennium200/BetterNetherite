package com.gmail.moonmasters200.betternetherite;

import org.bukkit.Material;

public class NetheriteMaterialChecker {
    public static boolean isMaterialNetherite(Material material) {
        return material == Material.NETHERITE_BLOCK ||
                material == Material.NETHERITE_INGOT ||
                material == Material.NETHERITE_SCRAP ||
                material == Material.NETHERITE_SWORD ||
                material == Material.NETHERITE_SHOVEL ||
                material == Material.NETHERITE_PICKAXE ||
                material == Material.NETHERITE_AXE ||
                material == Material.NETHERITE_HOE ||
                material == Material.NETHERITE_HELMET ||
                material == Material.NETHERITE_CHESTPLATE ||
                material == Material.NETHERITE_LEGGINGS ||
                material == Material.NETHERITE_BOOTS;
    }
}
