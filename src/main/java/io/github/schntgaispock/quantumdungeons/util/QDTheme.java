package io.github.schntgaispock.quantumdungeons.util;


import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

@UtilityClass
public final class QDTheme {
    public static enum Theme {
        DUNGEON("#5a0d6b"),
        DIMENSIONAL("#cc21b8"),
        CATALYST("#c4ff0e"),
        RECORD("#fcfc11"),

        VOID("#706674"),
        LIFE("#34f20e"),
        DUST("#d8d8dd");

        private @Getter ChatColor color;
        private @Getter ChatColor loreColor;

        Theme(String color, String loreColor) {
            this.color = ChatColor.of(color);
            this.loreColor = ChatColor.of(loreColor);
        }

        Theme(String color) {
            this(color, "&7");
        }
    }
}
