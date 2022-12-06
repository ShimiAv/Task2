package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printBiggerThenAaverage();
    }

    public static void printBiggerThenAaverage() {
        double average = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 10 numbers");
        int[] userArr = new int[10];
        for (int i = 0; i < userArr.length; i++) {
            userArr[i] = scanner.nextInt(); //מקבל מערך של מס מהמשתמש
        }
        for (int i = 0; i < userArr.length; i++)
            average += userArr[i];
        average = average / userArr.length;
        for (int i = 0; i < userArr.length; i++) {
            if (userArr[i] > average) {
                System.out.println(userArr[i] + " ");
            }
        }


    }


}

