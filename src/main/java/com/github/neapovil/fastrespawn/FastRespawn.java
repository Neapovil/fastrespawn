package com.github.neapovil.fastrespawn;

import org.bukkit.event.EventHandler;
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

    public static FastRespawn getInstance()
    {
        return instance;
    }

    @EventHandler
    public void playerDeath(PlayerDeathEvent event)
    {
        event.setCancelled(true);

        event.getPlayer().spigot().respawn();

        event.getPlayer().showTitle(Title.title(Component.text("You died!", NamedTextColor.RED), Component.text("")));
    }
}
