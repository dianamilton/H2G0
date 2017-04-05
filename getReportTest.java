package com.example.dianamilton.h2go;
 
 
        import static org.junit.Assert.*;
 
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
 
 
public class junitTest {
    private Report[] reports = new Report[4];
    private ReportList reportsList = new ReportList();
 
 
    @Before
    public void setUp() {
        Report report1 = new Report();
        report1.setCondition("c1");
        report1.setType("t1");
        report1.setLong("33");
        report1.setLat("33");
        report1.setName("r1");
        report1.setId(1);
        report1.setVirusPPM("v1");
        report1.setContaminentPPM("cc1");
 
 
        Report report2 = new Report();
        report1.setCondition("c2");
        report1.setType("t2");
        report1.setLong("22");
        report1.setLat("22");
        report1.setName("r2");
        report1.setId(2);
        report1.setVirusPPM("v2");
        report1.setContaminentPPM("cc2");
 
 
        Report report3 = new Report();
        report1.setCondition("c3");
        report1.setType("t3");
        report1.setLong("11");
        report1.setLat("11");
        report1.setName("r3");
        report1.setId(3);
        report1.setVirusPPM("v3");
        report1.setContaminentPPM("cc3");
 
 
        Report report4 = new Report();
        report1.setCondition("c4");
        report1.setType("t4");
        report1.setLong("44");
        report1.setLat("44");
        report1.setName("r4");
        report1.setId(4);
        report1.setVirusPPM("v4");
        report1.setContaminentPPM("cc4");
 
        reports[0] = report1;
        reports[1] = report2;
        reports[2] = report3;
        reports[3] = report4;
 
 
 
        reportsList.addReport(report1);
        reportsList.addReport(report2);
        reportsList.addReport(report3);
        reportsList.addReport(report4);
    }
 
 
    @Test
    public void testReports() {
 
        Report[] newReportArray = reportsList.getReport();
 
        assertArrayEquals(newReportArray, reports);
 
 
 
    }
 
}