package xyz.arranbot.arranbotplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class joinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        // Send message to console

        // Get players name
        String player = event.getPlayer().getName();

        // Add player to database
        Mysql db = new Mysql();
        db.add(player);

    }



    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {

        // Get players name
        String player = event.getPlayer().getName();

        // Add player to database

        // Add player to database
        Mysql db = new Mysql();
        db.remove(player);

    }
}
