package io.github.pikachu920.blockstatemetaissue;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BuggedPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("demo")).setExecutor(new DemonstrateBugCommand());
    }

    @Override
    public void onDisable() {

    }

}
