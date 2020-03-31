package com.burakenesdemir.cms.utils;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static String SPECIAL_CHARS_REGEX = "[!@#$%^&*,?\":{}|<>]";

    public static String replaceSpecialChars(String str) {
        String result = StringUtils.EMPTY;
        if (StringUtils.isNotBlank(str)) {
            result = str.replaceAll("Ç", "C").replaceAll("ç", "c").replaceAll("Ö", "O").replaceAll("ö", "o").replaceAll("ı", "i").replaceAll("İ", "I").replaceAll("ş", "s").replaceAll("Ş", "S")
                    .replaceAll("Ğ", "G").replaceAll("ğ", "g").replaceAll("Ü", "U").replaceAll("ü", "u").replaceAll("ë", "e");
        }

        return result;
    }

}
