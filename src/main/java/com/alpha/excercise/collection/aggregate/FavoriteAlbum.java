package com.alpha.excercise.collection.aggregate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by anantagarwal on 30/03/2015.
 */
public class FavoriteAlbum {

    private static class Album {
        public String name;
        public List<Track> tracks;

        public Album(String name, List<Track> tracks) {
            this.name = name;
            this.tracks = tracks;
        }
    }

    private static class Track {
        int rating;

        public Track(int rating) {
            this.rating = rating;
        }
    }

    public static void main(String[] args) {
        List<Album> albums = Arrays.asList(new Album[] {new Album("RickyMartin", Arrays.asList(new Track[] {new Track(4)})),
                new Album("BonJovi", Arrays.asList(new Track[] {new Track(4)})),
                new Album("Maddona", Arrays.asList(new Track[] {new Track(3)}))});

        oldWayOfFindingFavorites(albums);
        System.out.println("New way of print favorite albums");

        //new streams
        albums.stream().filter(a -> a.tracks.stream().anyMatch(t -> t.rating >= 4))
                .sorted(Comparator.comparing(a -> a.name))
                .collect(Collectors.toList()).stream().forEach(a-> System.out.println(a.name));

        //Another sorting example
        albums.sort((a, b) -> b.name.compareTo(a.name));
        albums.stream().forEach(a -> System.out.println(a.name));
    }

    private static void oldWayOfFindingFavorites(List<Album> albums) {
        List<Album> favs = new ArrayList<>();
        for (Album a : albums) {
            boolean hasFavorite = false;
            for (Track t : a.tracks) {
                if (t.rating >= 4) {
                    hasFavorite = true;
                    break;
                }
            }
            if (hasFavorite)
                favs.add(a);
        }
        Collections.sort(favs, new Comparator<Album>() {
            public int compare(Album a1, Album a2) {
                return a1.name.compareTo(a2.name);
            }
        });
        for (Album favAlbum : favs) {
            System.out.println("albums = " + favAlbum.name);
        }
    }
}
