package io.github.schntgaispock.strophodungeons.core.setup;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.schntgaispock.strophodungeons.Strophodungeons;
import io.github.schntgaispock.strophodungeons.core.slimefun.SDGroups;
import io.github.schntgaispock.strophodungeons.core.slimefun.SDRecipes;
import io.github.schntgaispock.strophodungeons.core.slimefun.SDStacks;
import io.github.schntgaispock.strophodungeons.core.slimefun.SDRecipes.SDRecipeType;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.catalysts.Catalyst;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.catalysts.CatalystMould;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.dungeon.DungeonDust;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.dungeon.DungeonToken;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.materials.DungeonPortalFrame;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.materials.DungeonPortalMound;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.records.Record;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.records.RecordBooster;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.records.RecordPlayer;
import io.github.schntgaispock.strophodungeons.core.slimefun.recipes.CatalystMouldRecipe;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SDItemSetup {

    public static void setup() {

        Strophodungeons sd = Strophodungeons.getInstance();
        if (sd == null) return;

        SDGroups.MAIN.register(sd);

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

        // ---- Recipes ----

        Map<String, CatalystMouldRecipe> catalystMouldRecipes = CatalystMouldRecipe.getRecipes();
        
        catalystMouldRecipes.put("BASIC_DUNGEON_CATALYST", new CatalystMouldRecipe(
            new ItemStack[] {
                new ItemStack(Material.RED_MUSHROOM, 8),
                new ItemStack(Material.BROWN_MUSHROOM, 8),
                new ItemStack(Material.MOSSY_STONE_BRICKS, 32),
                new ItemStack(Material.MOSS_BLOCK, 32)
            },
            new ItemStack[] {
                SDStacks.BASIC_DUNGEON_CATALYST
            }
        ));
        catalystMouldRecipes.put("VIVACIOUS_DUNGEON_CATALYST", new CatalystMouldRecipe(
            new ItemStack[] {
                SDStacks.ENERVATED_DUST,
                new ItemStack(Material.ENDER_PEARL, 16),
                new ItemStack(Material.ENDER_EYE, 16),
                new ItemStack(Material.CRYING_OBSIDIAN, 64),
                new ItemStack(Material.END_STONE_BRICKS, 64),
                new ItemStack(Material.PURPUR_BLOCK, 64)
            },
            new ItemStack[] {
                SDStacks.VIVACIOUS_DUNGEON_CATALYST
            }
        ));
        catalystMouldRecipes.put("TENEBROUS_DUNGEON_CATALYST", new CatalystMouldRecipe(
            new ItemStack[] {
                SDStacks.EFFERVESCENT_DUST,
                new ItemStack(Material.GLOW_BERRIES, 16),
                new ItemStack(Material.FLOWERING_AZALEA, 16),
                new ItemStack(Material.MOSS_BLOCK, 64),
                new ItemStack(Material.OAK_LOG, 64),
                new ItemStack(Material.CLAY, 64)
            },
            new ItemStack[] {
                SDStacks.TENEBROUS_DUNGEON_CATALYST
            }
        ));
        catalystMouldRecipes.put("ANCIENT_DUNGEON_CATALYST", new CatalystMouldRecipe(
            new ItemStack[] {
                SDStacks.EFFLUVIANT_DUST,
                new ItemStack(Material.SCULK_SENSOR, 16),
                new ItemStack(Material.TWISTING_VINES, 16),
                new ItemStack(Material.SCULK, 64),
                new ItemStack(Material.DEEPSLATE_BRICKS, 64),
                new ItemStack(Material.WARPED_WART_BLOCK, 64)
            },
            new ItemStack[] {
                SDStacks.ANCIENT_DUNGEON_CATALYST
            }
        ));

        // ---- Materials ----

        new SlimefunItem(
            SDGroups.MATERIALS,
            SDStacks.FRACTURED_REALITY_SHARD,
            SDRecipeType.KILLING,
            SDRecipes.single(SDStacks.GUIDE_VOIDAL)
        ).register(sd);

        new SlimefunItem(
            SDGroups.MATERIALS,
            SDStacks.RECONSTRUCTED_REALITY_SHARD,
            SDRecipeType.REFLECTING,
            SDRecipes.single(SDStacks.FRACTURED_REALITY_SHARD)
        ).register(sd);

        new DungeonPortalFrame(
            SDGroups.MATERIALS,
            SDStacks.DUNGEON_PORTAL_FRAME,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            SDRecipes.cyclicAlternating(CRYING_OBSIDIAN, SDStacks.RECONSTRUCTED_REALITY_SHARD, SlimefunItems.ANCIENT_PEDESTAL)
        ).register(sd);

        new DungeonPortalMound(
            SDGroups.MATERIALS,
            SDStacks.DUNGEON_PORTAL_MOUND,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            SDRecipes.cyclicAlternating(CRYING_OBSIDIAN, SDStacks.RECONSTRUCTED_REALITY_SHARD, GLOWSTONE)
        ).register(sd);

        // ---- Tools ----

        new SlimefunItem(
            SDGroups.TOOLS,
            SDStacks.BINDING_GLASS,
            SDRecipeType.ENHANCED_CRAFTING_TABLE,
            SDRecipes.cyclic(GLASS, NETHER_STAR)
        ).register(sd);

        new SlimefunItem(
            SDGroups.TOOLS,
            SDStacks.MENDING_GLASS,
            SDRecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                SDStacks.BINDING_GLASS,
                AMETHYST_SHARD,
                SDStacks.BINDING_GLASS, 
                null,
                COPPER_INGOT,
                null,
                null,
                COPPER_INGOT,
                null,

            }
        ).register(sd);

        // ---- Catalysts ----

        new CatalystMould(
            SDGroups.CATALYSTS,
            SDStacks.CATALYST_MOULD,
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
        ).register(sd);

        new SlimefunItem(
            SDGroups.CATALYSTS,
            SDStacks.BLANK_DUNGEON_CATALYST,
            RecipeType.ANCIENT_ALTAR,
            new ItemStack[] {
                QUARTZ,
                SDStacks.RECONSTRUCTED_REALITY_SHARD,
                LAPIS_LAZULI,
                SDStacks.RECONSTRUCTED_REALITY_SHARD,
                SlimefunItems.BLANK_RUNE,
                SDStacks.RECONSTRUCTED_REALITY_SHARD,
                LAPIS_LAZULI,
                SDStacks.RECONSTRUCTED_REALITY_SHARD,
                QUARTZ
            }
        ).register(sd);

        new Catalyst(
            SDGroups.CATALYSTS,
            SDStacks.BASIC_DUNGEON_CATALYST,
            SDRecipeType.MOULDING,
            SDRecipes.catalyst(
                catalystMouldRecipes.get("BASIC_DUNGEON_CATALYST").getInput().values().toArray(ItemStack[]::new)
            )
        ).register(sd);

        // Will be added once I finish their corresponding dungeons

        new Catalyst(
            SDGroups.CATALYSTS,
            SDStacks.VIVACIOUS_DUNGEON_CATALYST,
            SDRecipeType.MOULDING,
            SDRecipes.catalyst(
                catalystMouldRecipes.get("VIVACIOUS_DUNGEON_CATALYST").getInput().values().toArray(ItemStack[]::new)
            )
        ).register(sd);

        new Catalyst(
            SDGroups.CATALYSTS,
            SDStacks.TENEBROUS_DUNGEON_CATALYST,
            SDRecipeType.MOULDING,
            SDRecipes.catalyst(
                catalystMouldRecipes.get("TENEBROUS_DUNGEON_CATALYST").getInput().values().toArray(ItemStack[]::new)
            )
        ).register(sd);

        new Catalyst(
            SDGroups.CATALYSTS,
            SDStacks.ANCIENT_DUNGEON_CATALYST,
            SDRecipeType.MOULDING,
            SDRecipes.catalyst(
                catalystMouldRecipes.get("ANCIENT_DUNGEON_CATALYST").getInput().values().toArray(ItemStack[]::new)
            )
        ).register(sd);

        // ---- Records ----

        new RecordPlayer(
            SDGroups.RECORDS,
            SDStacks.RECORD_PLAYER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            SDRecipes.cyclicAlternating(SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.PLASTIC_SHEET, JUKEBOX)
        ).register(sd);

        new RecordBooster(
            SDGroups.RECORDS,
            SDStacks.RECORD_BOOSTER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            SDRecipes.cyclicAlternating(SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.PLASTIC_SHEET, NOTE_BLOCK)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_VALOR,
            SDRecipeType.LOOTING,
            SDRecipes.single(SDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10*20*60, 0),
            new PotionEffect(PotionEffectType.REGENERATION, 10*20*60, 0),
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10*20*60, 0),
            new PotionEffect(PotionEffectType.SPEED, 10*20*60, 0)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_VALOR_BOOSTED,
            SDRecipeType.BOOSTING,
            SDRecipes.single(SDStacks.RECORD_OF_VALOR),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 15*20*60, 1),
            new PotionEffect(PotionEffectType.REGENERATION, 15*20*60, 1),
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 15*20*60, 1),
            new PotionEffect(PotionEffectType.SPEED, 15*20*60, 1)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_AEGIS,
            SDRecipeType.LOOTING,
            SDRecipes.single(SDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10*20*60, 2)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_AEGIS_BOOSTED,
            SDRecipeType.BOOSTING,
            SDRecipes.single(SDStacks.RECORD_OF_AEGIS),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 15*20*60, 3)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_ORDER,
            SDRecipeType.LOOTING,
            SDRecipes.single(SDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.REGENERATION, 10*20*60, 2)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_ORDER_BOOSTED,
            SDRecipeType.BOOSTING,
            SDRecipes.single(SDStacks.RECORD_OF_ORDER),
            new PotionEffect(PotionEffectType.REGENERATION, 15*20*60, 3)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_POWER,
            SDRecipeType.LOOTING,
            SDRecipes.single(SDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10*20*60, 2)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_POWER_BOOSTED,
            SDRecipeType.BOOSTING,
            SDRecipes.single(SDStacks.RECORD_OF_POWER),
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 15*20*60, 3)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_HASTE,
            SDRecipeType.LOOTING,
            SDRecipes.single(SDStacks.GUIDE_ANY_CHEST),
            new PotionEffect(PotionEffectType.SPEED, 10*20*60, 2)
        ).register(sd);

        new Record(
            SDStacks.RECORD_OF_HASTE_BOOSTED,
            SDRecipeType.BOOSTING,
            SDRecipes.single(SDStacks.RECORD_OF_HASTE),
            new PotionEffect(PotionEffectType.SPEED, 15*20*60, 3)
        ).register(sd);

        // ---- Tokens ----

        new DungeonToken(
            SDGroups.DUNGEON,
            SDStacks.BASIC_DUNGEON_TOKEN,
            SDRecipeType.LOOTING,
            SDRecipes.single(SDStacks.GUIDE_BASIC_CHEST)
        ).register(sd);

        new DungeonToken(
            SDGroups.DUNGEON,
            SDStacks.VIVACIOUS_DUNGEON_TOKEN,
            SDRecipeType.LOOTING,
            SDRecipes.single(SDStacks.GUIDE_VIVACIOUS_CHEST)
        ).register(sd);

        new DungeonToken(
            SDGroups.DUNGEON,
            SDStacks.TENEBROUS_DUNGEON_TOKEN,
            SDRecipeType.LOOTING,
            SDRecipes.single(SDStacks.GUIDE_TENEBROUS_CHEST)
        ).register(sd);

        new DungeonToken(
            SDGroups.DUNGEON,
            SDStacks.ANCIENT_DUNGEON_TOKEN,
            SDRecipeType.LOOTING,
            SDRecipes.single(SDStacks.GUIDE_ANCIENT_CHEST)
        ).register(sd);

        // ---- Dusts ----

        new DungeonDust(
            SDGroups.DUNGEON,
            SDStacks.EFFERVESCENT_DUST,
            SDRecipeType.MENDING,
            SDRecipes.single(SDStacks.GUIDE_ORGANIC_FRACTURE)
        ).register(sd);

        new DungeonDust(
            SDGroups.DUNGEON,
            SDStacks.ENERVATED_DUST,
            SDRecipeType.MENDING,
            SDRecipes.single(SDStacks.GUIDE_VOID_FRACTURE)
        ).register(sd);

        new DungeonDust(
            SDGroups.DUNGEON,
            SDStacks.EFFLUVIANT_DUST,
            SDRecipeType.MENDING,
            SDRecipes.single(SDStacks.GUIDE_ROCKY_FRACTURE)
        ).register(sd);

    }

}
