 package com.Swasth24_7;

import java.util.Scanner;

public class PHARMACY {

    void meth1(PHARMACYdetails pharmacyDetails) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\n                            ********** PHARMACY DEPARTMENT **********");
            System.out.println("                            1. Paracetamol (₹10)");
            System.out.println("                            2. Antibiotic (₹50)");
            System.out.println("                            3. Vitamin Syrup (₹80)");
            System.out.println("                            4. Exit Pharmacy");
            System.out.print("                            Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("                            Enter quantity: ");
                    int q1 = sc.nextInt();
                    pharmacyDetails.addMedicine("                            Paracetamol", q1, 10);
                    break;

                case 2:
                    System.out.print("                            Enter quantity: ");
                    int q2 = sc.nextInt();
                    pharmacyDetails.addMedicine("                            Antibiotic", q2, 50);
                    break;

                case 3:
                    System.out.print("                            Enter quantity: ");
                    int q3 = sc.nextInt();
                    pharmacyDetails.addMedicine("                            Vitamin Syrup", q3, 80);
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("                            Invalid choice");
            }
        }
    }
}
