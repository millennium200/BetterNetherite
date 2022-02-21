package com.gmail.moonmasters200.betternetherite;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FireDamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent entityDamageEvent) {
        if (entityDamageEvent.getEntityType() != EntityType.PLAYER) {
            return;
        }

        var entity = entityDamageEvent.getEntity();

        if (!(entity instanceof Player)) {
            return;
        }

        var player = (Player) entity;

        if (!NetheriteArmorChecker.isPlayerWearingAllNetherite(player)) {
            return;
        }

        var cause = entityDamageEvent.getCause();

        if (cause == EntityDamageEvent.DamageCause.FIRE ||
            cause == EntityDamageEvent.DamageCause.FIRE_TICK ||
            cause == EntityDamageEvent.DamageCause.HOT_FLOOR ||
            cause == EntityDamageEvent.DamageCause.LAVA) {
            var originalDamage = entityDamageEvent.getDamage();
            entityDamageEvent.setDamage(originalDamage * 3 / 4);
        }
    }
}
