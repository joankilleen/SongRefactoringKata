package com.killeen.song;

import java.util.Objects;

public class AnimalText {
    private String name;
    private String optionalLine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalText that = (AnimalText) o;
        return Objects.equals(name, that.name) && Objects.equals(optionalLine, that.optionalLine);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, optionalLine);
    }

    @Override
    public String toString() {
        return "AnimalText{" +
                "name='" + name + '\'' +
                ", optionalText='" + optionalLine + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptionalLine() {
        return optionalLine;
    }

    public void setOptionalLine(String optionalLine) {
        this.optionalLine = optionalLine;
    }

    public AnimalText(String name, String optionalText){
        this.name = name;
        this.optionalLine = optionalText;
    }
}
