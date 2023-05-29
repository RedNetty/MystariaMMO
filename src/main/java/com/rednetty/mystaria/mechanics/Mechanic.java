package main.java.com.rednetty.mystaria.mechanics;

import main.java.com.rednetty.mystaria.Mystaria;
import org.bukkit.event.Listener;

public interface Mechanic extends Listener {

    default void onInit() {}
    default void onStop() {}


    default void initListener(Listener listener) {
        Mystaria.getInstance().getPluginLoader().createRegisteredListeners(this, Mystaria.getInstance());
    }


}
