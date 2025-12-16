package main.java.com.rednetty.mystaria;

import main.java.com.rednetty.mystaria.mechanics.MechanicManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Mystaria extends JavaPlugin {

    private static Mystaria instance;
    private static MechanicManager mechanicManager;

    public static Mystaria getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this; // Inits the Instance of the Main Class
        mechanicManager = new MechanicManager(); // Inits the Mechanic Manager

        mechanicManager.initMechanics();
    }

    @Override
    public void onDisable() {
        mechanicManager.unregisterAll();
    }
}
