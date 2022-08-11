package io.github.schntgaispock.quantumdungeons.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.quantumdungeons.theme.ThemedItemStack;
import io.github.schntgaispock.quantumdungeons.theme.QDTheme.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class QDStacks {

    // ---- Guide Only ----
    
    public static final ItemStack GUIDE_ITEM = new CustomItemStack(
        Material.MOSSY_STONE_BRICKS,
        Theme.DIMENSIONAL.getColor() + "Quantum Dungeons"
    );

    public static final ItemStack GUIDE_VOIDAL = new CustomItemStack(
        Material.ENDERMAN_SPAWN_EGG,
        Theme.DIMENSIONAL.getColor() + "Voidal"
    );

    public static final ItemStack RECIPE_REFLECTING = new CustomItemStack(
        Material.MOSSY_STONE_BRICKS,
        "&bBinding Glass",
        "",
        "&7This item is crafted via the Binding",
        "&7Glass"
    );

    public static final ItemStack RECIPE_MOULDING = new CustomItemStack(
        Material.MOSSY_STONE_BRICKS,
        "&bCatalyst Mould",
        "",
        "&7This item is crafted in the Catalyst",
        "&7Mould"
    );
    
    public static final ItemStack RECIPE_KILLING = new CustomItemStack(
        Material.MOSSY_STONE_BRICKS,
        "&bKilling",
        "",
        "&7This item is obtained by killing the",
        "&7specified mob"
    );
    
    public static final ItemStack RECIPE_LOOTING = new CustomItemStack(
        Material.MOSSY_STONE_BRICKS,
        "&bLooting",
        "",
        "&7This item is obtained by looting",
        "&7quantum dungeon chests"
    );

    // ---- Materials & Tools ----
    
    public static final SlimefunItemStack FRACTURED_REALITY_SHARD = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "FRACTURED_REALITY_SHARD",
        Material.PRISMARINE_SHARD,
        "Fractured Reality Shard",
        ""
    );

    public static final SlimefunItemStack BINDING_GLASS = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "BINDING_GLASS",
        Material.GLASS,
        "Binding Glass",
        "Reflects a fractured reality shard",
        "upon itself to repair it."
    );

    public static final SlimefunItemStack MENDING_GLASS = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "MENDING_GLASS",
        Material.SPYGLASS,
        "Mending Glass",
        "Can mend fractures in reality itself"
    );

    public static final SlimefunItemStack RECONSTRUCTED_REALITY_SHARD = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "RECONSTRUCTED_REALITY_SHARD",
        Material.PRISMARINE_SHARD,
        "Reconstructed Reality Shard",
        ""
    )
    .glisten();

    public static final SlimefunItemStack DUNGEON_PORTAL_FRAME = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "DUNGEON_PORTAL_FRAME",
        Material.RESPAWN_ANCHOR,
        "Dungeon Portal Frame",
        ""
    );

    // ---- Catalysts ----

    public static final SlimefunItemStack CATALYST_MOULD = ThemedItemStack.of(
        Theme.CATALYST,
        "CATALYST_MOULD",
        Material.CAULDRON,
        "Catalyst Mould",
        ""
    );

    public static final SlimefunItemStack BLANK_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "BLANK_CATALYST",
        Material.GRAY_DYE,
        "Blank Catalyst",
        ""
    );

    public static final SlimefunItemStack BASIC_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "BASIC_DUNGEON_CATALYST",
        Material.DIAMOND,
        "Basic Dungeon Catalyst",
        ""
    );

    public static final SlimefunItemStack ANCIENT_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "ANCIENT_DUNGEON_CATALYST",
        Material.ENDER_PEARL,
        "Ancient Dungeon Catalyst",
        ""
    );

    // ---- Records ----

    public static final SlimefunItemStack RECORD_PLAYER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_PLAYER",
        Material.JUKEBOX,
        "Record Player",
        ""
    );

    public static final SlimefunItemStack RECORD_BOOSTER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_BOOSTER",
        Material.NOTE_BLOCK,
        "Record Booster",
        "Brings out the sound of the record."
    );

    public static final SlimefunItemStack RECORD_OF_VALOR = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_VALOR",
        Material.MUSIC_DISC_13,
        "Record of Valor",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack RECORD_OF_AEGIS = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_AEGIS",
        Material.MUSIC_DISC_WAIT,
        "Record of Aegis",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack RECORD_OF_ORDER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_ORDER",
        Material.MUSIC_DISC_FAR,
        "Record of Order",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack RECORD_OF_POWER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_POWER",
        Material.MUSIC_DISC_CHIRP,
        "Record of Power",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack RECORD_OF_HASTE = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_HASTE",
        Material.MUSIC_DISC_STRAD,
        "Record of Haste",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    // ---- Tokens ----

    public static final SlimefunItemStack BASIC_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "BASIC_DUNGEON_TOKEN",
        Material.FIREWORK_STAR,
        "Basic Dungeon Token",
        ""
    ).glisten();

    public static final SlimefunItemStack ANCIENT_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "ANCIENT_DUNGEON_TOKEN",
        Material.SUNFLOWER,
        "Ancient Dungeon Token",
        ""
    ).glisten();

    // ---- Shards ----

    public static final SlimefunItemStack EFFERVESCENT_SHARD = ThemedItemStack.of(
        Theme.LIFE,
        "EFFERVESCENT_SHARD",
        Material.GREEN_DYE,
        "Effervescent Shard",
        ""
    ).glisten();

    public static final SlimefunItemStack ENERVATED_SHARD = ThemedItemStack.of(
        Theme.VOID,
        "ENERVATED_SHARD",
        Material.BLACK_DYE,
        "Enervated Shard",
        ""
    );

    public static final SlimefunItemStack EFFLUVIANT_SHARD = ThemedItemStack.of(
        Theme.DUST,
        "EFFLUVIANT_SHARD",
        Material.LIGHT_GRAY_DYE,
        "Effluviant Shard",
        ""
    );


}
