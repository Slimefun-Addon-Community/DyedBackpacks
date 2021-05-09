package io.github.thebusybiscuit.dyedbackpacks;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.items.backpacks.SlimefunBackpack;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class DyedBackpack extends SlimefunBackpack {

    @ParametersAreNonnullByDefault
    public DyedBackpack(int size, Category category, SlimefunItemStack item, SlimefunItemStack backpack, BackpackColor color) {
        super(size, category, item, RecipeType.ENHANCED_CRAFTING_TABLE, createRecipe(backpack, color));
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    private static ItemStack[] createRecipe(SlimefunItemStack backpack, BackpackColor color) {
        ItemStack wool = new ItemStack(color.getWoolMaterial());
        ItemStack leather = new ItemStack(Material.LEATHER);

        // @formatter:off
        return new ItemStack[] { 
            wool,    wool,     wool,
            leather, backpack, leather,
            wool,    wool,     wool
        };
        // @formatter:on
    }

}
