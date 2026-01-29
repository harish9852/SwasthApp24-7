 package com.Swasth24_7;

public class OPDdetails {

    // ===== PATIENT INFO =====
    private String patientId;
    private String patientName;
    private String mobile;

    // ===== VISIT COUNTS =====
    private int physicianCount;
    private int neurologyCount;
    private int orthopedicCount;
    private int gynecologyCount;
    private int dermatologyCount;

    private double totalAmount;

    // ================= SETTERS =================
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // ================= GETTERS =================
    public String getPId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getMobile() {
        return mobile;
    }

    // ================= OPD LOGIC =================
    public void addOPD(String dept, double fee) {
        String d = dept.trim().toUpperCase();   // trim & uppercase

        switch(d) {
            case "PHYSICIAN":
                physicianCount++;
                break;
            case "NEUROLOGY":
                neurologyCount++;
                break;
            case "ORTHOPEDICS":
                orthopedicCount++;
                break;
            case "GYNECOLOGIST":
                gynecologyCount++;
                break;
            case "DERMATOLOGY":
                dermatologyCount++;
                break;
        }

        totalAmount += fee;
    }

    // ================= SUMMARY GETTERS =================
    public int getPhysicianCount() {
        return physicianCount;
    }

    public int getNeurologyCount() {
        return neurologyCount;
    }

    public int getOrthopedicCount() {
        return orthopedicCount;
    }

    public int getGynecologyCount() {
        return gynecologyCount;
    }

    public int getDermatologyCount() {
        return dermatologyCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getOPDTOTAL() {
        return totalAmount;
    }
}
