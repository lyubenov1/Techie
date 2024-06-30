package com.techie.utils;

import java.util.*;
import java.util.stream.*;

public class CaseStyleUtil {

    public static String styleFieldName(String fieldName) {
        String styledName = camelCaseToWords(fieldName);
        if ("batteryCapacity".equals(fieldName)) {
            styledName += " (mAh)";
        }
        if ("anc".equals(fieldName)) {
            styledName = "Noise Cancelling (Active)";
        }
        if("gpu".equals(fieldName)) {
            styledName = "GPU";
        }
        if("ram".equals(fieldName)) {
            styledName = "RAM";
        }
        return styledName;
    }

    public static String camelCaseToWords(String camelCase) {
        return Arrays.stream(camelCase.split("(?=[A-Z])"))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    public static String capitalizeFirstLetter(String str) {
        if (str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}