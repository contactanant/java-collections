package com.alpha.excercise.collection.interfaces;

import java.util.*;

/**
 * Created by anantagarwal on 27/03/2015.
 */
public class RandomPrint {


    public static void main(String[] args) {
        shuffleAndPrint(new String[]{"tom", "foo", "harry", "jon"});
    }

    private static void shuffleAndPrint(String[] args) {
        List<String> list = Arrays.asList(args);
        Collections.shuffle(list);
        list.stream().forEach(s -> System.out.format("%s ", s));


        for (String item : list) {
            System.out.format("%s ", item);
        }
    }
}
