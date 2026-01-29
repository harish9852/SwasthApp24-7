 package com.Swasth24_7;

public class PHARMACYdetails {

    // ================= PATIENT DETAILS =================
    private String patientId;
    private String patientName;
    private String mobile;

    // ================= MEDICINE QTY =================
    private int paracetamolQty;
    private int antibioticQty;
    private int syrupQty;

    // ================= TOTAL =================
    private double pharmacyTotal;

    // ================= ADD MEDICINE =================
    public void addMedicine(String name, int qty, double price) {

        if (name.equalsIgnoreCase("Paracetamol")) {
            paracetamolQty += qty;
        } else if (name.equalsIgnoreCase("Antibiotic")) {
            antibioticQty += qty;
        } else if (name.equalsIgnoreCase("Vitamin Syrup")) {
            syrupQty += qty;
        }

        pharmacyTotal += qty * price;
    }

    // ================= GETTERS =================
    public double getPharmacyTotal() {
        return pharmacyTotal;
    }

    public int getParacetamolQty() {
        return paracetamolQty;
    }

    public int getAntibioticQty() {
        return antibioticQty;
    }

    public int getSyrupQty() {
        return syrupQty;
    }

    // ================= PATIENT SETTERS =================
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    // ================= PATIENT GETTERS =================
    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getMobile() {
        return mobile;
    }
}
