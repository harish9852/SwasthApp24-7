 package com.Swasth24_7;

import java.util.Scanner;

public class OPD {

    private OPDdetails opdDetails;

    // ================= ENTRY METHOD =================
    public OPDdetails meth1(Patient patient) {

        Scanner scn = new Scanner(System.in);
        boolean opdRunning = true;

        while (opdRunning) {

            System.out.println("\n                               ******** OPD DEPARTMENT ********");
            System.out.println("                               1. PHYSICIAN");
            System.out.println("                               2. NEUROLOGY");
            System.out.println("                               3. ORTHOPEDICS");
            System.out.println("                               4. GYNECOLOGIST");
            System.out.println("                               5. DERMATOLOGY");
            System.out.println("                               0. Back to Main Menu");
            System.out.print("                               Select Option: ");

            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice) {

                case 1:
                    initOPDIfRequired(patient);
                    visitOPD(scn, "PHYSICIAN", 500);
                    break;

                case 2:
                    initOPDIfRequired(patient);
                    visitOPD(scn, "NEUROLOGY", 900);
                    break;

                case 3:
                    initOPDIfRequired(patient);
                    visitOPD(scn, "ORTHOPEDICS", 400);
                    break;

                case 4:
                    initOPDIfRequired(patient);
                    visitOPD(scn, "GYNECOLOGIST", 500);
                    break;

                case 5:
                    initOPDIfRequired(patient);
                    visitOPD(scn, "DERMATOLOGY", 800);
                    break;

                case 0:
                    opdRunning = false;
                    break;

                default:
                    System.out.println("                               ❌ Invalid option");
            }
        }

        return opdDetails; // ✅ CORRECT RETURN
    }

    // ================= INIT ONCE =================
    private void initOPDIfRequired(Patient patient) {

        if (opdDetails == null) {
            opdDetails = new OPDdetails();

            // 🔥 PATIENT DATA YAHI SET HOGA (ONCE)
            opdDetails.setPatientId(patient.getpId());
            opdDetails.setPatientName(patient.getPatientName());
            opdDetails.setMobile(patient.getMobileNumber());
        }
    }

    // ================= VISIT =================
    private void visitOPD(Scanner scn, String dept, double fee) {

        System.out.println("\n                               ***** " + dept + " OPD *****");

        printPatient();

        System.out.print("                               Enter Doctor Name: ");
        String doctorName = scn.nextLine();

        opdDetails.addOPD(dept, fee);

        System.out.println("\n                               --- OPD SLIP ---");
        System.out.println("                               Doctor     : " + doctorName);
        System.out.println("                               Department : " + dept);
        System.out.println("                               Fee        : ₹" + fee);

        printOPDSummary();
    }

    // ================= PATIENT =================
    private void printPatient() {

        System.out.println("                               Patient ID   : " + opdDetails.getPId());
        System.out.println("                               Patient Name : " + opdDetails.getPatientName());
        System.out.println("                               Mobile       : " + opdDetails.getMobile());
    }

    // ================= SUMMARY =================
    private void printOPDSummary() {

        System.out.println("\n                               --- OPD SUMMARY ---");
        System.out.println("                               Physician Visits   : " + opdDetails.getPhysicianCount());
        System.out.println("                               Neurology Visits   : " + opdDetails.getNeurologyCount());
        System.out.println("                               Orthopedic Visits  : " + opdDetails.getOrthopedicCount());
        System.out.println("                               Gynecology Visits  : " + opdDetails.getGynecologyCount());
        System.out.println("                               Dermatology Visits : " + opdDetails.getDermatologyCount());
        System.out.println("                               TOTAL OPD BILL     : ₹" + opdDetails.getTotalAmount());
    }
}
