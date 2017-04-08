package com.example.dianamilton.h2go;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class DataSetExample {
    private List<Data> dataList = new ArrayList<>();

    /**
     * calls method to generate data for history graph
     */
    public DataSetExample() {
        generateDummyData();
    }

    /**
     * method that generates data
     */
    private void generateDummyData() {
        Random rand = new Random();

        for (int i = 0; i < 10; ++i) {
            dataList.add(new Data(rand.nextInt(10), i));
        }

        Collections.sort(dataList);
    }

    /**
     *
     * @return data list that was generated
     */
    public List<Data> getDataList() { return dataList; }
}
