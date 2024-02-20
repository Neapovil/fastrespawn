package com.github.neapovil.fastrespawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;

public final class FastRespawn extends JavaPlugin implements Listener
{
    private static FastRespawn instance;

    @Override
    public void onEnable()
    {
        instance = this;

        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable()
    {
    }

    public static FastRespawn instance()
    {
        return instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void playerDeath(PlayerDeathEvent event)
    {
        event.setCancelled(true);

        event.getPlayer().showTitle(Title.title(Component.translatable("deathScreen.title", NamedTextColor.RED), Component.empty()));

        event.getPlayer().getInventory().clear();

        event.getPlayer().spigot().respawn();
    }
}
