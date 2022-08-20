package io.github.schntgaispock.quantumdungeons.integration;

import io.github.schntgaispock.quantumdungeons.core.slimefun.QDBlockStorage;
import io.github.schntgaispock.quantumdungeons.core.slimefun.items.materials.DungeonPortalMound;
import io.github.schntgaispock.slimehud.SlimeHUD;
import io.github.schntgaispock.slimehud.waila.HudController;
import io.github.schntgaispock.slimehud.waila.HudRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SlimeHUDSetup {
    
    public static void setup() {
        HudController hc = SlimeHUD.getHudController();

        hc.registerCustomHandler(
            DungeonPortalMound.class,
            (HudRequest request) -> {
                return "&7| Connected frames: " + QDBlockStorage.getShort(request.getLocation(), "connected_frames");
            }
        );
    }

}
