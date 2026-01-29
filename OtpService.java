 package com.Swasth24_7;

import java.util.Random;

public class OtpService {

    public static String generateOtp() {
        Random random = new Random();
        String otp = "";

        for (int i = 1; i <= 4; i++) {
            otp += random.nextInt(10);
        }
        return otp;
    }
}