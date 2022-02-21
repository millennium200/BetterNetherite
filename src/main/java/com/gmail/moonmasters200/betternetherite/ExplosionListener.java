package com.gmail.moonmasters200.betternetherite;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ExplosionListener implements Listener {

    private final JavaPlugin _plugin;

    public ExplosionListener(JavaPlugin plugin) {
        _plugin = plugin;
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent entityExplodeEvent) {
        var entity = entityExplodeEvent.getEntity();

        if (entityExplodeEvent.getEntityType() == EntityType.DROPPED_ITEM) {
            if (entity instanceof Item item) {
                var material = item.getItemStack().getType();

                if (NetheriteMaterialChecker.isMaterialNetherite(material)) {
                    entityExplodeEvent.setCancelled(true);
                }
            }
        }

        if (entityExplodeEvent.getEntityType() == EntityType.PLAYER) {
            if (entity instanceof Player player) {

                if (NetheriteArmorChecker.isPlayerWearingAllNetherite(player)) {
                    var damageMultiplier = getDamageMultiplier();
                    if (damageMultiplier == 0) {
                        entityExplodeEvent.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent entityDamageEvent) {
        if (!(entityDamageEvent.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) ||
            entityDamageEvent.getCause().equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION))) {
            return;
        }

        var entity = entityDamageEvent.getEntity();

        if (entityDamageEvent.getEntityType() == EntityType.DROPPED_ITEM) {
            if (entity instanceof Item item) {
                var material = item.getItemStack().getType();

                if (NetheriteMaterialChecker.isMaterialNetherite((material))) {
                    entityDamageEvent.setCancelled(true);
                }
            }
        }

        if (entityDamageEvent.getEntityType() == EntityType.PLAYER) {
            if (entity instanceof Player player) {

                if (NetheriteArmorChecker.isPlayerWearingAllNetherite(player)) {
                    var originalDamage = entityDamageEvent.getDamage();
                    var damageMultiplier = getDamageMultiplier();
                    entityDamageEvent.setDamage(originalDamage * damageMultiplier);
                }
            }
        }
    }

    private double getDamageMultiplier() {
        var config = _plugin.getConfig();

        if (config == null) {
            return 0;
        }

        return config.getDouble("explosionDamageMultiplier");
    }

}
