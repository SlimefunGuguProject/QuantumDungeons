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
        Theme.DIMENSIONAL.getColor() + "材料"
    );
    
    public static final ItemStack GUIDE_ITEM_TOOLS = new CustomItemStack(
        Material.SPYGLASS,
        Theme.DIMENSIONAL.getColor() + "工具"
    );
    
    public static final ItemStack GUIDE_ITEM_CATALYSTS = new CustomItemStack(
        Material.GRAY_DYE,
        Theme.CATALYST.getColor() + "转换器"
    );
    
    public static final ItemStack GUIDE_ITEM_RECORDS = new CustomItemStack(
        Material.MUSIC_DISC_CHIRP,
        Theme.RECORD.getColor() + "记录"
    );
    
    public static final ItemStack GUIDE_ITEM_DUNGEON = new CustomItemStack(
        Material.MOSSY_STONE_BRICKS,
        Theme.DUNGEON.getColor() + "地下城物品"
    );
    
    public static final ItemStack GUIDE_ITEM_MAIN = new CustomItemStack(
        Material.CRACKED_STONE_BRICKS,
        Theme.DUNGEON.getColor() + "量子地下城"
    );

    public static final ItemStack GUIDE_VOIDAL = new CustomItemStack(
        Material.ENDERMAN_SPAWN_EGG,
        Theme.VOID.getColor() + "虚空"
    );

    public static final ItemStack GUIDE_ANY_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "地下城的箱子",
        "&7任何"
    );

    public static final ItemStack GUIDE_BASIC_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "地下城的箱子",
        "&7基本"
    );

    public static final ItemStack GUIDE_VIVACIOUS_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "地下城的箱子",
        "&7鲜活的"
    );

    public static final ItemStack GUIDE_TENEBROUS_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "地下城的箱子",
        "&7Tenebrous"
    );

    public static final ItemStack GUIDE_ANCIENT_CHEST = new CustomItemStack(
        Material.CHEST,
        Theme.DUNGEON.getColor() + "地下城的箱子",
        "&7古代"
    );

    public static final ItemStack GUIDE_NORMAL_FRACTURE = new CustomItemStack(
        Material.WHITE_STAINED_GLASS_PANE,
        Theme.DUNGEON.getColor() + "正常断裂"
    );

    public static final ItemStack GUIDE_ROCKY_FRACTURE = new CustomItemStack(
        Material.LIGHT_GRAY_STAINED_GLASS_PANE,
        Theme.DUST.getColor() + "岩石断裂"
    );

    public static final ItemStack GUIDE_ORGANIC_FRACTURE = new CustomItemStack(
        Material.GREEN_STAINED_GLASS_PANE,
        Theme.LIFE.getColor() + "有机断裂"
    );

    public static final ItemStack GUIDE_VOID_FRACTURE = new CustomItemStack(
        Material.PURPLE_STAINED_GLASS_PANE,
        Theme.VOID.getColor() + "虚空断裂"
    );

    public static final ItemStack RECIPE_REFLECTING = new CustomItemStack(
        Material.GLASS,
        "&b捆绑玻璃",
        "&7这个项目是通过捆绑玻璃制作的。"
    );

    public static final ItemStack RECIPE_MOULDING = new CustomItemStack(
        Material.CAULDRON,
        "&b催化剂模具",
        "&7这个项目是在催化剂模具中制作的。"
    );
    
    public static final ItemStack RECIPE_LOOTING = new CustomItemStack(
        Material.CHEST,
        "&b掠夺",
        "&7该物品可通过掠夺地牢中的箱子获得。"
    );
    
    public static final ItemStack RECIPE_KILLING = new CustomItemStack(
        Material.CHEST,
        "&b暴徒掉落",
        "&7该物品通过杀死指定的暴徒获得。"
    );
    
    public static final ItemStack RECIPE_MENDING = new CustomItemStack(
        Material.SPYGLASS,
        "&b修补",
        "&7这个项目是通过修补",
        "&7地牢中的一个裂缝获得的。"
    );
    
    public static final ItemStack RECIPE_BOOSTING = new CustomItemStack(
        Material.NOTE_BLOCK,
        "&b提升",
        "&7这个项目是通过在记录",
        "&7提升器中提升一条记录获得的"
    );

    // ---- 材料和工具 ----
    
    public static final SlimefunItemStack FRACTURED_REALITY_SHARD = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "FRACTURED_REALITY_SHARD",
        Material.PRISMARINE_SHARD,
        "分裂的现实碎片",
        "它在你手中颤抖着"
    );

    public static final SlimefunItemStack RECONSTRUCTED_REALITY_SHARD = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "RECONSTRUCTED_REALITY_SHARD",
        Material.PRISMARINE_SHARD,
        "重建的现实碎片",
        "它像万花筒一样熠熠生辉"
    )
    .glisten();

    public static final SlimefunItemStack BINDING_GLASS = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "BINDING_GLASS",
        Material.GLASS,
        "捆绑玻璃",
        "将断裂的现实碎片反",
        "射到自己身上，以修复它。"
    );

    public static final SlimefunItemStack MENDING_GLASS = ThemedItemStack.of(
        Theme.DIMENSIONAL,
        "MENDING_GLASS",
        Material.SPYGLASS,
        "补玻璃",
        "可以修补现实本身的裂痕"
    );

    public static final SlimefunItemStack DUNGEON_PORTAL_FRAME = ThemedItemStack.of(
        Theme.DUNGEON,
        "DUNGEON_PORTAL_FRAME",
        Material.CRYING_OBSIDIAN,
        "地牢传送门框架",
        "把它放在离地牢传送门土丘两个街区的地方"
    );

    public static final SlimefunItemStack DUNGEON_PORTAL_MOUND = ThemedItemStack.of(
        Theme.DUNGEON,
        "DUNGEON_PORTAL_MOUND",
        Material.RESPAWN_ANCHOR,
        "地牢传送门土丘",
        "需要有四个地牢传送门框架围绕它"
    );

    // ---- Catalysts ----

    public static final SlimefunItemStack CATALYST_MOULD = ThemedItemStack.of(
        Theme.CATALYST,
        "CATALYST_MOULD",
        Material.CAULDRON,
        "催化剂模具",
        "把材料扔进去",
        "然后用催化剂右键点击。"
    );

    public static final SlimefunItemStack BLANK_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "BLANK_DUNGEON_CATALYST",
        Material.GRAY_DYE,
        "空白的催化剂",
        "自己什么都不做..."
    );

    public static final SlimefunItemStack BASIC_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "BASIC_DUNGEON_CATALYST",
        Material.VINE,
        "基本地牢的催化剂",
        "基本地牢的钥匙"
    );

    public static final SlimefunItemStack VIVACIOUS_DUNGEON_CATALYST = ThemedItemStack.of(
        Theme.CATALYST,
        "VIVACIOUS_DUNGEON_CATALYST",
        Material.GLOW_BERRIES,
        "贪婪的地下城催化剂",
        "贪婪的地下城的钥匙"
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
        "古代地下城的催化剂",
        "古代地宫的钥匙"
    );

    // ---- Records ----

    public static final SlimefunItemStack RECORD_PLAYER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_PLAYER",
        Material.JUKEBOX,
        "录音机",
        "呈现出唱片中惊心动魄的声音"
    );

    public static final SlimefunItemStack RECORD_BOOSTER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_BOOSTER",
        Material.NOTE_BLOCK,
        "纪录助推器",
        "提高记录的质量",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerBuffer(8192),
        LoreBuilder.powerPerSecond(2048)
    );

    public static final SlimefunItemStack RECORD_OF_VALOR = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_VALOR",
        Material.MUSIC_DISC_13,
        "英勇记录",
        "唤起一种勇敢的感觉"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_VALOR_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_VALOR_BOOSTED",
        Material.MUSIC_DISC_13,
        "英勇的记录",
        "唤起强烈的勇敢感"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    public static final SlimefunItemStack RECORD_OF_AEGIS = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_AEGIS",
        Material.MUSIC_DISC_WAIT,
        "宙斯的记录",
        "唤起了一种凝重的感觉"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_AEGIS_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_AEGIS_BOOSTED",
        Material.MUSIC_DISC_WAIT,
        "宙斯的记录",
        "唤起一种强烈的凝重感"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    public static final SlimefunItemStack RECORD_OF_ORDER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_ORDER",
        Material.MUSIC_DISC_FAR,
        "秩序记录",
        "唤起一种和平的感觉"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_ORDER_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_ORDER_BOOSTED",
        Material.MUSIC_DISC_FAR,
        "秩序记录",
        "唤起强烈的和平感"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    public static final SlimefunItemStack RECORD_OF_POWER = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_POWER",
        Material.MUSIC_DISC_CHIRP,
        "权力记录",
        "唤起一种力量的感觉"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_POWER_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_POWER_BOOSTED",
        Material.MUSIC_DISC_CHIRP,
        "权力的记录",
        "唤起一种强烈的力量感"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    public static final SlimefunItemStack RECORD_OF_HASTE = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_HASTE",
        Material.MUSIC_DISC_STRAD,
        "匆忙记录",
        "唤起一种紧迫感"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS);

    public static final SlimefunItemStack RECORD_OF_HASTE_BOOSTED = ThemedItemStack.of(
        Theme.RECORD,
        "RECORD_OF_HASTE_BOOSTED",
        Material.MUSIC_DISC_STRAD,
        "匆忙的记录",
        "唤起强烈的紧迫感"
    ).addFlags(ItemFlag.HIDE_POTION_EFFECTS).glisten();

    // ---- Tokens ----

    public static final SlimefunItemStack BASIC_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "BASIC_DUNGEON_TOKEN",
        Material.FIREWORK_STAR,
        "基本地下城令牌",
        "基本地牢中的一枚金属硬币"
    ).glisten();

    public static final SlimefunItemStack VIVACIOUS_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "VIVACIOUS_DUNGEON_TOKEN",
        Material.FLOWERING_AZALEA,
        "活泼的地下城令牌",
        "活泼的地下城的花枝"
    ).glisten();

    public static final SlimefunItemStack TENEBROUS_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "TENEBROUS_DUNGEON_TOKEN",
        Material.ENDER_EYE,
        "Tenebrous Dungeon Token",
        "来自Tenebrous Dungeon的神秘水晶"
    ).glisten();

    public static final SlimefunItemStack ANCIENT_DUNGEON_TOKEN = ThemedItemStack.of(
        Theme.DUNGEON,
        "ANCIENT_DUNGEON_TOKEN",
        Material.ECHO_SHARD,
        "古代地下城令牌",
        "来自古代地下城的尘土飞扬的遗物"
    ).glisten();

    // ---- Dusts ----

    public static final SlimefunItemStack EFFERVESCENT_DUST = ThemedItemStack.of(
        Theme.LIFE,
        "EFFERVESCENT_DUST",
        Material.GLOWSTONE_DUST,
        "泡腾粉",
        "充满了生命力"
    ).glisten();

    public static final SlimefunItemStack ENERVATED_DUST = ThemedItemStack.of(
        Theme.VOID,
        "ENERVATED_DUST",
        Material.GUNPOWDER,
        "受保护的灰尘",
        "生命的枯竭"
    );

    public static final SlimefunItemStack EFFLUVIANT_DUST = ThemedItemStack.of(
        Theme.DUST,
        "EFFLUVIANT_DUST",
        Material.REDSTONE,
        "流出的灰尘",
        "被遗弃了千年之久"
    );


}
