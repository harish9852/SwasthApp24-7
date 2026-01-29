 package com.Swasth24_7;
import java.util.Scanner;

public class Swasth247App {

    static Scanner scn = new Scanner(System.in);
    static OPDdetails opdDetails = null;
    static Warddetails wardDetails = null;
    static LABORATORYdetails laboratoryDetails = null; 
    static PHARMACYdetails pharmacyDetails = null;
    static GOV_SCHEMEdetails govSchemeDetails = null;

    public static void main(String[] args) {
        printWelcome();
        Patient patient = patientRegistration();
        showMenu(patient);
    }

    // 🔹 WELCOME
    static void printWelcome() {  
        System.out.println(
            "◢█████████████████████████████████████████████████████████████████████████████████◣\n" +
            "█                                                                               █\n" +
            "█                ❤️  WELCOME TO  S W A S T H  2 4 / 7  ❤️                        █\n" +
            "█                                                                               █\n" +
            "█          Your Health. Your Safety. Our Responsibility.                        █\n" +
            "█                                                                               █\n" +
            "◣████████████████████████████████████████████████████████████████████████████████◢"
        );
    }
    
    // 🔹 PATIENT REGISTRATION
    static Patient patientRegistration() {

        System.out.print("                            Enter Patient Name: ");
        String name = scn.nextLine();

        System.out.print("                            Enter Mobile Number: ");
        String mobile = scn.nextLine();

        if (mobile.length() != 10) {
            System.out.println("                            Invalid Phone Number");
            System.exit(0);
        }

        String generatedOtp = OtpService.generateOtp();
        System.out.println("                            OTP Sent (Fake): " + generatedOtp);

        System.out.print("                            Enter OTP: ");
        String enteredOtp = scn.next();

        if (!generatedOtp.equals(enteredOtp)) {
            System.out.println("                            Invalid OTP. Registration Failed.");
            System.exit(0);
        }

        System.out.print("                            Government Scheme Eligible? (true/false): ");
        Boolean govEligible = scn.nextBoolean();

        Patient patient = new Patient(
            "P1001",
            name,
            mobile,
            generatedOtp,
            govEligible
        );

        System.out.println("                            --------------------------------");
        System.out.println("                            Patient Registered Successfully");
        System.out.println("                            Patient ID: " + patient.getpId());
        System.out.println("                            --------------------------------");

        return patient;
    }

    // 🔹 MENU
    static void showMenu(Patient patient) {

        while (true) {

            System.out.println("\n================================SYSTEM MENU================================");
            System.out.println("                                  1. Main Menu");
            System.out.println("                                  2. Exit");
            System.out.print("                                    Select Option: ");

            int num = scn.nextInt();

            switch (num) {

            case 1:
                boolean submenu = true;

                while (submenu) {

                    System.out.println("                            1. OPD");
                    System.out.println("                            2. WARD");
                    System.out.println("                            3. LABORATORY");
                    System.out.println("                            4. PHARMACY");
                    System.out.println("                            5. GOV_SCHEME");
                    System.out.println("                            6. HOSPITAL BILLING");
                    System.out.println("                            0. Start Menu");
                    System.out.print("                             Select Option: ");

                    int num1 = scn.nextInt();

                    switch (num1) {

                    case 1:
                        OPD opd = new OPD();
                        if (opdDetails == null) opdDetails = new OPDdetails();
                        opdDetails = opd.meth1(patient); // null-safe
                        break;

                    case 2:
                        WARD ward = new WARD();
                        if (wardDetails == null) wardDetails = new Warddetails();
                        ward.meth1(wardDetails, patient); // null-safe
                        break;

                     
                    case 3:
                        LABORATORY lab = new LABORATORY();
                        if (laboratoryDetails == null) laboratoryDetails = new LABORATORYdetails();
                        lab.meth1(laboratoryDetails, patient); // null-safe
                        break;

                    case 4:
                        PHARMACY ph = new PHARMACY();
                        if (pharmacyDetails == null) pharmacyDetails = new PHARMACYdetails();
                        ph.meth1(pharmacyDetails); // null-safe
                        break;

                    case 5:
                        double grossTotal =
                            (opdDetails != null ? opdDetails.getOPDTOTAL() : 0)
                          + (wardDetails != null ? wardDetails.getWardTotal() : 0)
                          + (laboratoryDetails != null ? laboratoryDetails.getLabTotal() : 0)
                          + (pharmacyDetails != null ? pharmacyDetails.getPharmacyTotal() : 0);

                        if (govSchemeDetails == null) govSchemeDetails = new GOV_SCHEMEdetails();
                        GOV_SCHEME gc = new GOV_SCHEME();
                        gc.meth1(govSchemeDetails, grossTotal);
                        break;

                    case 6:
                        HospitalBilling billing = new HospitalBilling(
                                opdDetails,
                                wardDetails,
                                laboratoryDetails,
                                pharmacyDetails,
                                govSchemeDetails
                        );
                        billing.printFinalBill();
                        return;

                    case 0:
                        submenu = false;
                        break;

                    default:
                        System.out.println("                            Oops! Please select correct option");
                    }
                }
                break;

            case 2:
                System.out.println("                            Thanks for registering with Swasth24-7 🙏");
                System.exit(0);
            }
        }
    }
}
