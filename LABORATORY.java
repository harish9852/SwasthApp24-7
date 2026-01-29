 package com.Swasth24_7;

import java.util.Scanner;

public class LABORATORY {

    public void meth1(LABORATORYdetails labDetails, Patient patient) {

        Scanner scn = new Scanner(System.in);
        boolean labRunning = true;

        // 🔒 patient data ek hi baar set hoga
        if (labDetails.getPatientId() == null) {
            labDetails.setPatientId(patient.getpId());
            labDetails.setPatientName(patient.getPatientName());
            labDetails.setMobile(patient.getMobileNumber());
        }

        while (labRunning) {

            System.out.println("\n                               ******** LABORATORY DEPARTMENT ********");
            System.out.println("                               1. Blood Test");
            System.out.println("                               2. X-Ray");
            System.out.println("                               3. MRI");
            System.out.println("                               4. CT Scan");
            System.out.println("                               0. Back to Main Menu");
            System.out.print("                               Select Option: ");

            int choice = scn.nextInt();

            switch (choice) {

                case 1:
                    labDetails.addTest("Blood Test", 400);
                    break;

                case 2:
                    labDetails.addTest("X-Ray", 600);
                    break;

                case 3:
                    labDetails.addTest("MRI", 3000);
                    break;

                case 4:
                    labDetails.addTest("CT Scan", 2500);
                    break;

                case 0:
                    labRunning = false;
                    break;

                default:
                    System.out.println("                               ❌ Invalid Option");
            }

            printSummary(labDetails);
        }
    }

    private void printSummary(LABORATORYdetails d) {

        System.out.println("\n                               --- LAB SUMMARY ---");
        System.out.println("                               Patient ID   : " + d.getPatientId());
        System.out.println("                               Patient Name : " + d.getPatientName());
        System.out.println("                               Mobile       : " + d.getMobile());
        System.out.println("                               Total Amount : ₹" + d.getLabTotal());
    }
}
