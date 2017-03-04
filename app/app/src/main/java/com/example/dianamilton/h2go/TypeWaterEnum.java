package com.example.dianamilton.h2go;

/**
 * Created by dianamilton on 3/2/17.
 */

public enum TypeWaterEnum {
    Bottled("Bottled"), Well("Well"), Stream("Stream"), Lake("Lake"), Spring("Spring"), Other("Other");
    private final String waterType;

    TypeWaterEnum(String type) {
        waterType = type;
    }

    public String toString() {
        return waterType;
    }
}
