package main.java.com.rednetty.mystaria.mechanics.player.stats;

import main.java.com.rednetty.mystaria.Mystaria;
import main.java.com.rednetty.mystaria.mechanics.Mechanic;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getServer;

public class HealthMechanic implements Mechanic {
    private BossBar bossBar;

    @Override
    public void onInit() {
        initListener(this);
        setupHealthBar();

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : getServer().getOnlinePlayers()) {
                    updateHealthBar(player);
                }
            }
        }.runTaskTimer(Mystaria.getInstance(), 0, 20); // Update every second
    }


    public void updateHealthBar(Player player) {
        double health = player.getHealth();
        double maxHealth = player.getMaxHealth();
        double healthPercentage = health / maxHealth;
        bossBar.setProgress(healthPercentage);
        bossBar.setTitle("Health: " + (int) health + "/" + (int) maxHealth);
        bossBar.addPlayer(player);
    }

    public BossBar setupHealthBar() {
        bossBar = getServer().createBossBar("Health", BarColor.RED, BarStyle.SEGMENTED_20);
        bossBar.setStyle(BarStyle.SEGMENTED_20);
        bossBar.setColor(BarColor.RED);
        bossBar.setVisible(true);
        bossBar.setProgress(1.0);
        return bossBar;
    }

    @Override
    public void onStop() {
        bossBar.removeAll();
    }

}
