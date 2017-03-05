package com.example.dianamilton.h2go;

/**
 * Created by dianamilton on 3/2/17.
 */

public enum ConditionEnum {
    Waste("Waste"), TreatableClear("Treatable - Clear"), TreatableMuddy("Treatable - Muddy"), Potable("Potable");
    private final String condition;

    ConditionEnum(String type) {
        condition = type;
    }

    public String toString() {
        return condition;
    }
}
