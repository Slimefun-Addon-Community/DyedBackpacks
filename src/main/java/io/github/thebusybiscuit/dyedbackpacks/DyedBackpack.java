package io.github.thebusybiscuit.dyedbackpacks;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.items.backpacks.SlimefunBackpack;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

/**
 * This is our {@link SlimefunItem} implementation for the {@link DyedBackpack}.
 * It extends {@link SlimefunBackpack} but also carries an additional {@link BackpackColor}
 * attribute.
 * 
 * @author TheBusyBiscuit
 *
 */
public class DyedBackpack extends SlimefunBackpack {

    private final BackpackColor color;

    @ParametersAreNonnullByDefault
    public DyedBackpack(int size, Category category, SlimefunItemStack item, SlimefunItemStack backpack, BackpackColor color) {
        super(size, category, item, RecipeType.ENHANCED_CRAFTING_TABLE, createRecipe(backpack, color));

        Validate.notNull(color, "Dyed Backpack colors cannot be null!");
        this.color = color;
    }

    /**
     * This returns the {@link BackpackColor} of this {@link DyedBackpack}.
     * 
     * @return The {@link BackpackColor}
     */
    @Nonnull
    public BackpackColor getColor() {
        return color;
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
