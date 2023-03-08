package xyz.arranbot.arranbotplugin;

import org.bukkit.configuration.file.FileConfiguration;

import java.sql.*;

public class Mysql {

    Connection conn = null;


    private Connection createConn() {

        try {

            String connection = "jdbc:mysql://" + Main.plugin.getConfig().getString("Host") + "/" + Main.plugin.getConfig().getString("Database") + "?user=" + Main.plugin.getConfig().getString("User") + "&password=" + Main.plugin.getConfig().getString("Password");
            conn = DriverManager.getConnection(connection);

        // Catch and handle any errors
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return conn;

    }

    public void add(String user) {

        conn = createConn();

        try {

            String sql = " INSERT INTO minecraft (server, username)" + " values (?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, Main.plugin.getConfig().getString("UniqueServerID"));
            preparedStmt.setString (2, user);

            preparedStmt.execute();
            conn.close();


        }

        // Catch and handle any errors
        catch (SQLException ex){

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public void clear() {

        conn = createConn();

        try {

            String sql = "DELETE FROM minecraft WHERE server = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, Main.plugin.getConfig().getString("UniqueServerID"));

            preparedStmt.execute();
            conn.close();

        }

        // Catch and handle any errors
        catch (SQLException ex){

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    public void remove(String user) {

        conn = createConn();

        try {

            String sql = "DELETE FROM minecraft WHERE username = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString (1, user);

            preparedStmt.execute();
            conn.close();

        }

        // Catch and handle any errors
        catch (SQLException ex){

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}
