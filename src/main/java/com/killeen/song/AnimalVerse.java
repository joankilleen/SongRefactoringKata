package com.killeen.song;

import java.util.Objects;

public class AnimalVerse {
    private String name;
    private String text;
    private boolean includeRepeater;
    private boolean includeLastLine;

    public void setIncludeLastLine(boolean includeLastLine) {
        this.includeLastLine = includeLastLine;
    }


    public AnimalVerse(String name, String optionalText, boolean includeRepeater, boolean includeLastLine){
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
                '}';
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
}
