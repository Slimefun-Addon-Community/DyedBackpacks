package io.github.thebusybiscuit.dyedbackpacks;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.bstats.bukkit.Metrics;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;
import me.mrCookieSlime.Slimefun.cscorelib2.updater.GitHubBuildsUpdater;

public class DyedBackpacks extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Config cfg = new Config(this);
		new Metrics(this);
		
		if (cfg.getBoolean("options.auto-update") && getDescription().getVersion().startsWith("DEV - ")) {
			new GitHubBuildsUpdater(this, getFile(), "TheBusyBiscuit/DyedBackpacks/master").start();
		}
		
		Research research = new Research(17200, "Dyed Backpacks", 24);
		
		try {
			Category category = new Category(new CustomItem(CustomSkull.getItem(BackpackColor.RED.getTexture()), "&4Dyed Backpacks", "", "&a> Click to open"));
			
			if (cfg.getBoolean("backpacks.small")) createBackpacks(category, research, (SlimefunItemStack) SlimefunItems.BACKPACK_SMALL, 9);
			if (cfg.getBoolean("backpacks.normal")) createBackpacks(category, research, (SlimefunItemStack) SlimefunItems.BACKPACK_MEDIUM, 18);
			if (cfg.getBoolean("backpacks.large")) createBackpacks(category, research, (SlimefunItemStack) SlimefunItems.BACKPACK_LARGE, 27);
			if (cfg.getBoolean("backpacks.woven")) createBackpacks(category, research, (SlimefunItemStack) SlimefunItems.WOVEN_BACKPACK, 36);
			if (cfg.getBoolean("backpacks.gilded")) createBackpacks(category, research, (SlimefunItemStack) SlimefunItems.GILDED_BACKPACK, 45);
			if (cfg.getBoolean("backpacks.radiant")) createBackpacks(category, research, (SlimefunItemStack) SlimefunItems.RADIANT_BACKPACK, 54);
			
		} catch (Exception x) {
			getLogger().log(Level.SEVERE, "An Exception occured while enabling the Plugin DyedBackpacks v" + getDescription().getVersion(), x);
		}
		
		research.register();
	}

	private void createBackpacks(Category category, Research research, SlimefunItemStack backpack, int size) {
		for (BackpackColor color: BackpackColor.values()) {
			SlimefunItemStack item = new SlimefunItemStack("DYED_" + backpack.getItemID() + "_" + color.name(), color.getTexture(), backpack.getItemMeta().getDisplayName() + " &7(" + color.getName() + "&7)", backpack.getItemMeta().getLore().toArray(new String[0]));
			DyedBackpack dyed = new DyedBackpack(size, category, item, backpack, color);
			research.addItems(dyed);
			dyed.register();
		}
	}
}
