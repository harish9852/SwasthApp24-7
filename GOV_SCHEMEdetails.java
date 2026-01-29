 package com.Swasth24_7;

public class GOV_SCHEMEdetails {

    private boolean schemeApplied;
    private double discountPercentage;
    private double discountAmount;
    private double finalPayable;

    // ✅ Billing calculation (ONLY LOGIC – no input/output)
    public void calculateFinalAmount(double grossTotal) {

        if (schemeApplied) {
            discountAmount = grossTotal * discountPercentage / 100;
            finalPayable = grossTotal - discountAmount;
        } else {
            discountAmount = 0;
            finalPayable = grossTotal;
        }
    }

    // ================= GETTERS & SETTERS =================

    public boolean isSchemeApplied() {
        return schemeApplied;
    }

    public void setSchemeApplied(boolean schemeApplied) {
        this.schemeApplied = schemeApplied;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getFinalPayable() {
        return finalPayable;
    }

	public Object getSchemeType() {
		// TODO Auto-generated method stub
		return null;
	}
}
