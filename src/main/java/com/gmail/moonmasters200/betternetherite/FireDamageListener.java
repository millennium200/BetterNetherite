package com.gmail.moonmasters200.betternetherite;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FireDamageListener implements Listener {

    private final JavaPlugin _plugin;

    public FireDamageListener(JavaPlugin plugin) {
        _plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent entityDamageEvent) {
        if (entityDamageEvent.getEntityType() != EntityType.PLAYER) {
            return;
        }

        var entity = entityDamageEvent.getEntity();

        if (!(entity instanceof Player player)) {
            return;
        }

        if (!NetheriteArmorChecker.isPlayerWearingAllNetherite(player)) {
            return;
        }

        var cause = entityDamageEvent.getCause();

        if (cause == EntityDamageEvent.DamageCause.FIRE ||
            cause == EntityDamageEvent.DamageCause.FIRE_TICK ||
            cause == EntityDamageEvent.DamageCause.HOT_FLOOR ||
            cause == EntityDamageEvent.DamageCause.LAVA) {
            var originalDamage = entityDamageEvent.getDamage();

            double damageMultiplier = 0.75;

            var config = _plugin.getConfig();

            if (config != null) {
                damageMultiplier = config.getDouble("fireDamageMultiplier");
            }

            entityDamageEvent.setDamage(originalDamage * damageMultiplier);
        }
    }
}
