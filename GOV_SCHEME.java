  package com.Swasth24_7;
import java.util.Scanner;

public class GOV_SCHEME {

    void meth1(GOV_SCHEMEdetails scheme, double grossTotal) {

    	if ( scheme == null) {
    		scheme = new  GOV_SCHEMEdetails(); // ✅ ensure object exists
        }
    	Scanner scn = new Scanner(System.in);
        boolean governing = true;

        while (governing) {

            System.out.println("\n                               ********** GOV_SCHEME **********");
            System.out.println("                               1. Aaushman card(50%)");
            System.out.println("                               2. PMY(20%)");
            System.out.println("                               3. Others");
            System.out.println("                               0. Back to Main Menu");
            System.out.print("                               Select option: ");

            int choice = scn.nextInt();
            scn.nextLine();

            switch (choice) {

                case 1:
                    Aaushmancard(scn);
                    scheme.setSchemeApplied(true);
                    scheme.setDiscountPercentage(50);
                    governing = false;
                    break;

                case 2:
                    pmyCard(scn);
                    scheme.setSchemeApplied(true);
                    scheme.setDiscountPercentage(20);
                    governing = false;
                    break;

                case 3:
                    scheme.setSchemeApplied(false);
                    governing = false;
                    break;

                case 0:
                    governing = false;
                    System.out.println("                               Back to Main Menu");
                    break;

                default:
                    System.out.println("                               Invalid option");
            }
        }

        scheme.calculateFinalAmount(grossTotal); // ✅ SAME object updated
    }

    private void Aaushmancard(Scanner scn) {

        System.out.println("\n                               ***** AAYUSH CARD *****");

        System.out.print("                               Enter HospitalAaushInchare Name: ");
        String HospitalAaushInchare = scn.nextLine();

        System.out.print("                               Enter Patient Name : ");
        String patientName = scn.nextLine();

        System.out.print("                               Enter Patient Age: ");
        int age = scn.nextInt();
        scn.nextLine();

        System.out.println("\n                               ----- AAYUSH SLIP -----");
        System.out.println("                               AayushIncharge : " + HospitalAaushInchare);
        System.out.println("                               Patient Name   : " + patientName);
        System.out.println("                               Patient Age    : " + age);
    }

    private void pmyCard(Scanner scn) {

        System.out.println("\n                               ***** PMY CARD *****");

        System.out.print("                               Enter HospitalPmyInchare Name: ");
        String HospitalPmyInchare = scn.nextLine();

        System.out.print("                               Enter Patient Name : ");
        String patientName = scn.nextLine();

        System.out.print("                               Enter Patient Age: ");
        int age = scn.nextInt();
        scn.nextLine();

        System.out.println("\n                               ----- PMY SLIP -----");
        System.out.println("                               PMYIncharge : " + HospitalPmyInchare);
        System.out.println("                               Patient Name : " + patientName);
        System.out.println("                               Patient Age  : " + age);
    }
}
