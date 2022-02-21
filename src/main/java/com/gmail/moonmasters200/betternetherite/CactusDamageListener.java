package com.gmail.moonmasters200.betternetherite;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class CactusDamageListener implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent entityDamageEvent) {
        if (entityDamageEvent.getCause() != EntityDamageEvent.DamageCause.CONTACT) {
            return;
        }

        var entity = entityDamageEvent.getEntity();

        if (!(entity instanceof Item)) {
            return;
        }

        var item = (Item) entity;
        var material = item.getItemStack().getType();

        if (NetheriteMaterialChecker.isMaterialNetherite(material)) {
            entityDamageEvent.setCancelled(true);
        }
    }
}
