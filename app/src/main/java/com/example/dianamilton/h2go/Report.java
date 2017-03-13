package com.example.dianamilton.h2go;

import android.widget.Spinner;
import java.util.Date;

/**
 * Created by dianamilton on 3/2/17.
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


    /**
     * Getter for contaminant PPM
     * @return contaminentPPM
     */
    public String getContaminentPPM() {
        return contaminentPPM;
    }


    /**
     * Setter for contaminent PPM
     * @param contaminentPPM
     */
    public void setContaminentPPM(String contaminentPPM) {
        this.contaminentPPM = contaminentPPM;
    }


    /**
     * Getter for virus PPM
     * @return virusPPM
     */
    public String getVirusPPM() {
        return virusPPM;
    }

    /**
     * Setter for virus PPM
     * @param virusPPM
     */
    public void setVirusPPM(String virusPPM) {
        this.virusPPM = virusPPM;
    }

    /**
     * Getter for date
     * @return date
     */
    public Date getDate() { return date; }

    /**
     * Getter for report number
     * @return reportNum
     */
    public int getId() { return reportNum; }

    /**
     * Setter for report number
     * @param reportNum
     */
    public void setId(int reportNum) { this.reportNum = reportNum; }
    public String getName() { return name; }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Getter for latitude
     * @return latitude
     */
    public String getLat() { return latitude; }

    /**
     * Setter for lattitude
     * @param latitude
     */
    public void setLat(String latitude) { this.latitude = latitude; }

    /**
     * Getter for longitude
     * @return longitude
     */
    public String getLong() { return longitude; }

    /**
     * Setter for longitude
     * @param longitude
     */
    public void setLong(String longitude) { this.longitude = longitude; }

    /**
     * Getter for type of water
     * @return type
     */
    public String getType() { return typeWater; }

    /**
     * Setter for type of water
     * @param typeWater
     */
    public void setType(String typeWater) { this.typeWater = typeWater; }

    /**
     * Getter for condition
     * @return condition
     */
    public String getCondition() { return condition; }

    /**
     * Setter for condition
     * @param condition
     */
    public void setCondition(String condition) { this.condition = condition; }


    /**
     * What to print out in listview
     * @return information that makes up a report
     */
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

    /**
     * Getter for worker name submitting report
     * @return worker name
     */
    public String getWorkerName() {
        return workerName;
    }

    /**
     * Setter for worker name
     * @param workerName
     */
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }
}
