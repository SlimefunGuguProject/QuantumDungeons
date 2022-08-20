package io.github.schntgaispock.quantumdungeons.core.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import io.github.schntgaispock.quantumdungeons.util.ThemedItemStack;
import io.github.schntgaispock.quantumdungeons.util.QDTheme.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QDStacks {

    // ---- Guide Only ----
    
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
    
    public static final ItemStack GUIDE_ITEM_MAIN = new CustomItemStack(
        Material.CRACKED_STONE_BRICKS,
        Theme.DUNGEON.getColor() + "Quantum Dungeons"
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
        Material.GLASS,
        "&bBinding Glass",
        "&7This item is crafted via the Binding",
        "&7Glass"
    );

    public static final ItemStack RECIPE_MOULDING = new CustomItemStack(
        Material.CAULDRON,
        "&bCatalyst Mould",
        "&7This item is crafted in the Catalyst",
        "&7Mould"
    );
    
    public static final ItemStack RECIPE_LOOTING = new CustomItemStack(
        Material.CHEST,
        "&bLooting",
        "&7This item is obtained by looting",
        "&7chests in dungeons"
    );
    
    public static final ItemStack RECIPE_KILLING = new CustomItemStack(
        Material.CHEST,
        "&bMob Drop",
        "&7This item is obtained by killing",
        "&7the specified mob"
    );
    
    public static final ItemStack RECIPE_MENDING = new CustomItemStack(
        Material.SPYGLASS,
        "&bMending",
        "&7This item is obtained by mending a",
        "&7crack in a dungeon"
    );
    
    public static final ItemStack RECIPE_BOOSTING = new CustomItemStack(
        Material.NOTE_BLOCK,
        "&bBoosting",
        "&7This item is obtained by boosting",
        "&7a record in a Record Booster"
    );

    // ---- Materials & Tools ----
    
    public static final SlimefunItemStack FRACTURED_REALITY_SHARD = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "FRACTURED_REALITY_SHARD",
        Material.PRISMARINE_SHARD,
        "Fractured Reality Shard",
        "It trembles in your hand"
    );

    public static final SlimefunItemStack RECONSTRUCTED_REALITY_SHARD = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "RECONSTRUCTED_REALITY_SHARD",
        Material.PRISMARINE_SHARD,
        "Reconstructed Reality Shard",
        "It glistens like a kaleidoscope"
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
        Theme.DUNGEON,
        "DUNGEON_PORTAL_FRAME",
        Material.CRYING_OBSIDIAN,
        "Dungeon Portal Frame",
        "Place it two blocks away from",
        "a Dungeon Portal Mound"
    );

    public static final SlimefunItemStack DUNGEON_PORTAL_MOUND = ThemedItemStack.of(
        Theme.DUNGEON,
        "DUNGEON_PORTAL_MOUND",
        Material.RESPAWN_ANCHOR,
        "Dungeon Portal Mound",
        "Requires four Dungeon Portal",
        "Frames surrounding it"
    );

    // ---- Catalysts ----

    public static final SlimefunItemStack CATALYST_MOULD = ThemedItemStack.of(
        Theme.CATALYST,
        "CATALYST_MOULD",
        Material.CAULDRON,
        "Catalyst Mould",
        "Throw the ingredients inside",
        "and right-click with the catalyst"
    );

    public static final SlimefunItemStack BLANK_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "BLANK_DUNGEON_CATALYST",
        Material.GRAY_DYE,
        "Blank Catalyst",
        "Does nothing on its own..."
    );

    public static final SlimefunItemStack BASIC_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "BASIC_DUNGEON_CATALYST",
        Material.VINE,
        "Basic Dungeon Catalyst",
        "Key to the Basic Dungeon"
    );

    public static final SlimefunItemStack VIVACIOUS_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "VIVACIOUS_DUNGEON_CATALYST",
        Material.GLOW_BERRIES,
        "Vivacious Dungeon Catalyst",
        "Key to the Vivacious Dungeon"
    );

    public static final SlimefunItemStack TENEBROUS_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "TENEBROUS_DUNGEON_CATALYST",
        Material.ENDER_PEARL,
        "Tenebrous Dungeon Catalyst",
        "Key to the Tenebrous Dungeon"
    );

    public static final SlimefunItemStack ANCIENT_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "ANCIENT_DUNGEON_CATALYST",
        Material.SCULK_SENSOR,
        "Ancient Dungeon Catalyst",
        "Key to the Ancient Dungeon"
    );

    // ---- Records ----

    public static final SlimefunItemStack RECORD_PLAYER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_PLAYER",
        Material.JUKEBOX,
        "Record Player",
        "Brings out the thrilling sounds",
        "of a record"
    );

    public static final SlimefunItemStack RECORD_BOOSTER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_BOOSTER",
        Material.NOTE_BLOCK,
        "Record Booster",
        "Enhances the quality of",
        "a record",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerBuffer(8192),
        LoreBuilder.powerPerSecond(2048)
    );

    public static final SlimefunItemStack RECORD_OF_VALOR = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_VALOR",
        Material.MUSIC_DISC_13,
        "Record of Valor",
        "Evokes a feeling of bravery"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_VALOR_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_VALOR_BOOSTED",
        Material.MUSIC_DISC_13,
        "Record of Valor",
        "Evokes a strong feeling of bravery"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    public static final SlimefunItemStack RECORD_OF_AEGIS = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_AEGIS",
        Material.MUSIC_DISC_WAIT,
        "Record of Aegis",
        "Evokes a feeling of stolidity"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_AEGIS_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_AEGIS_BOOSTED",
        Material.MUSIC_DISC_WAIT,
        "Record of Aegis",
        "Evokes a strong feeling of stolidity"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    public static final SlimefunItemStack RECORD_OF_ORDER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_ORDER",
        Material.MUSIC_DISC_FAR,
        "Record of Order",
        "Evokes a feeling of peace"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_ORDER_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_ORDER_BOOSTED",
        Material.MUSIC_DISC_FAR,
        "Record of Order",
        "Evokes a strong feeling of peace"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    public static final SlimefunItemStack RECORD_OF_POWER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_POWER",
        Material.MUSIC_DISC_CHIRP,
        "Record of Power",
        "Evokes a feeling of strength"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_POWER_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_POWER_BOOSTED",
        Material.MUSIC_DISC_CHIRP,
        "Record of Power",
        "Evokes a strong feeling of strength"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    public static final SlimefunItemStack RECORD_OF_HASTE = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_HASTE",
        Material.MUSIC_DISC_STRAD,
        "Record of Haste",
        "Evokes a feeling of urgency"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_HASTE_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_HASTE_BOOSTED",
        Material.MUSIC_DISC_STRAD,
        "Record of Haste",
        "Evokes a strong feeling of urgency"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    // ---- Tokens ----

    public static final SlimefunItemStack BASIC_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "BASIC_DUNGEON_TOKEN",
        Material.FIREWORK_STAR,
        "Basic Dungeon Token",
        "A metal coin from the Basic",
        "Dungeon"
    ).glisten();

    public static final SlimefunItemStack VIVACIOUS_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "VIVACIOUS_DUNGEON_TOKEN",
        Material.FLOWERING_AZALEA,
        "Vivacious Dungeon Token",
        "A flowering branch from the",
        "Vivacious Dungeon"
    ).glisten();

    public static final SlimefunItemStack TENEBROUS_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "TENEBROUS_DUNGEON_TOKEN",
        Material.ENDER_EYE,
        "Tenebrous Dungeon Token",
        "A mysterious crystal from",
        "the Tenebrous Dungeon"
    ).glisten();

    public static final SlimefunItemStack ANCIENT_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "ANCIENT_DUNGEON_TOKEN",
        Material.ECHO_SHARD,
        "Ancient Dungeon Token",
        "A dusty relic from the Ancient",
        "Dungeon"
    ).glisten();

    // ---- Dusts ----

    public static final SlimefunItemStack EFFERVESCENT_DUST = ThemedItemStack.of(
        Theme.LIFE,
        "EFFERVESCENT_DUST",
        Material.GLOWSTONE_DUST,
        "Effervescent Dust",
        "Teeming with life"
    ).glisten();

    public static final SlimefunItemStack ENERVATED_DUST = ThemedItemStack.of(
        Theme.VOID,
        "ENERVATED_DUST",
        Material.GUNPOWDER,
        "Enervated Dust",
        "Drained of life"
    );

    public static final SlimefunItemStack EFFLUVIANT_DUST = ThemedItemStack.of(
        Theme.DUST,
        "EFFLUVIANT_DUST",
        Material.REDSTONE,
        "Effluviant Dust",
        "Abandoned for millennia"
    );


}
