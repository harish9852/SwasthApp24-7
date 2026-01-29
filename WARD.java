 package com.Swasth24_7;

import java.util.Scanner;

public class WARD {

    private Warddetails wd;   // single Warddetails instance

    // ================= ENTRY =================
    public Warddetails meth1(Warddetails wardDetails, Patient patient) {

        if (wardDetails == null) {
            wardDetails = new Warddetails();
            wardDetails.setpId(patient.getpId());
            wardDetails.setPatientName(patient.getPatientName());
            wardDetails.setMobileNumber(patient.getMobileNumber());
        }

        this.wd = wardDetails;   // reference safe

        Scanner scn = new Scanner(System.in);
        boolean wardRunning = true;

        while (wardRunning) {
            System.out.println("\n                               ********WARD DEPARTMENT********");
            System.out.println("                               1. ICU WARD");
            System.out.println("                               2. MICU WARD");
            System.out.println("                               3. GENERAL WARD");
            System.out.println("                               0. Back to Main Menu");
            System.out.print("                                 Please Select Option: ");

            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice) {
                case 1:
                    initWardIfRequired(patient);
                    icuWard(scn, wd);
                    break;
                case 2:
                    initWardIfRequired(patient);
                    micuWard(scn, wd);
                    break;
                case 3:
                    initWardIfRequired(patient);
                    generalWard(scn, wd);
                    break;
                case 0:
                    wardRunning = false;
                    break;
                default:
                    System.out.println("                            ❌ Invalid option, try again.");
            }
        }
        return wd;
    }

    // ================= INIT ONCE =================
    private void initWardIfRequired(Patient patient) {
        if (wd.getPatientName() == null) { // only init once
            wd.setpId(patient.getpId());
            wd.setPatientName(patient.getPatientName());
            wd.setMobileNumber(patient.getMobileNumber());
        }
    }

    // ================= ICU =================
    private void icuWard(Scanner scn, Warddetails wardDetails) {
        System.out.println("\n                               ***** ICU WARD *****");
        printPatient(wardDetails);

        System.out.print("                               Enter No of ICU Days: ");
        int days = scn.nextInt();
        scn.nextLine();

        double chargePerDay = 1000;
        wardDetails.addWard("ICU", days, chargePerDay); // no extra spaces

        printWardSlip(wardDetails);
    }

    // ================= MICU =================
    private void micuWard(Scanner scn, Warddetails wardDetails) {
        System.out.println("\n                               ***** MICU WARD *****");
        printPatient(wardDetails);

        System.out.print("                               Enter No of MICU Days: ");
        int days = scn.nextInt();
        scn.nextLine();

        double chargePerDay = 800;
        wardDetails.addWard("MICU", days, chargePerDay);

        printWardSlip(wardDetails);
    }

    // ================= GENERAL =================
    private void generalWard(Scanner scn, Warddetails wardDetails) {
        System.out.println("\n                               ***** GENERAL WARD *****");
        printPatient(wardDetails);

        System.out.print("                               Enter No of GENERAL Days: ");
        int days = scn.nextInt();
        scn.nextLine();

        double chargePerDay = 500;
        wardDetails.addWard("GENERAL", days, chargePerDay);

        printWardSlip(wardDetails);
    }

    // ================= COMMON =================
    private void printPatient(Warddetails wardDetails) {
        System.out.println("                               Patient ID    : " + wardDetails.getpId());
        System.out.println("                               Patient Name  : " + wardDetails.getPatientName());
        System.out.println("                               Mobile Number : " + wardDetails.getMobileNumber());
    }

    private void printWardSlip(Warddetails wardDetails) {
        System.out.println("\n                               --- WARD SUMMARY ---");
        System.out.println("                               ICU Days     : " + wardDetails.getIcuDays());
        System.out.println("                               MICU Days    : " + wardDetails.getMicuDays());
        System.out.println("                               GENERAL Days : " + wardDetails.getGeneralDays());
        System.out.println("                               Total Amount : ₹" + wardDetails.getWardTotal());
    }
}
