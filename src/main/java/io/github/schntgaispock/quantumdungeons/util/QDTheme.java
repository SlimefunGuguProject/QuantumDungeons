package io.github.schntgaispock.quantumdungeons.util;


import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

@UtilityClass
public final class QDTheme {
    public static enum Theme {
        DUNGEON("#5a0d6b", "#6b6b6b"),
        DIMENSIONAL("#5a0d6b", "#6b6b6b"),
        CATALYST("#32baac", "#6b6b6b"),
        RECORD("#b5b510", "#6b6b6b"),

        VOID("#b5b510", "#6b6b6b"),
        LIFE("#b5b510", "#6b6b6b"),
        DUST("#b5b510", "#6b6b6b");

        private @Getter ChatColor color;
        private @Getter ChatColor loreColor;

        Theme(String color, String loreColor) {
            this.color = ChatColor.of(color);
            this.loreColor = ChatColor.of(loreColor);
        }
    }
}
