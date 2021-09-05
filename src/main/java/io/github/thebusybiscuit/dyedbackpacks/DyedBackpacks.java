package io.github.thebusybiscuit.dyedbackpacks;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bstats.bukkit.Metrics;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.GitHubBuildsUpdater;

/**
 * This is the main class of the {@link DyedBackpacks} addon.
 * Here we initialize the different instances of {@link DyedBackpack}.
 * 
 * @author TheBusyBiscuit
 * 
 * @see DyedBackpack
 *
 */
public class DyedBackpacks extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        Config cfg = new Config(this);
        new Metrics(this, 5778);

        if (cfg.getBoolean("options.auto-update") && getDescription().getVersion().startsWith("DEV - ")) {
            new GitHubBuildsUpdater(this, getFile(), "TheBusyBiscuit/DyedBackpacks/master").start();
        }

        Research research = new Research(new NamespacedKey(this, "dyed_backpacks"), 17200, "Dyed Backpacks", 24);
        ItemGroup itemGroup = new ItemGroup(new NamespacedKey(this, "dyed_backpacks"), new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(BackpackColor.RED.getTexture())), "&4Dyed Backpacks"), 2);

        if (cfg.getBoolean("backpacks.small")) {
            createBackpacks(itemGroup, research, SlimefunItems.BACKPACK_SMALL, 9);
        }
        if (cfg.getBoolean("backpacks.normal")) {
            createBackpacks(itemGroup, research, SlimefunItems.BACKPACK_MEDIUM, 18);
        }
        if (cfg.getBoolean("backpacks.large")) {
            createBackpacks(itemGroup, research, SlimefunItems.BACKPACK_LARGE, 27);
        }
        if (cfg.getBoolean("backpacks.woven")) {
            createBackpacks(itemGroup, research, SlimefunItems.WOVEN_BACKPACK, 36);
        }
        if (cfg.getBoolean("backpacks.gilded")) {
            createBackpacks(itemGroup, research, SlimefunItems.GILDED_BACKPACK, 45);
        }
        if (cfg.getBoolean("backpacks.radiant")) {
            createBackpacks(itemGroup, research, SlimefunItems.RADIANT_BACKPACK, 54);
        }

        research.register();
    }

    @ParametersAreNonnullByDefault
    private void createBackpacks(ItemGroup itemGroup, Research research, SlimefunItemStack backpack, int size) {
        for (BackpackColor color : BackpackColor.values()) {
            SlimefunItemStack item = new SlimefunItemStack("DYED_" + backpack.getItemId() + "_" + color.name(), color.getTexture(), backpack.getItemMeta().getDisplayName() + " &7(" + color.getName() + "&7)", backpack.getItemMeta().getLore().toArray(new String[0]));
            DyedBackpack dyed = new DyedBackpack(size, itemGroup, item, backpack, color);
            research.addItems(dyed);
            dyed.register(this);
        }
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/TheBusyBiscuit/DyedBackpacks/issues";
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }
}
