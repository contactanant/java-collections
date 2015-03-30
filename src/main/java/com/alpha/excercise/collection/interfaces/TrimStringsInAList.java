package com.alpha.excercise.collection.interfaces;

import java.util.Arrays;
import java.util.List;

/**
 * Created by anantagarwal on 27/03/2015.
 */
public class TrimStringsInAList {

    public static void main(String[] args) {
        trimStrings(new String[]{"hello   ", "main", "program     "});
    }

    private static void trimStrings(String[] objects) {
        List<String> l = Arrays.asList(objects);
        l.stream().map(s -> s.trim()).forEach(s -> System.out.format("%s ", s));
    }
}