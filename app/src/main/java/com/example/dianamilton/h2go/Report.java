package com.example.dianamilton.h2go;

import android.widget.Spinner;
import java.util.Date;

/**
 * Created by dianamilton on 3/2/17.
 */

/**
 * makes report object
 */
public class Report {

    private Date date;
    private int reportNum;
    private String name;
    private String latitude;
    private String longitude;
    private String typeWater;
    private String condition;
    private String virusPPM;
    private String contaminentPPM;
    private String workerName;



    public String getContaminentPPM() {
        return contaminentPPM;
    }

    public void setContaminentPPM(String contaminentPPM) {
        this.contaminentPPM = contaminentPPM;
    }

    public String getVirusPPM() {
        return virusPPM;
    }

    public void setVirusPPM(String virusPPM) {
        this.virusPPM = virusPPM;
    }
    public Date getDate() { return date; }
    public int getId() { return reportNum; }
    public void setId(int reportNum) { this.reportNum = reportNum; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLat() { return latitude; }
    public void setLat(String latitude) { this.latitude = latitude; }
    public String getLong() { return longitude; }
    public void setLong(String longitude) { this.longitude = longitude; }
    public String getType() { return typeWater; }
    public void setType(String typeWater) { this.typeWater = typeWater; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }


    public String toString() {
        if (virusPPM == null) {
            return reportNum + ". Location: " + name + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude + "\n"
                    + "Type: " + typeWater + "\n" + "Condition: " + condition + "\n" + "Name: " + workerName + "\n";
        } else {
            return reportNum + ". Location: " + name + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude + "\n"
                    + "Type: " + typeWater + "\n" + "Condition: " + condition + "\n" + "Virus PPM: " + virusPPM + "\n"
                    +"Contaminant: " + contaminentPPM + "\n" + "Name: " + workerName + "\n";
        }
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }
}
