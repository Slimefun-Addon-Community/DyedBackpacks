package io.github.thebusybiscuit.dyedbackpacks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.items.backpacks.SlimefunBackpack;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.materials.MaterialCollections;

public class DyedBackpack extends SlimefunBackpack {

    public DyedBackpack(int size, Category category, SlimefunItemStack item, SlimefunItemStack backpack, BackpackColor color) {
        super(size, category, item, RecipeType.ENHANCED_CRAFTING_TABLE, createRecipe(backpack, color));
    }

    private static ItemStack[] createRecipe(SlimefunItemStack backpack, BackpackColor color) {
        ItemStack wool = new ItemStack(MaterialCollections.getAllWoolColors().get(color.ordinal()));

        return new ItemStack[] { wool, wool, wool, new ItemStack(Material.LEATHER), backpack, new ItemStack(Material.LEATHER), wool, wool, wool };
    }

}
