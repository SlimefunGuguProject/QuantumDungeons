package io.github.schntgaispock.strophodungeons.core.slimefun;

import io.github.mooy1.infinitylib.groups.MultiGroup;
import io.github.mooy1.infinitylib.groups.SubGroup;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SDGroups {

    public static final SubGroup MATERIALS = new SubGroup("materials", SDStacks.GUIDE_ITEM_MATERIALS);
    public static final SubGroup TOOLS = new SubGroup("tools", SDStacks.GUIDE_ITEM_TOOLS);
    public static final SubGroup CATALYSTS = new SubGroup("catalysts", SDStacks.GUIDE_ITEM_CATALYSTS);
    public static final SubGroup RECORDS = new SubGroup("records", SDStacks.GUIDE_ITEM_RECORDS);
    public static final SubGroup DUNGEON = new SubGroup("dungeon", SDStacks.GUIDE_ITEM_DUNGEON);
    public static final MultiGroup MAIN = new MultiGroup("main", SDStacks.GUIDE_ITEM_MAIN,
        MATERIALS, TOOLS, CATALYSTS, RECORDS, DUNGEON);

}
