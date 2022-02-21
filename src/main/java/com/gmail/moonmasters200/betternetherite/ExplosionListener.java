package com.gmail.moonmasters200.betternetherite;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplosionListener implements Listener {

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent entityExplodeEvent) {
        var entity = entityExplodeEvent.getEntity();

        if (entityExplodeEvent.getEntityType() == EntityType.DROPPED_ITEM) {
            if (entity instanceof Item) {
                var item = (Item) entity;
                var material = item.getItemStack().getType();

                if (NetheriteMaterialChecker.isMaterialNetherite(material)) {
                    entityExplodeEvent.setCancelled(true);
                }
            }
        }

        if (entityExplodeEvent.getEntityType() == EntityType.PLAYER) {
            if (entity instanceof Player) {
                var player = (Player) entity;

                if (NetheriteArmorChecker.isPlayerWearingAllNetherite(player)) {
                    entityExplodeEvent.setCancelled(true);
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
            if (entity instanceof Item) {
                var item = (Item) entity;
                var material = item.getItemStack().getType();

                if (NetheriteMaterialChecker.isMaterialNetherite((material))) {
                    entityDamageEvent.setCancelled(true);
                }
            }
        }

        if (entityDamageEvent.getEntityType() == EntityType.PLAYER) {
            if (entity instanceof Player) {
                var player = (Player) entity;

                if (NetheriteArmorChecker.isPlayerWearingAllNetherite(player)) {
                    entityDamageEvent.setCancelled(true);
                }
            }
        }
    }

}
