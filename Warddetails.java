 package com.Swasth24_7;

public class Warddetails {

    private String pId;
    private String patientName;
    private String mobileNumber;

    private int icuDays;
    private int micuDays;
    private int generalDays;
    private double totalAmount;

    // ================= SETTERS =================
    public void setpId(String pId) {
        this.pId = pId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // ================= GETTERS =================
    public String getpId() {
        return pId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    // ================= WARD LOGIC =================
    public void addWard(String type, int days, double chargePerDay) {
    	String t = type.trim().toUpperCase();   // trim & uppercase
        switch (type.trim()) {
            case "ICU":
                icuDays += days;
                break;

            case "MICU":
                micuDays += days;
                break;

            case "GENERAL":
                generalDays += days;
                break;
        }

        totalAmount += days * chargePerDay;
    }

    // ================= SUMMARY =================
    public int getIcuDays() {
        return icuDays;
    }

    public int getMicuDays() {
        return micuDays;
    }

    public int getGeneralDays() {
        return generalDays;
    }

    public double getWardTotal() {
        return totalAmount;
    }
}
