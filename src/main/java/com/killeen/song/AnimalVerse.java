package com.killeen.song;

import org.apache.commons.lang3.Validate;

import java.util.Objects;
import java.util.List;

public class AnimalVerse {

    private static final String ANIMAL_N = "ANIMAL_N";
    private static final String ANIMAL_N_1 = "ANIMAL_N_1";

    private static final String REPEATING_LINE = new StringBuilder("She swallowed the ")
            .append(ANIMAL_N)
            .append(" to catch the ")
            .append(ANIMAL_N_1).toString();

    private static final String FINAL_LINES = "I don't know why she swallowed a fly - perhaps she'll die!\n";

    private String name;
    private String text;
    private boolean includeRepeater;
    private boolean includeLastLine;


    public void setIncludeLastLine(boolean includeLastLine) {
        this.includeLastLine = includeLastLine;
    }


    public AnimalVerse(String name, String optionalText, boolean includeRepeater, boolean includeLastLine) {
        this.name = name;
        this.text = optionalText;
        this.includeRepeater = includeRepeater;
        this.includeLastLine = includeLastLine;

    }

    public boolean includeRepeater() {
        return includeRepeater;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalVerse that = (AnimalVerse) o;
        return Objects.equals(name, that.name) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text);
    }

    @Override
    public String toString() {
        return "AnimalText{" +
                "name='" + name + '\'' +
                ", optionalText='" + text + '\'' +
                '}' ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void setIncludeRepeater(boolean includeRepeater) {
        this.includeRepeater = includeRepeater;
    }

    public boolean includeLastLine() {
        return includeLastLine;
    }

    public String construct(List<AnimalVerse> listPreviousAnimalsIncludingMe) {

        StringBuilder verse = new StringBuilder(text);
        if (this.includeRepeater ) {

            //Repeating line
            for (int n = listPreviousAnimalsIncludingMe.size()-1; n >= 1; n--) {
                AnimalVerse text_n = listPreviousAnimalsIncludingMe.get(n);
                AnimalVerse text_n_minus_1 = listPreviousAnimalsIncludingMe.get(n - 1);
                Validate.notNull(text_n_minus_1);
                verse.append(REPEATING_LINE.replace(ANIMAL_N_1, text_n_minus_1.getName()).replace(ANIMAL_N, text_n.getName()));
                if (n == 1) {
                    verse.append(";\n");
                } else {
                    verse.append(",\n");
                }
            }
        }
        //Last line
        if (this.includeLastLine) {
            verse.append(FINAL_LINES);
        }
        return verse.append("\n").toString();
    }
}