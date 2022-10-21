package io.github.schntgaispock.strophodungeons.util;


import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.md_5.bungee.api.ChatColor;

@UtilityClass
public final class SDTheme {
    public static enum Theme {
        DUNGEON("#cc21b8"),
        DIMENSIONAL("#7cf7f9"),
        CATALYST("#c4ff0e"),
        RECORD("#808080"),

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
            this(color, "#cccccc");
        }
    }
}
