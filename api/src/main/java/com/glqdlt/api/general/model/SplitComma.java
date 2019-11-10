package com.glqdlt.api.general.model;

import java.util.Arrays;
import java.util.List;

/**
 * Date 2019-11-10
 *
 * @author glqdlt
 */
public interface SplitComma {
    static List<String> splitString(String str) {
        return Arrays.asList(str.split(","));
    }
}
