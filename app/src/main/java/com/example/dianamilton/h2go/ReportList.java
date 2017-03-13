package com.example.dianamilton.h2go;

import java.util.ArrayList;

/**
 * Created by dianamilton on 3/2/17.
 */

public class ReportList {

    public ArrayList<Report> reportList = new ArrayList<>();
    int idCounter = 0;

    /**
     * Add report to the arraylist
     * Count how many reports in list
     * @param report
     */
    public void addReport(Report report) {
        report.setId(idCounter);
        reportList.add(report);
        idCounter++;
    }

    /**
     * Getter for the array storing all of the reports
     * @return reportArr
     */
    public Report[] getReport() {
        Report[] reportArr = new Report[reportList.size()];
        for (int i = 0; i < reportArr.length; i++) {
            reportArr[i] = reportList.get(i);
        }
        return reportArr;
    }

    /**
     * Getter for the array storing all of the reports
     * @return reportArr
     */
    public Report[] getReportsMap() {
        Report[] reportArr = new Report[reportList.size()];
        for (int i = 0; i < reportArr.length; i++) {
            reportArr[i] = reportList.get(i);
        }
        return reportArr;
    }

}
