package io.github.schntgaispock.quantumdungeons.core.slimefun;

import io.github.mooy1.infinitylib.groups.MultiGroup;
import io.github.mooy1.infinitylib.groups.SubGroup;
import lombok.experimental.UtilityClass;

@UtilityClass
public class QDGroups {

    public static final SubGroup MATERIALS = new SubGroup("材料", QDStacks.GUIDE_ITEM_MATERIALS);
    public static final SubGroup TOOLS = new SubGroup("工具", QDStacks.GUIDE_ITEM_TOOLS);
    public static final SubGroup CATALYSTS = new SubGroup("转换器", QDStacks.GUIDE_ITEM_CATALYSTS);
    public static final SubGroup RECORDS = new SubGroup("记录", QDStacks.GUIDE_ITEM_RECORDS);
    public static final SubGroup DUNGEON = new SubGroup("地下城", QDStacks.GUIDE_ITEM_DUNGEON);
    public static final MultiGroup MAIN = new MultiGroup("主要", QDStacks.GUIDE_ITEM_MAIN,
        MATERIALS, TOOLS, CATALYSTS, RECORDS, DUNGEON);

}
