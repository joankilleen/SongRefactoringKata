package com.killeen.song;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Song {

    private final static List<AnimalVerse> ANIMAL_VERSES = new ArrayList<>(Arrays.asList(
            new AnimalVerse("fly", "There was an old lady who swallowed a fly.\n", false, true),
            new AnimalVerse("spider", "There was an old lady who swallowed a spider;\nThat wriggled and wiggled and tickled inside her.\n", true, true),
            new AnimalVerse("bird", "There was an old lady who swallowed a bird;\nHow absurd to swallow a bird.\n", true, true),
            new AnimalVerse("cat", "There was an old lady who swallowed a cat;\nFancy that to swallow a cat!\n", true, true),
            new AnimalVerse("dog", "There was an old lady who swallowed a dog;\nWhat a hog, to swallow a dog!\n", true, true),
            new AnimalVerse("cow", "There was an old lady who swallowed a cow;\nI don't know how she swallowed a cow!\n", true, true),
            new AnimalVerse("horse", "There was an old lady who swallowed a horse...\n...She's dead, of course!", false, false)));



    public static List<AnimalVerse> getAnimals() {
        return ANIMAL_VERSES;
    }

    public String construct() {

        StringBuilder finalSong = new StringBuilder();
        List<AnimalVerse> previousVerses = new ArrayList<>();

        ANIMAL_VERSES.forEach(next->{
            previousVerses.add(next);
            finalSong.append(next.construct(previousVerses));
        });

        return finalSong.toString();
    }

    public static void main(String[] args) {
        Song song = new Song();
        System.out.println(song.construct());
    }


}
