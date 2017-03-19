package me.crazyrealms.crazyenchants;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    //Converts the given integer into a roman numeral
    public static String intToRomanNumeral(int i)  {
        //Max level is 10 so I may as well do it manually. If you (ipodtouch0218) can find a better way then go ahead :)
        switch (i) {
            case 1:
                return "I";
            case 2:
                return "II";
                
            case 3:
                return "III";
                
            case 4:
                return "IV";
                
            case 5:
                return "V";
                
            case 6:
                return "VI";
                
            case 7:
                return "VII";
                
            case 8:
                return "VIII";
                
            case 9:
                return "IX";
                
            case 10:
                return "X";
        }
        return Integer.toString(i);
    }

    //Splits the string into multiple lines so the lore isn't too long (Retains ChatColor)
    public static List<String> loreLineFormat(String string, ChatColor color) {
        List<String> newString = new ArrayList<>();
        while(string.length() >= 30) {
            newString.add(color + string.substring(0, 30));
            string = string.substring(30, string.length());
        }

        return newString;
    }

    //Mainly for enumerations. Turn all caps message into 1 cap beginning
    public static String camelCase(String string) {
        Character beginning = string.charAt(0);
        return beginning.toString().toUpperCase() + string.split(beginning.toString(), 2)[1].toLowerCase();
    }

}
