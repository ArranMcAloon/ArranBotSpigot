package xyz.arranbot.arranbotplugin;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;


public class Main extends JavaPlugin {

    FileConfiguration config = this.getConfig();

    protected static Plugin plugin = null;

    @Override
    public void onEnable() {

        if(plugin == null)
            plugin = this;
        else
            getLogger().warning("An issue has occurred in which the plugin was enabled twice.");


        getServer().getPluginManager().registerEvents(new joinEvent(), this);


        // Config file
        config.addDefault("MySQL", true);
        config.addDefault("Host", "localhost");
        config.addDefault("Database", "arranbot");
        config.addDefault("User", "root");
        config.addDefault("Password", "cookie");
        config.addDefault("UniqueServerID", "UniqueString69");
        config.options().copyDefaults(true);
        saveConfig();

        // Clear the database from any users on the server
        Mysql db = new Mysql();
        db.clear();
    }

    @Override
    public void onDisable() {

        // Clear the database from any users on the server
        Mysql db = new Mysql();
        db.clear();

    }

}
