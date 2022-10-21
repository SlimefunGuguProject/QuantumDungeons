package io.github.schntgaispock.strophodungeons.util;


import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Zombie;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.schntgaispock.strophodungeons.Strophodungeons;
import io.github.schntgaispock.strophodungeons.core.slimefun.SDStacks;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import lombok.experimental.UtilityClass;

/**
 * This class creates animations for various mechanics in SD
 */
@UtilityClass
public class SDEffects {

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
                frame.setItem(SDStacks.RECONSTRUCTED_REALITY_SHARD, false);
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

        reflectionTask.runTaskTimer(Strophodungeons.getInstance(), 8, 8);

    }
    
    public static void catalysePortal(String dungeontype, Location moundLocation) {

    }

    public static void animateFracture(Block source, Particle particle) {
        source.getWorld().spawnParticle(
            particle,
            source.getLocation().add(0.5, 0.5, 0.5), 10,
            0, 0.5, 0,
            5, null, true);
    }

    public static void mendFracture(Block source) {

    }

    public static void animateDungeonFlames(Block source) {

    }

    public static void killVoidal(Zombie source) {
        Location l = source.getLocation();
        World w = source.getWorld();

        w.playSound(l, Sound.BLOCK_GLASS_BREAK, SoundCategory.HOSTILE, 1.0f, 0.5f);
    }

    public static void mouldCatalyst(Location mouldLocation) {
        World w = mouldLocation.getWorld();
        w.playSound(
            mouldLocation,
            Sound.ENTITY_SLIME_SQUISH_SMALL,
            SoundCategory.PLAYERS,
            1.0f, 1.0f);
        w.spawnParticle(
            Particle.SLIME,
            mouldLocation.add(0.5, 0.8, 0.5), 20,
            0.5, 0.1, 0.5,
            2, null, true);

    }

}
