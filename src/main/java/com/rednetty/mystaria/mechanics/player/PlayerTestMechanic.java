package main.java.com.rednetty.mystaria.mechanics.player;

import main.java.com.rednetty.mystaria.mechanics.Mechanic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerTestMechanic implements Mechanic {

    @Override
    public void onInit() {
        initListener(this);
    }

    @Override
    public void onStop() {

    }

    @EventHandler
    public void onWalk(PlayerMoveEvent event) {
        event.getPlayer().sendMessage("okay now this is gay");
    }
}
