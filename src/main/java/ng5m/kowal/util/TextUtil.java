package ng5m.kowal.util;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

    private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");
    public static String fixColor(String str) {
        Pattern pattern = Pattern.compile("&(#[a-fA-F0-9]{6})");

        for (Matcher matcher = pattern.matcher(str); matcher.find(); matcher = pattern.matcher(str)) {
            String color = str.substring(matcher.start() + 1, matcher.end());
            str = str.replace("&" + color, "" + ChatColor.valueOf(color));
        }
        return ChatColor.translateAlternateColorCodes('&', str).replace(">>", "Â»").replace("<<", "Â«").replace("->", "â†�").replace("**", "â€˘");

    }

}
