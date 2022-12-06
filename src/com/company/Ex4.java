package com.company;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        int[] inputUserArray = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type digits: ");
        for (int i = 0; i < inputUserArray.length; i++) {
            inputUserArray[i] = scanner.nextInt();
        }
        System.out.println("array: " + growDecrease(inputUserArray));
    }

    public static int growDecrease(int[] inputUserArray) {
        int index = 0;
        for (int i = 0; i < inputUserArray.length; i++) {
            if (inputUserArray[i] < inputUserArray[i + 1]) {
                index = i;
            } else {
                index = i;
                break;
            }
            if (i == inputUserArray.length - 2) {
                break;
            }
        }

        for (int j = index; j < inputUserArray.length; j++) {
            if (j == inputUserArray.length - 1) {
                return index;
            }
            if (inputUserArray[j] < inputUserArray[j + 1]) {
                return -1;
            }
        }
        return index;
    }
}