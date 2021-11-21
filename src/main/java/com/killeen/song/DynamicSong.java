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

    private static final String REPEATING_LINE = new  StringBuilder ("She swallowed the ")
            .append(ANIMAL_N)
            .append(" to catch the ")
            .append(ANIMAL_N_1).toString();
    private static final String FINAL_LINE_VERSE = "I don't know why she swallowed a fly - perhaps she'll die!\n";

    public static List<AnimalVerse> getAnimals() {
        return ANIMAL_VERSES;
    }

    public String construct() {
        List<String> verses = new ArrayList<>();
        for (int i = 0; i < ANIMAL_VERSES.size(); i++) {
            verses.add(constructVerse(i));
        }

        StringBuilder finalSong = new StringBuilder();
        verses.forEach(v -> finalSong.append(v));
        return finalSong.toString();
    }

    private String constructVerse(int i) {
        AnimalVerse animalVerse_i = getAnimals().get(i);
        Validate.notNull(animalVerse_i);
        StringBuilder verse = new StringBuilder(animalVerse_i.getText());
        if (animalVerse_i.includeRepeater()) {

            //Repeating line
            for (int n = i; n >= 1; n--) {
                AnimalVerse text_n = getAnimals().get(n);
                AnimalVerse text_n_minus_1 = getAnimals().get(n - 1);
                Validate.notNull(text_n_minus_1);

                verse.append(REPEATING_LINE.replace(ANIMAL_N_1, text_n_minus_1.getName()).replace(ANIMAL_N, text_n.getName()));
                if (n == 1) {
                    verse.append(";\n");
                } else {
                    verse.append(",\n");
                }
            }
        }
        if (animalVerse_i.includeLastLine()) {
            verse.append(FINAL_LINE_VERSE);
        }
        return verse.append("\n").toString();
    }

    public static void main(String[] args) {
        DynamicSong song = new DynamicSong();
        System.out.println(song.construct());
    }


}
