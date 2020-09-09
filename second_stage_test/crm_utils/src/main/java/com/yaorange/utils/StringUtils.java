package com.yaorange.utils;

public class StringUtils {
    public static boolean isEmpty(String string) {
        if (string == null){
            return true;
        }else if(string.trim().length() == 0){
            return true;
        }
        return false;
    }
}
