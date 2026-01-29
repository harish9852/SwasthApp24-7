 package com.Swasth24_7;

public class Patient {

    private String pId;
    private String patientName;
    private String mobileNumber;
    private String otp;
    private Boolean govSchemeEligible;

    public Patient(String pId, String patientName, String mobileNumber,
                   String otp, Boolean govSchemeEligible) {
        this.pId = pId;
        this.patientName = patientName;
        this.mobileNumber = mobileNumber;
        this.otp = otp;
        this.govSchemeEligible = govSchemeEligible;
    }

    public String getpId() {
        return pId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Boolean getGovSchemeEligible() {
        return govSchemeEligible;
    }

    public String getOtp() {
        return otp;
    }
}
