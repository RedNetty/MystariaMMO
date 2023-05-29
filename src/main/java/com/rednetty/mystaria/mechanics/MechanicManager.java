package main.java.com.rednetty.mystaria.mechanics;

import main.java.com.rednetty.mystaria.Mystaria;
import main.java.com.rednetty.mystaria.mechanics.player.PlayerTestMechanic;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class MechanicManager {

    private final JavaPlugin plugin;
    private final PluginManager pluginManager;
    private final Set<Mechanic> mechanics;

    public MechanicManager() {
        this.plugin = Mystaria.getInstance();
        this.pluginManager = plugin.getServer().getPluginManager();
        this.mechanics = new HashSet<>();
    }

    public void initMechanics() {
        registerMechanic(new PlayerTestMechanic());
    }

    public void registerMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
        pluginManager.registerEvents(mechanic, plugin);
        mechanic.onInit();
    }

    public void unregisterAll() {
        mechanics.forEach(Mechanic::onStop);
        mechanics.clear();
    }
}

