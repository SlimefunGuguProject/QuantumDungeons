package io.github.schntgaispock.quantumdungeons.util;


import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Zombie;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.schntgaispock.quantumdungeons.QuantumDungeons;
import io.github.schntgaispock.quantumdungeons.core.slimefun.QDStacks;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.experimental.UtilityClass;

/**
 * This class creates animations for various mechanics in QD
 */
@UtilityClass
public class QDEffects {

    public static void bindFracturedRealityShard(ItemFrame frame) {
        BukkitRunnable reflectionTask = new BukkitRunnable() {

            private int iterations = 0;

            private void progress() {
                frame.getWorld().playSound(
                    frame.getLocation(),
                    Sound.BLOCK_AMETHYST_CLUSTER_STEP,
                    SoundCategory.BLOCKS,
                    1.0f,
                    1.0f);
            }

            private void finish() {
                frame.getWorld().playSound(
                    frame.getLocation(),
                    Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED,
                    SoundCategory.BLOCKS,
                    1.0f,
                    2.0f
                );
                frame.setItem(QDStacks.RECONSTRUCTED_REALITY_SHARD, false);
                cancel();
            }

            @Override
            public void run() {
                SlimefunItem item;
                if (
                    frame == null ||
                    (item = SlimefunItem.getByItem(frame.getItem())) == null ||
                    !item.getId().equals("FRACTURED_REALITY_SHARD")
                ) cancel();
                else if (iterations++ == 3) finish();
                else progress();
            }

        };

        reflectionTask.runTaskTimer(QuantumDungeons.getInstance(), 8, 8);

    }
    
    public static void catalysePortal(String dungeontype, Location moundLocation) {

    }

    public static void generateFracture(ArmorStand source) {

    }

    public static void mendFracture(ArmorStand source) {

    }

    public static void killVoidal(Zombie source) {

    }

    public static void mouldCatalyst(Location mouldLocation) {

    }

}
