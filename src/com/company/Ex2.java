package com.company;

public class Ex2 {
    public static void main(String[] args) {
        String text1 = "972547473738";
        System.out.println(phoneNumberFixer(text1));


    }


    public static String phoneNumberFixer(String text1) {
        String message;
        int length = text1.length();
        for (int i = 0; i < length; i++) {
            if (text1.charAt(i) > 9 || text1.charAt(i) < 0) {
                message = " ";}
            }  if (text1.length() > 12 || text1.length() < 10) {
                message = " ";
            } else if (text1.length() == 12) {
                String tempPhoneNumber = text1.substring(5, 12);
                message = "054-" + tempPhoneNumber;
            } else if (text1.length() == 10) {
                String tempPhoneNumber2 = text1.substring(3, 10);
                message = "054-" + tempPhoneNumber2;

            } else {
                message = text1;

            }return message;


        }
    }
