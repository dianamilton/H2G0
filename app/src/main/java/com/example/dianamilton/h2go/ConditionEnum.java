package com.example.dianamilton.h2go;

/**
 * Created by dianamilton on 3/2/17.
 */

/**
 * enum for condition of water, for submit a water report page
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
