package io.github.schntgaispock.quantumdungeons.core.slimefun;

import io.github.mooy1.infinitylib.groups.MultiGroup;
import io.github.mooy1.infinitylib.groups.SubGroup;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QDGroups {

    public static final SubGroup MATERIALS = new SubGroup("materials", QDStacks.GUIDE_ITEM_MATERIALS);
    public static final SubGroup TOOLS = new SubGroup("tools", QDStacks.GUIDE_ITEM_TOOLS);
    public static final SubGroup CATALYSTS = new SubGroup("catalysts", QDStacks.GUIDE_ITEM_CATALYSTS);
    public static final SubGroup RECORDS = new SubGroup("records", QDStacks.GUIDE_ITEM_RECORDS);
    public static final SubGroup DUNGEON = new SubGroup("dungeon", QDStacks.GUIDE_ITEM_DUNGEON);
    public static final SubGroup HIDDEN = new SubGroup("hidden", QDStacks.GUIDE_ITEM_HIDDEN);
    public static final MultiGroup MAIN = new MultiGroup("main", QDStacks.GUIDE_ITEM_MAIN,
        MATERIALS, TOOLS, CATALYSTS, RECORDS, DUNGEON, HIDDEN);

}
