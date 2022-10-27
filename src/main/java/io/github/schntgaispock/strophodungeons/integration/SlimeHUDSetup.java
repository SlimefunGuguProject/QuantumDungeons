package io.github.schntgaispock.strophodungeons.integration;

import io.github.schntgaispock.slimehud.SlimeHUD;
import io.github.schntgaispock.slimehud.waila.HudController;
import io.github.schntgaispock.slimehud.waila.HudRequest;
import io.github.schntgaispock.strophodungeons.core.slimefun.SDBlockStorage;
import io.github.schntgaispock.strophodungeons.core.slimefun.items.materials.DungeonPortalMound;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SlimeHUDSetup {
    
    public static void setup() {
        HudController hc = SlimeHUD.getHudController();

        hc.registerCustomHandler(
            DungeonPortalMound.class,
            (HudRequest request) -> {
                return "&7| 连接的框架: " + SDBlockStorage.getShort(request.getLocation(), "connected_frames");
            }
        );
    }

}
