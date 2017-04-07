package com.example.dianamilton.h2go;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Add Report Test from ReportList.java
* @author Christina Bui
* @version 1.0
**/


public class AddReportTest {
	private Report[] reports = new Reports[5];
	private ReportList reportlist = new ReportList();


	@Before
	public void setUp() {
		Report report1 = new Report;
		report1.setContaminentPPM("Mild");
		report1.setVirusPPM("Treatable");
		report1.setID(1);
		report1.setName("John");
		report1.setLat("1");
		report1.setLong("1");
		report1.setType("Well");
		report1.setCondition("Waste");
		report1.setWorkerName("Bob");

		Report report2 = new Report;
		report2.setContaminentPPM("Medium");
		report2.setVirusPPM("Treatable");
		report2.setID(2);
		report2.setName("Joel");
		report2.setLat("2");
		report2.setLong("2");
		report2.setType("Bottled");
		report2.setCondition("Treatable - Clear");
		report2.setWorkerName("Jack");

		Report report3 = new Report;
		report3.setContaminentPPM("");
		report3.setVirusPPM("");
		report3.setID(0);
		report3.setName("Mel");
		report3.setLat("");
		report3.setLong("");
		report3.setType("");
		report3.setCondition("");
		report3.setWorkerName("");

		Report report4 = new Report;
		report4.setContaminentPPM("");
		report4.setVirusPPM("");
		report4.setID(0);
		report4.setName("Jill");
		report4.setLat("");
		report4.setLong("43");
		report4.setType("");
		report4.setCondition("");
		report4.setWorkerName("Kate");

		Report report5 = new Report;
		report5.setContaminentPPM("Large");
		report5.setVirusPPM("High");
		report5.setID(0);
		report5.setName("Billy");
		report5.setLat("xxxxxxxxxxxxxxx");
		report5.setLong("iiiiiiiiiiii");
		report5.setType("Stream");
		report5.setCondition("Treatable - Clear");
		report5.setWorkerName("Molly");

		reports[0] = report1;
		reports[1] = report2;
		reports[2] = report3;
		reports[3] = report4;
		reports[4] = report5;
		reportList.addReport(report1);
		reportList.addReport(report2);
		reportList.addReport(report3);
		reportList.addReport(report4);
		reportList.addReport(report5);
	}

	@Test
	public void testAddReport() {

		for(int i = 0; i < reports.length; i++) {
			Report currRep = reports[i];
			if(report[i].getName() == "") {
				Assert.assertFalse("Name cannot be empty.", reports.getReport());
			}
			if(report[i].getWorkerName() == "") {
				Assert.assertFalse("Worker name cannot be empty.", reports.getReport());
			}
			if(report[i].getVirusPPM() == "") {
				Assert.assertFalse("Virus PPM cannot be empty.", reports.getReport());
			}
			if(report[i].getContaminentPPM() == "") {
				Assert.assertFalse("Contaminent PPM cannot be empty.", reports.getReport());
			}
			if(report[i].getID() <= 0) {
				Assert.assertFalse("ID must be a number greater than 0.", reports.getReport());
			}
			if(report[i].getLat() == "") {
				Assert.assertFalse("Latitude cannot be empty.", reports.getReport());
			}
			if(!(isNumeric(report[i].getLat())) {
				Assert.assertFalse("Latitude should contain numbers.", reports.getReport());
			}
			if(report[i].getLong() == "") {
				Assert.assertFalse("Longitude cannot be empty.", reports.getReport());
			}
			if(!(isNumeric(report[i].getLong())) {
				Assert.assertFalse("Longitude should contain numbers.", reports.getReport());
			}
			if(report[i].getType() == "") {
				Assert.assertFalse("Water type cannot be empty.", reports.getReport());
			}
			if(report[i].getCondition() == "") {
				Assert.assertFalse("Water condition cannot be empty.", reports.getReport());
			}
			if(!(report[i].getType() == "Bottled") || !(report[i].getType() == "Well")
				|| !(report[i].getType() == "Stream") || !(report[i].getType() == "Lake")
				|| !(report[i].getType() == "Spring") || !(report[i].getType() == "Other")) {
				Assert.assertFalse("Not a valid water type.", reports.getReport());
			}
			if(!(report[i].getCondition() == "Waste") || !(report[i].getCondition() == "Treatable - Clear")
				|| !(report[i].getCondition() == "Treatable - Muddy") || !(report[i].getCondition() == "Potable")) {
				Assert.assertFalse("Not a valid water condition.", reports.getReport());
			}
		}
	}
}



//Checks if there are numbers in a string.
public static boolean isNumeric(String str)  
{  
  try  
  {  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}