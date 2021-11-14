package com.killeen.song;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicSong {

    private final static List<AnimalText> animalTexts = new ArrayList<>(Arrays.asList(
            new AnimalText ("fly",null),
            new AnimalText ("spider", "That wriggled and wiggled and tickled inside her.\n")));
    private static final String ANIMAL_N = "ANIMAL_N";
    private static final String ANIMAL_N_1 = "ANIMAL_N_1";
    private static final String FIRST_LINE_VERSE = new StringBuilder("There was an old lady who swallowed a ")
            .append(ANIMAL_N)
            .append("\n")
            .toString();
    private static final String REPEATING_LINE = new StringBuilder("She swallowed the ")
            .append(ANIMAL_N)
            .append(" to catch the ")
            .append(ANIMAL_N_1)
            .append("\n")
            .toString();
    private static final String FINAL_LINE_VERSE = "I don't know why she swallowed a fly - perhaps she'll die!\n";
    private static final String FINAL_VERSE ="There was an old lady who swallowed a horse...\n...She's dead, of course!";




    public static List<AnimalText> getAnimals(){
        return animalTexts;
    }
    public String constructSong(){
        List<String> verses = new ArrayList<>();
        for (int i=0; i<animalTexts.size(); i++){
            verses.add(constructVerse(i));
        }
        verses.add(FINAL_VERSE);
        StringBuilder finalSong = new StringBuilder();
        verses.forEach(v-> finalSong.append(v));
        return finalSong.toString();
    }

    private String constructVerse(int i) {
        AnimalText animalText_i = getAnimals().get(i);
        StringBuilder verse = new StringBuilder(FIRST_LINE_VERSE.replaceAll(ANIMAL_N, animalText_i.getName()));
        Validate.notNull(animalText_i);

        if (animalText_i.getOptionalLine() != null){
            verse.append(animalText_i.getOptionalLine());
        }

        for (int n=i; n>=1; n--){
            AnimalText text_1 = getAnimals().get(n-1);
            Validate.notNull(text_1);
            verse.append(REPEATING_LINE.replace(ANIMAL_N_1, text_1.getName()).replace(ANIMAL_N, animalText_i.getName()));
        }
        return verse.append(FINAL_LINE_VERSE).append("\n").toString();
    }
    public static void main(String[] args){
        DynamicSong song = new DynamicSong();
        System.out.println(song.constructSong());
    }


}
