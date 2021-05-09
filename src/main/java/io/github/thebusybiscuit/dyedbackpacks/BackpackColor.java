package io.github.thebusybiscuit.dyedbackpacks;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;

/**
 * This enum holds the different colors of a {@link DyedBackpack}.
 * It is similar to the {@link DyeColor} enum, as this is based off of the different colors
 * of wool.
 * 
 * @author TheBusyBiscuit
 * 
 * @see DyedBackpack
 * @see DyeColor
 *
 */
public enum BackpackColor {

    WHITE(ChatColor.WHITE + "White", Material.WHITE_WOOL, "ebdf8d53bdb932c223c627bbb8c1e0c5e351a616cd8056929c66e6dce44433db"),
    ORANGE(ChatColor.GOLD + "Orange", Material.ORANGE_WOOL, "a37a35522f67b2af92345592846b702b9afb9d7c8dbad5ea150673c9e44de3"),
    MAGENTA(ChatColor.LIGHT_PURPLE + "Magenta", Material.MAGENTA_WOOL, "36575fcccadae87c0842f53de5e0ffa75851696866d81e1b72828348db5256"),
    LIGHT_BLUE(ChatColor.AQUA + "Light Blue", Material.LIGHT_BLUE_WOOL, "a3c153c391c34e2d328a60839e683a9f82ad3048299d8bc6a39e6f915cc5a"),
    YELLOW(ChatColor.YELLOW + "Yellow", Material.YELLOW_WOOL, "a254aacbf623175ff98df7ae366e0b89e91713441752f3cdf965f038b174b5"),
    LIME(ChatColor.GREEN + "Lime", Material.LIME_WOOL, "a9909a9779b946b9787442fa483af4de4b2f19fd40dc2370f7a9b8f521f21ddc"),
    PINK(ChatColor.LIGHT_PURPLE + "Pink", Material.PINK_WOOL, "bddafdcb1a8df426229d7879b1e4a336fc9ab3bdc146bb4ed3be4bbf7b5b835"),
    DARK_GRAY(ChatColor.DARK_GRAY + "Dark Gray", Material.GRAY_WOOL, "6536ad978e1ce5050f43b7a6b3859eb49406b4f1043802a711cdc80c090c35d"),
    LIGHT_GRAY(ChatColor.GRAY + "Light Gray", Material.LIGHT_GRAY_WOOL, "5a5fc7635296ca183fd30b0fb5f4c18cfc216768f0fbebb865e0211ab43b7b"),
    CYAN(ChatColor.DARK_AQUA + "Cyan", Material.CYAN_WOOL, "df70fab3246fe027ce0bba885a73c6e82d8ff8f358231e8461f956560cfa58f"),
    PURPLE(ChatColor.DARK_PURPLE + "Purple", Material.PURPLE_WOOL, "5eb65bbe744945841e9234a33b5ce5cc236f6a2fc93a1a3ae42df77c9084df1e"),
    BLUE(ChatColor.DARK_BLUE + "Blue", Material.BLUE_WOOL, "8224b2c7391eb5bfcb278431d5c827cb26349526c7bc535b1e95f6df9f3fdf3"),
    BROWN(ChatColor.GOLD + "Brown", Material.BROWN_WOOL, "efb6a3d7dba97bb6e7f79a15627aec6369791233f833fa749ef21bed79e59e98"),
    GREEN(ChatColor.DARK_GREEN + "Green", Material.GREEN_WOOL, "28a127f1cfd79986e7bd95d92de4f4f68040e4f899f81b1f8f3ca15b64f50f3"),
    RED(ChatColor.DARK_RED + "Red", Material.RED_WOOL, "85e4f9da68c81fa481eecdca48a138cecde2cddffeeae84ab1afd24a363e028"),
    BLACK(ChatColor.DARK_GRAY + "Black", Material.BLACK_WOOL, "a9ab1fdcbe878d1e55bdd43cebc5e43836a6da69541f4a233fe88f1305668");

    private final String name;
    private final Material wool;
    private final String texture;

    @ParametersAreNonnullByDefault
    BackpackColor(String name, Material wool, String texture) {
        this.name = name;
        this.wool = wool;
        this.texture = texture;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public String getTexture() {
        return texture;
    }

    @Nonnull
    public Material getWoolMaterial() {
        return wool;
    }

}
