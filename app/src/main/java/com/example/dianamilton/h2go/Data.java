package com.example.dianamilton.h2go;

public class Data implements Comparable {
    public int x;
    public int y;

    /**
     * defines data points for history graph
     * @param px
     * @param py
     */
    public Data(int px, int py) {
        x = px;
        y = py;
    }

    /**
     * ORGANIZES HISTORY GRAPH
     * @param o
     * @return compareto, if x is greater or smaller
     */
    @Override
    public int compareTo(Object o) {
        Data d = (Data) o;
        return x - d.x;

    }
}
