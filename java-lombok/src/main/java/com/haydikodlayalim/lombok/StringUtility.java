package com.haydikodlayalim.lombok;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtility {

    public String trim(String value) {
        return value.trim();
    }

    public String trimPerson(Person value) {
        return value.toString();
    }
}
