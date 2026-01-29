 package com.Swasth24_7;

public class LABORATORYdetails {

    private String patientId;
    private String patientName;
    private String mobile;

    private double labTotal;

    public void addTest(String test, double amount) {
        labTotal += amount;
    }

    public double getLabTotal() {
        return labTotal;
    }

    // getters & setters
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
}
