package com.example.dianamilton.h2go;

import java.util.ArrayList;

/**
 * Created by dianamilton on 3/2/17.
 */

public class ReportList {

    public ArrayList<Report> reportList = new ArrayList<>();
    int idCounter = 0;

    public void addReport(Report report) {
        report.setId(idCounter);
        reportList.add(report);
        idCounter++;
    }

    public Report[] getReport() {
        Report[] reportArr = new Report[reportList.size()];
        for (int i = 0; i < reportArr.length; i++) {
            reportArr[i] = reportList.get(i);
        }
        return reportArr;
    }

    public Report[] getReportsMap() {
        Report[] reportArr = new Report[reportList.size()];
        for (int i = 0; i < reportArr.length; i++) {
            reportArr[i] = reportList.get(i);
        }
        return reportArr;
    }

}
