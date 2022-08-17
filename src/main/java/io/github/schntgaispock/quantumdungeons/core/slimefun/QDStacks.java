package io.github.schntgaispock.quantumdungeons.core.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.quantumdungeons.util.ThemedItemStack;
import io.github.schntgaispock.quantumdungeons.util.QDTheme.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QDStacks {

    // ---- Guide Only ----
    
    public static final ItemStack GUIDE_ITEM_MAIN = new CustomItemStack(
        Material.CRACKED_STONE_BRICKS,
        Theme.DUNGEON.getColor() + "Quantum Dungeons"
    );
    
    public static final ItemStack GUIDE_ITEM_MATERIALS = new CustomItemStack(
        Material.PRISMARINE_SHARD,
        Theme.DIMENSIONAL.getColor() + "Materials"
    );
    
    public static final ItemStack GUIDE_ITEM_TOOLS = new CustomItemStack(
        Material.SPYGLASS,
        Theme.DIMENSIONAL.getColor() + "Tools"
    );
    
    public static final ItemStack GUIDE_ITEM_CATALYSTS = new CustomItemStack(
        Material.GRAY_DYE,
        Theme.CATALYST.getColor() + "Catalysts"
    );
    
    public static final ItemStack GUIDE_ITEM_RECORDS = new CustomItemStack(
        Material.MUSIC_DISC_CHIRP,
        Theme.RECORD.getColor() + "Records"
    );
    
    public static final ItemStack GUIDE_ITEM_DUNGEON = new CustomItemStack(
        Material.MOSSY_STONE_BRICKS,
        Theme.DUNGEON.getColor() + "Dungeon Items"
    );
    
    public static final ItemStack GUIDE_ITEM_HIDDEN = new CustomItemStack(
        Material.BARRIER,
        "This should never be shown"
    );

    public static final ItemStack GUIDE_VOIDAL = new CustomItemStack(
        Material.ENDERMAN_SPAWN_EGG,
        Theme.VOID.getColor() + "Voidal"
    );

    public static final ItemStack GUIDE_ANY_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "Dungeon Chest",
        "&7Any"
    );

    public static final ItemStack GUIDE_BASIC_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "Dungeon Chest",
        "&7Basic"
    );

    public static final ItemStack GUIDE_VIVACIOUS_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "Dungeon Chest",
        "&7Vivacious"
    );

    public static final ItemStack GUIDE_TENEBROUS_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "Dungeon Chest",
        "&7Tenebrous"
    );

    public static final ItemStack GUIDE_ANCIENT_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "Dungeon Chest",
        "&7Ancient"
    );

    public static final ItemStack GUIDE_NORMAL_FRACTURE = new CustomItemStack(
        Material.WHITE_STAINED_GLASS_PANE,
        Theme.DUNGEON.getColor() + "Normal Fracture"
    );

    public static final ItemStack GUIDE_ROCKY_FRACTURE = new CustomItemStack(
        Material.LIGHT_GRAY_STAINED_GLASS_PANE,
        Theme.DUST.getColor() + "Rocky Fracture"
    );

    public static final ItemStack GUIDE_ORGANIC_FRACTURE = new CustomItemStack(
        Material.GREEN_STAINED_GLASS_PANE,
        Theme.LIFE.getColor() + "Organic Fracture"
    );

    public static final ItemStack GUIDE_VOID_FRACTURE = new CustomItemStack(
        Material.PURPLE_STAINED_GLASS_PANE,
        Theme.VOID.getColor() + "Void Fracture"
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
        "&7chests in dungeons"
    );
    
    public static final ItemStack RECIPE_MENDING = new CustomItemStack(
        Material.MOSSY_STONE_BRICKS,
        "&bKilling",
        "",
        "&7This item is obtained by mending a",
        "&7crack in a dungeon"
    );
    
    public static final ItemStack RECIPE_BOOSTING = new CustomItemStack(
        Material.MOSSY_STONE_BRICKS,
        "&bLooting",
        "",
        "&7This item is obtained by boosting",
        "&7a record in a Record Booster"
    );

    // ---- Materials & Tools ----
    
    public static final SlimefunItemStack FRACTURED_REALITY_SHARD = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "FRACTURED_REALITY_SHARD",
        Material.PRISMARINE_SHARD,
        "Fractured Reality Shard",
        ""
    );

    public static final SlimefunItemStack RECONSTRUCTED_REALITY_SHARD = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "RECONSTRUCTED_REALITY_SHARD",
        Material.PRISMARINE_SHARD,
        "Reconstructed Reality Shard",
        ""
    )
    .glisten();

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

    public static final SlimefunItemStack DUNGEON_PORTAL_FRAME = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "DUNGEON_PORTAL_FRAME",
        Material.CRYING_OBSIDIAN,
        "Dungeon Portal Frame",
        ""
    );

    public static final SlimefunItemStack DUNGEON_PORTAL_SWITCH = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "DUNGEON_PORTAL_SWITCH",
        Material.RESPAWN_ANCHOR,
        "Portal Switch",
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

    public static final SlimefunItemStack BLANK_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "BLANK_CATALYST",
        Material.GRAY_DYE,
        "Blank Catalyst",
        ""
    );

    public static final SlimefunItemStack BASIC_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "BASIC_DUNGEON_CATALYST",
        Material.VINE,
        "Basic Dungeon Catalyst",
        ""
    );

    public static final SlimefunItemStack VIVACIOUS_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "VIVACIOUS_DUNGEON_CATALYST",
        Material.GLOW_BERRIES,
        "Vivacious Dungeon Catalyst",
        ""
    );

    public static final SlimefunItemStack TENEBROUS_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "TENEBROUS_DUNGEON_CATALYST",
        Material.ENDER_PEARL,
        "Tenebrous Dungeon Catalyst",
        ""
    );

    public static final SlimefunItemStack ANCIENT_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "ANCIENT_DUNGEON_CATALYST",
        Material.SCULK_SENSOR,
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

    public static final SlimefunItemStack RECORD_OF_VALOR_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_VALOR_BOOSTED",
        Material.MUSIC_DISC_13,
        "Record of Valor",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES).glisten();

    public static final SlimefunItemStack RECORD_OF_AEGIS = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_AEGIS",
        Material.MUSIC_DISC_WAIT,
        "Record of Aegis",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack RECORD_OF_AEGIS_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_AEGIS_BOOSTED",
        Material.MUSIC_DISC_WAIT,
        "Record of Aegis",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES).glisten();

    public static final SlimefunItemStack RECORD_OF_ORDER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_ORDER",
        Material.MUSIC_DISC_FAR,
        "Record of Order",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack RECORD_OF_ORDER_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_ORDER_BOOSTED",
        Material.MUSIC_DISC_FAR,
        "Record of Order",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES).glisten();

    public static final SlimefunItemStack RECORD_OF_POWER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_POWER",
        Material.MUSIC_DISC_CHIRP,
        "Record of Power",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack RECORD_OF_POWER_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_POWER_BOOSTED",
        Material.MUSIC_DISC_CHIRP,
        "Record of Power",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES).glisten();

    public static final SlimefunItemStack RECORD_OF_HASTE = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_HASTE",
        Material.MUSIC_DISC_STRAD,
        "Record of Haste",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES);

    public static final SlimefunItemStack RECORD_OF_HASTE_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_HASTE_BOOSTED",
        Material.MUSIC_DISC_STRAD,
        "Record of Haste",
        ""
    ).addFlags(ItemFlag.HIDE_ATTRIBUTES).glisten();

    // ---- Tokens ----

    public static final SlimefunItemStack BASIC_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "BASIC_DUNGEON_TOKEN",
        Material.FIREWORK_STAR,
        "Basic Dungeon Token",
        ""
    ).glisten();

    public static final SlimefunItemStack VIVACIOUS_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "ANCIENT_DUNGEON_TOKEN",
        Material.FLOWERING_AZALEA,
        "Ancient Dungeon Token",
        ""
    ).glisten();

    public static final SlimefunItemStack TENEBROUS_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "ANCIENT_DUNGEON_TOKEN",
        Material.ENDER_EYE,
        "Ancient Dungeon Token",
        ""
    ).glisten();

    public static final SlimefunItemStack ANCIENT_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "ANCIENT_DUNGEON_TOKEN",
        Material.ECHO_SHARD,
        "Ancient Dungeon Token",
        ""
    ).glisten();

    // ---- Dusts ----

    public static final SlimefunItemStack EFFERVESCENT_DUST = ThemedItemStack.of(
        Theme.LIFE,
        "EFFERVESCENT_DUST",
        Material.GLOWSTONE,
        "Effervescent Dust",
        ""
    ).glisten();

    public static final SlimefunItemStack ENERVATED_DUST = ThemedItemStack.of(
        Theme.VOID,
        "ENERVATED_DUST",
        Material.GUNPOWDER,
        "Enervated Dust",
        ""
    );

    public static final SlimefunItemStack EFFLUVIANT_DUST = ThemedItemStack.of(
        Theme.DUST,
        "EFFLUVIANT_DUST",
        Material.REDSTONE,
        "Effluviant Dust",
        ""
    );


}
