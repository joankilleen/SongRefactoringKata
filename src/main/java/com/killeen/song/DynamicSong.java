package com.killeen.song;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicSong {

    private final static List<AnimalVerse> ANIMAL_VERSES = new ArrayList<>(Arrays.asList(
            new AnimalVerse("fly", "There was an old lady who swallowed a fly.\n", false, true),
            new AnimalVerse("spider", "There was an old lady who swallowed a spider;\nThat wriggled and wiggled and tickled inside her.\n", true, true),
            new AnimalVerse("bird", "There was an old lady who swallowed a bird;\nHow absurd to swallow a bird.\n", true, true),
            new AnimalVerse("cat", "There was an old lady who swallowed a cat;\nFancy that to swallow a cat!\n", true, true),
            new AnimalVerse("dog", "There was an old lady who swallowed a dog;\nWhat a hog, to swallow a dog!\n", true, true),
            new AnimalVerse("cow", "There was an old lady who swallowed a cow;\nI don't know how she swallowed a cow!\n", true, true),
            new AnimalVerse("horse", "There was an old lady who swallowed a horse...\n...She's dead, of course!", false, false)));

    private static final String ANIMAL_N = "ANIMAL_N";
    private static final String ANIMAL_N_1 = "ANIMAL_N_1";



    public static List<AnimalVerse> getAnimals() {
        return ANIMAL_VERSES;
    }

    public String construct() {

        StringBuilder finalSong = new StringBuilder();
        List<AnimalVerse> previousVerses = new ArrayList<>();
        for (int i = 0; i < ANIMAL_VERSES.size(); i++) {
            AnimalVerse next = ANIMAL_VERSES.get(i);
            previousVerses.add(next);
            finalSong.append(next.construct(previousVerses));
        }
        return finalSong.toString();
    }

    public static void main(String[] args) {
        DynamicSong song = new DynamicSong();
        System.out.println(song.construct());
    }


}
