package com.company;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        programManager();
    }

    public static void programManager() {
        System.out.println("Type quadratic equation: ");
        Scanner scanner = new Scanner(System.in);
        String inputUserOld = scanner.nextLine();
        String inputUser = inputUserOld.replaceAll(" ", "");
        boolean isCorrect;

        isCorrect = isCorrect(inputUser);
        int a;
        int b;
        int c;

        if (isCorrect) {
            a = returnsAValue(inputUser);
            b = returnsBValue(inputUser);
            c = returnsCValue(inputUser);
            quadraticEquationRootsPrinter(a, b, c);
        } else {
            System.out.println("Your input isn't correct");
        }
    }


    public static boolean isCorrect(String inputUser) {
        boolean isCorrect = false;
        String cond1 = "=0";
        String cond2 = "x^2";
        String cond3 = "x+";
        String cond4 = "x-";
        String cond5 = "+x";
        String cond6 = "-x";
        String cond7 = ",";
        String cond8 = ".";
        String cond9 = "x=";
        if (inputUser.contains(cond1) &&
                inputUser.contains(cond2) &&
                inputUser.lastIndexOf("0") == inputUser.length() - 1 &&
                (inputUser.contains(cond3) ||
                        inputUser.contains(cond4) ||
                        inputUser.contains(cond5) ||
                        inputUser.contains(cond6) ||
                        inputUser.contains(cond9))) {
            isCorrect = true;
        } else if (inputUser.contains(cond7) || inputUser.contains(cond8)) {
            return isCorrect;
        }

        return isCorrect;
    }

    public static int returnsAValue(String userEquation) {
        int a;
        if (userEquation.startsWith("-x^2")) {
            a = -1;
        } else if (userEquation.startsWith("x^2")) {
            a = 1;
        } else if (userEquation.startsWith("-")) {
            String aParNegative = "";
            aParNegative += userEquation.substring(0, userEquation.indexOf("x^2"));
            a = Integer.parseInt(aParNegative);
        } else {
            String aParPositive = "";
            aParPositive += userEquation.substring(0, userEquation.indexOf("x^2"));
            a = Integer.parseInt(aParPositive);
        }
        return a;
    }


    public static int returnsBValue(String userEquation) {
        int b=0;
        String bPar = "";
        if (userEquation.contains("x^2+x")) {
            b = 1;
        } else if (userEquation.contains("x^2-x")) {
            b = -1;
        } else if (userEquation.contains("x+")) {
            bPar += userEquation.substring(userEquation.indexOf("x^2") + 3, userEquation.indexOf("x+"));
            b = Integer.parseInt(bPar);
        } else if (userEquation.contains("x-")) {
            bPar += bPar.substring(userEquation.indexOf("x^2") + 3, userEquation.indexOf("x-"));
            b = Integer.parseInt(bPar);
        } else if (userEquation.contains("x=0")) {
            bPar += bPar.substring(userEquation.indexOf("x^2") + 3, userEquation.indexOf("x="));
            b = Integer.parseInt(bPar);
        }
        return b;
    }

    public static int returnsCValue(String userEquation) {
        int c=0;
        String cPar = "";
        if (userEquation.contains("x+")) {
            cPar += userEquation.substring(userEquation.indexOf("x+") + 1, userEquation.indexOf("="));
            c = Integer.parseInt(cPar);
        } else if (userEquation.contains("x-")) {
            cPar += userEquation.substring(userEquation.indexOf("x-") + 1, userEquation.indexOf("="));
            c = Integer.parseInt(cPar);
        }
        return c;
    }


    public static void quadraticEquationRootsPrinter(int a, int b, int c) {
        double delta = Math.sqrt(b * b - 4 * a * c);
        double x1 = (-b + delta) / 2 * a;
        double x2 = (-b - delta) / 2 * a;
        System.out.println("The roots for your quadratic equation is: ");
        System.out.println(x1);
        System.out.println("and");
        System.out.println(x2);

    }
}
