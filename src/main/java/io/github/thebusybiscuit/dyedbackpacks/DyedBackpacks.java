package io.github.thebusybiscuit.dyedbackpacks;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.skull.SkullItem;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.GitHubBuildsUpdater;

public class DyedBackpacks extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        Config cfg = new Config(this);
        new Metrics(this, 5778);

        if (cfg.getBoolean("options.auto-update") && getDescription().getVersion().startsWith("DEV - ")) {
            new GitHubBuildsUpdater(this, getFile(), "TheBusyBiscuit/DyedBackpacks/master").start();
        }

        Research research = new Research(new NamespacedKey(this, "dyed_backpacks"), 17200, "Dyed Backpacks", 24);
        Category category = new Category(new NamespacedKey(this, "dyed_backpacks"), new CustomItem(SkullItem.fromBase64(BackpackColor.RED.getTexture()), "&4Dyed Backpacks"), 2);

        if (cfg.getBoolean("backpacks.small")) {
            createBackpacks(category, research, SlimefunItems.BACKPACK_SMALL, 9);
        }
        if (cfg.getBoolean("backpacks.normal")) {
            createBackpacks(category, research, SlimefunItems.BACKPACK_MEDIUM, 18);
        }
        if (cfg.getBoolean("backpacks.large")) {
            createBackpacks(category, research, SlimefunItems.BACKPACK_LARGE, 27);
        }
        if (cfg.getBoolean("backpacks.woven")) {
            createBackpacks(category, research, SlimefunItems.WOVEN_BACKPACK, 36);
        }
        if (cfg.getBoolean("backpacks.gilded")) {
            createBackpacks(category, research, SlimefunItems.GILDED_BACKPACK, 45);
        }
        if (cfg.getBoolean("backpacks.radiant")) {
            createBackpacks(category, research, SlimefunItems.RADIANT_BACKPACK, 54);
        }

        research.register();
    }

    private void createBackpacks(Category category, Research research, SlimefunItemStack backpack, int size) {
        for (BackpackColor color : BackpackColor.values()) {
            SlimefunItemStack item = new SlimefunItemStack("DYED_" + backpack.getItemId() + "_" + color.name(), color.getTexture(), backpack.getItemMeta().getDisplayName() + " &7(" + color.getName() + "&7)", backpack.getItemMeta().getLore().toArray(new String[0]));
            DyedBackpack dyed = new DyedBackpack(size, category, item, backpack, color);
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
