package com.company;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        equationAction();
    }

    public static void equationAction() {
        Scanner scanner = new Scanner(System.in);
        String userEquation = scanner.nextLine();
        checkUserEquation(userEquation);
        if (!checkUserEquation(userEquation)) {
            System.out.println("Your equation is not correct");
        } else {
            System.out.println(checkUserEquation(userEquation));
            int numberA = aExtractor(userEquation);
            int numberB = bExtractor(userEquation);
            int numberC = cExtractor(userEquation);
            System.out.println(equationSolver(numberA, numberB, numberC));
        }
    }

    public static String equationSolver(int a, int b, int c) {

        String solution = "";
        double delta = Math.sqrt(b*b-4*a*c);
        if (delta < 0) {
            System.out.println("Invalid solution.");
        }
        double firstRoot = ((-b) + (delta)) / (2 * a);
        double secondRoot = ((-b) - (delta)) / (2 * a);
        if (secondRoot == secondRoot) {
            System.out.println("There is one solution: " + firstRoot);
        } else {
            solution = "X1: " + firstRoot + ", X2:" + (secondRoot);
        }
        return solution;
    }

    public static boolean checkUserEquation(String userEquation) {
        if (!userEquation.contains("x^2") || !userEquation.contains("=0")) {
            return false;
        }
        int index = userEquation.indexOf("=0");
        userEquation = userEquation.substring(0, index);
        index = userEquation.indexOf("x^2");
        String a = userEquation.substring(0, index);
        if ((a.charAt(0) == '+' || a.charAt(0) == '-') && a.length() == 1) {
            a = a + 1;
        }
        userEquation = userEquation.substring(index + 3);
        index = userEquation.indexOf("x");
        String b = userEquation.substring(0, index);
        if ((b.charAt(0) == '+' || b.charAt(0) == '-') && b.length() == 1) {
            b = b + 1;
        }
        String c = userEquation.substring(index + 1);
        if ((c.charAt(0) == '+' || c.charAt(0) == '-') && c.length() == 1) {
            c = c + 1;
        }
        if (isNumeric(a) && isNumeric(b) && isNumeric(c)) {
            return true;
        } else {
            return false;
        }
    }

    public static int aExtractor(String userEquation) {
        int aIndex = userEquation.indexOf("x^2");
        userEquation = userEquation.substring(0, aIndex);
        int aNumber = Integer.parseInt(userEquation);
        System.out.println(aNumber);
        return aNumber;
    }

    public static int bExtractor(String userEquation) {
        int index = userEquation.indexOf("x^2");
        userEquation = userEquation.substring(index + 3);
        index = userEquation.indexOf("x");
        userEquation = userEquation.substring(0, index);
        int bNumber = Integer.parseInt(userEquation);
        System.out.println(bNumber);
        return bNumber;
    }

    public static int cExtractor(String userEquation) {
        int index = userEquation.indexOf("x^2");
        userEquation = userEquation.substring(index + 3);
        index = userEquation.indexOf("x");
        userEquation = userEquation.substring(index + 1, userEquation.length() - 2);
        int cNumber = Integer.parseInt(userEquation);
        System.out.println(cNumber);
        return cNumber;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}