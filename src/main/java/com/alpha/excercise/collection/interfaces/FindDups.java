package com.alpha.excercise.collection.interfaces;

import java.util.*;

/**
 * Created by anantagarwal on 27/03/2015.
 */
public class FindDups {
    public static void main(String[] args) {
        findDuplicates(new String[]{"Tom", "Foo", "harry", "jon"});
    }

    private static void findDuplicates(String[] args) {
        SortedSet<String> s = new TreeSet<>((Object o1, Object o2) -> ((String) o1).compareToIgnoreCase((String) o2));
        s.addAll(Arrays.asList(args));
        System.out.println(s.size() + " distinct words: " + s);
    }
}
