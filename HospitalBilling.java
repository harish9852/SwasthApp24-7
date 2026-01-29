 package com.Swasth24_7;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HospitalBilling {

    private OPDdetails opd;
    private LABORATORYdetails lab;
    private PHARMACYdetails pharmacy;
    private Warddetails ward;
    private GOV_SCHEMEdetails scheme;

    public HospitalBilling(
            OPDdetails opd,
            Warddetails ward,
            LABORATORYdetails lab,
            PHARMACYdetails pharmacy,
            GOV_SCHEMEdetails scheme
    ) {
        this.opd = opd;
        this.ward = ward;
        this.lab = lab;
        this.pharmacy = pharmacy;
        this.scheme = scheme;
    }

    public void printFinalBill() {

        double grossTotal =
                (opd != null ? opd.getOPDTOTAL() : 0)
              + (lab != null ? lab.getLabTotal() : 0)
              + (pharmacy != null ? pharmacy.getPharmacyTotal() : 0)
              + (ward != null ? ward.getWardTotal() : 0);

        if (scheme != null) {
            scheme.calculateFinalAmount(grossTotal);
        }
 
                System.out.println("                            ====================================================");
                System.out.println("                                     🏥 SWASTH 24/7 – FINAL HOSPITAL BILL");
                System.out.println("                            ====================================================");
                //System.out.println("                            Date : " + getCurrentDate());
                //System.out.println("                            Time : " + getCurrentTime());
                System.out.println("                             Date : " + getCurrentDate() + "        Time : " + getCurrentTime());
                System.out.println("                            ----------------------------------------------------");

                // ================= PATIENT DETAILS =================
                printPatientDetails();

                // ================= OPD =================
                if (opd != null) {
                    System.out.println("\n                            🔹 OPD DETAILS");
                    System.out.println("                            OPD Total    : ₹" + opd.getOPDTOTAL());
                    System.out.println("                            ----------------------------------------------------");
                }

                // ================= WARD =================
                if (ward != null) {
                    System.out.println("\n                            🔹 WARD DETAILS");
                    System.out.println("                            Ward Total   : ₹" + ward.getWardTotal());
                    System.out.println("                            ----------------------------------------------------");
                }

                // ================= LAB =================
                if (lab != null) {
                    System.out.println("\n                            🔹 LAB DETAILS");
                    System.out.println("                            Lab Total    : ₹" + lab.getLabTotal());
                    System.out.println("                            ----------------------------------------------------");
                }

                // ================= PHARMACY =================
                if (pharmacy != null) {
                    System.out.println("\n                            🔹 PHARMACY DETAILS");
                    System.out.println("                            Pharmacy Total : ₹" + pharmacy.getPharmacyTotal());
                    
                    //System.out.println("                            ----------------------------------------------------");
                 System.out.println();
                }

                // ================= TOTAL =================
                System.out.println("\n                            ====================================================");
                System.out.println("                            TOTAL AMOUNT : ₹" + grossTotal);
                //System.out.println("                            ----------------------------------------------------");
                 System.out.println();
                System.out.println("                           =============== 🏛 GOVERNMENT SCHEME ==============");
                if (scheme != null && scheme.isSchemeApplied()) {
                    System.out.println("                            Scheme Applied : YES");
                    System.out.println("                            Discount       : ₹" + scheme.getDiscountAmount());
                }

                System.out.println("                           💰 FINAL PAYABLE AMOUNT: ₹"
                        + (scheme != null ? scheme.getFinalPayable() : grossTotal));
                System.out.println("                            ====================================================");
                System.out.println("                            🙏 Thank You – Get Well Soon");
                System.out.println("                            ====================================================");
            }

            // ================= PATIENT FETCH LOGIC =================
            private void printPatientDetails() {

                if (opd != null) {
                    System.out.println("                            Patient Name : " + opd.getPatientName());
                    System.out.println("                            Patient ID   : " + opd.getPId());
                    System.out.println("                            Mobile No    : " + opd.getMobile());
                } else if (lab != null) {
                    System.out.println("                            Patient Name : " + lab.getPatientName());
                    System.out.println("                            Patient ID   : " + lab.getPatientId());
                    System.out.println("                            Mobile No    : " + lab.getMobile());
                } else if (pharmacy != null) {
                    System.out.println("                            Patient Name : " + pharmacy.getPatientName());
                    System.out.println("                            Patient ID   : " + pharmacy.getPatientId());
                    System.out.println("                            Mobile No    : " + pharmacy.getMobile());
                }

                System.out.println("                            ----------------------------------------------------");
            }

             
 private String getCurrentDate() {
            return LocalDate.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }

        // ================= TIME =================
        private String getCurrentTime() {
            return LocalTime.now()
                    .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
    }
