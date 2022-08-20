package io.github.schntgaispock.quantumdungeons.core.setup;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDGroups;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDRecipes;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDStacks;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDRecipes.QDRecipeType;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.catalysts.Catalyst;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.catalysts.CatalystMould;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.dungeon.DungeonDust;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.dungeon.DungeonToken;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.materials.DungeonPortalFrame;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.materials.DungeonPortalMound;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.records.Record;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.records.RecordBooster;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.records.RecordPlayer;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QDItemSetup {

    public static void setup() {

        QuantumDungeons qd = QuantumDungeons.getInstance();

        QDGroups.MAIN.register(qd);

        // ---- Vanilla Ingredients ----

        final ItemStack CRYING_OBSIDIAN = new ItemStack(Material.CRYING_OBSIDIAN);
        final ItemStack GLOWSTONE = new ItemStack(Material.GLOWSTONE);
        final ItemStack GLASS = new ItemStack(Material.GLASS);
        final ItemStack NETHER_STAR = new ItemStack(Material.NETHER_STAR);
        final ItemStack AMETHYST_SHARD = new ItemStack(Material.AMETHYST_SHARD);
        final ItemStack COPPER_INGOT = new ItemStack(Material.COPPER_INGOT);
        final ItemStack QUARTZ = new ItemStack(Material.QUARTZ);
        final ItemStack LAPIS_LAZULI = new ItemStack(Material.LAPIS_LAZULI);
        final ItemStack JUKEBOX = new ItemStack(Material.JUKEBOX);
        final ItemStack NOTE_BLOCK = new ItemStack(Material.NOTE_BLOCK);
        final ItemStack SMOOTH_STONE_SLAB = new ItemStack(Material.SMOOTH_STONE_SLAB);

        // ---- Materials ----

        new SlimefunItem(
            QDGroups.MATERIALS,
            QDStacks.FRACTURED_REALITY_SHARD,
            RecipeType.MOB_DROP,
            QDRecipes.single(QDStacks.GUIDE_VOIDAL)
        ).register(qd);

        new SlimefunItem(
            QDGroups.MATERIALS,
            QDStacks.RECONSTRUCTED_REALITY_SHARD,
            QDRecipeType.REFLECTING,
            QDRecipes.single(QDStacks.FRACTURED_REALITY_SHARD)
        ).register(qd);

        new DungeonPortalFrame(
            QDGroups.MATERIALS,
            QDStacks.DUNGEON_PORTAL_FRAME,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            QDRecipes.cyclicAlternating(CRYING_OBSIDIAN, QDStacks.RECONSTRUCTED_REALITY_SHARD, SlimefunItems.ANCIENT_PEDESTAL)
        ).register(qd);

        new DungeonPortalMound(
            QDGroups.MATERIALS,
            QDStacks.DUNGEON_PORTAL_MOUND,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            QDRecipes.cyclicAlternating(CRYING_OBSIDIAN, QDStacks.RECONSTRUCTED_REALITY_SHARD, GLOWSTONE)
        ).register(qd);

        // ---- Tools ----

        new SlimefunItem(
            QDGroups.TOOLS,
            QDStacks.BINDING_GLASS,
            QDRecipeType.ENHANCED_CRAFTING_TABLE,
            QDRecipes.cyclic(GLASS, NETHER_STAR)
        ).register(qd);

        new SlimefunItem(
            QDGroups.TOOLS,
            QDStacks.MENDING_GLASS,
            QDRecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                QDStacks.BINDING_GLASS,
                AMETHYST_SHARD,
                QDStacks.BINDING_GLASS, 
                null,
                COPPER_INGOT,
                null,
                null,
                COPPER_INGOT,
                null,

            }
        ).register(qd);

        // ---- Catalysts ----

        new CatalystMould(
            QDGroups.CATALYSTS,
            QDStacks.CATALYST_MOULD,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                SlimefunItems.REINFORCED_ALLOY_INGOT,
                null,
                SlimefunItems.REINFORCED_ALLOY_INGOT,
                SlimefunItems.REINFORCED_ALLOY_INGOT,
                null,
                SlimefunItems.REINFORCED_ALLOY_INGOT,
                SMOOTH_STONE_SLAB,
                SMOOTH_STONE_SLAB,
                SMOOTH_STONE_SLAB,
            }
        ).register(qd);

        new SlimefunItem(
            QDGroups.CATALYSTS,
            QDStacks.BLANK_DUNGEON_CATALYST,
            RecipeType.ANCIENT_ALTAR,
            new ItemStack[] {
                QUARTZ,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                LAPIS_LAZULI,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                SlimefunItems.BLANK_RUNE,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                LAPIS_LAZULI,
                QDStacks.RECONSTRUCTED_REALITY_SHARD,
                QUARTZ
            }
        ).register(qd);

        new Catalyst(
            QDGroups.CATALYSTS,
            QDStacks.BASIC_DUNGEON_CATALYST,
            QDRecipeType.MOULDING,
            QDRecipes.catalyst(
                new ItemStack(Material.RED_MUSHROOM, 8),
                new ItemStack(Material.BROWN_MUSHROOM, 8),
                new ItemStack(Material.MOSSY_STONE_BRICKS, 32),
                new ItemStack(Material.MOSS_BLOCK, 32)
            )
        ).register(qd);

        // Will be added once I finish their corresponding dungeons

        new Catalyst(
            QDGroups.CATALYSTS,
            QDStacks.VIVACIOUS_DUNGEON_CATALYST,
            QDRecipeType.MOULDING,
            QDRecipes.catalyst(
                QDStacks.EFFERVESCENT_DUST,
                new ItemStack(Material.GLOW_BERRIES, 16),
                new ItemStack(Material.FLOWERING_AZALEA, 16),
                new ItemStack(Material.MOSS_BLOCK, 64),
                new ItemStack(Material.OAK_LOG, 64),
                new ItemStack(Material.CLAY, 64)
            )
        ).register(qd);

        new Catalyst(
            QDGroups.CATALYSTS,
            QDStacks.TENEBROUS_DUNGEON_CATALYST,
            QDRecipeType.MOULDING,
            QDRecipes.catalyst(
                QDStacks.ENERVATED_DUST,
                new ItemStack(Material.ENDER_PEARL, 16),
                new ItemStack(Material.ENDER_EYE, 16),
                new ItemStack(Material.CRYING_OBSIDIAN, 64),
                new ItemStack(Material.END_STONE_BRICKS, 64),
                new ItemStack(Material.PURPUR_BLOCK, 64)
            )
        ).register(qd);

        new Catalyst(
            QDGroups.CATALYSTS,
            QDStacks.ANCIENT_DUNGEON_CATALYST,
            QDRecipeType.MOULDING,
            QDRecipes.catalyst(
                QDStacks.EFFLUVIANT_DUST,
                new ItemStack(Material.SCULK_SENSOR, 16),
                new ItemStack(Material.TWISTING_VINES, 16),
                new ItemStack(Material.SCULK, 64),
                new ItemStack(Material.DEEPSLATE_BRICKS, 64),
                new ItemStack(Material.WARPED_WART_BLOCK, 64)
            )
        ).register(qd);

        // ---- Records ----

        new RecordPlayer(
            QDGroups.RECORDS,
            QDStacks.RECORD_PLAYER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            QDRecipes.cyclicAlternating(SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.PLASTIC_SHEET, JUKEBOX)
        ).register(qd);

        new RecordBooster(
            QDGroups.RECORDS,
            QDStacks.RECORD_BOOSTER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            QDRecipes.cyclicAlternating(SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.PLASTIC_SHEET, NOTE_BLOCK)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_VALOR,
            QDRecipeType.LOOTING,
            QDRecipes.single(QDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10*60, 0),
            new PotionEffect(PotionEffectType.REGENERATION, 10*60, 0),
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10*60, 0),
            new PotionEffect(PotionEffectType.SPEED, 10*60, 0)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_VALOR_BOOSTED,
            QDRecipeType.BOOSTING,
            QDRecipes.single(QDStacks.RECORD_OF_VALOR),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 15*60, 1),
            new PotionEffect(PotionEffectType.REGENERATION, 15*60, 1),
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 15*60, 1),
            new PotionEffect(PotionEffectType.SPEED, 15*60, 1)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_AEGIS,
            QDRecipeType.LOOTING,
            QDRecipes.single(QDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10*60, 2)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_AEGIS_BOOSTED,
            QDRecipeType.BOOSTING,
            QDRecipes.single(QDStacks.RECORD_OF_AEGIS),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 15*60, 3)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_ORDER,
            QDRecipeType.LOOTING,
            QDRecipes.single(QDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.REGENERATION, 10*60, 2)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_ORDER_BOOSTED,
            QDRecipeType.BOOSTING,
            QDRecipes.single(QDStacks.RECORD_OF_ORDER),
            new PotionEffect(PotionEffectType.REGENERATION, 15*60, 3)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_POWER,
            QDRecipeType.LOOTING,
            QDRecipes.single(QDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10*60, 2)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_POWER_BOOSTED,
            QDRecipeType.BOOSTING,
            QDRecipes.single(QDStacks.RECORD_OF_POWER),
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 15*60, 3)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_HASTE,
            QDRecipeType.LOOTING,
            QDRecipes.single(QDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.SPEED, 10*60, 2)
        ).register(qd);

        new Record(
            QDStacks.RECORD_OF_HASTE_BOOSTED,
            QDRecipeType.BOOSTING,
            QDRecipes.single(QDStacks.RECORD_OF_HASTE),
            new PotionEffect(PotionEffectType.SPEED, 15*60, 3)
        ).register(qd);

        // ---- Tokens ----

        new DungeonToken(
            QDGroups.DUNGEON,
            QDStacks.BASIC_DUNGEON_TOKEN,
            QDRecipeType.LOOTING,
            QDRecipes.single(QDStacks.GUIDE_BASIC_CHEST)
        ).register(qd);

        new DungeonToken(
            QDGroups.DUNGEON,
            QDStacks.VIVACIOUS_DUNGEON_TOKEN,
            QDRecipeType.LOOTING,
            QDRecipes.single(QDStacks.GUIDE_VIVACIOUS_CHEST)
        ).register(qd);

        new DungeonToken(
            QDGroups.DUNGEON,
            QDStacks.TENEBROUS_DUNGEON_TOKEN,
            QDRecipeType.LOOTING,
            QDRecipes.single(QDStacks.GUIDE_TENEBROUS_CHEST)
        ).register(qd);

        new DungeonToken(
            QDGroups.DUNGEON,
            QDStacks.ANCIENT_DUNGEON_TOKEN,
            QDRecipeType.LOOTING,
            QDRecipes.single(QDStacks.GUIDE_ANCIENT_CHEST)
        ).register(qd);

        // ---- Dusts ----

        new DungeonDust(
            QDGroups.DUNGEON,
            QDStacks.EFFERVESCENT_DUST,
            QDRecipeType.MENDING,
            QDRecipes.single(QDStacks.GUIDE_ORGANIC_FRACTURE)
        ).register(qd);

        new DungeonDust(
            QDGroups.DUNGEON,
            QDStacks.ENERVATED_DUST,
            QDRecipeType.MENDING,
            QDRecipes.single(QDStacks.GUIDE_VOID_FRACTURE)
        ).register(qd);

        new DungeonDust(
            QDGroups.DUNGEON,
            QDStacks.EFFLUVIANT_DUST,
            QDRecipeType.MENDING,
            QDRecipes.single(QDStacks.GUIDE_ROCKY_FRACTURE)
        ).register(qd);

    }

}
