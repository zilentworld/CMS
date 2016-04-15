package com.jiro.utility;

import java.util.regex.Pattern;

public class Utility {
    
    public static boolean checkStringByRegex(String str, String regex) {
        
        return Pattern.compile(regex).matcher(str).matches();
    }

}
