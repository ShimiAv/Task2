package com.company;

public class Ex3 {
    public static void main(String[] args) {
        int[] myArr = new int[] {2,6,2,6};
        int [] arrWithNoDups = removeDupsFromArr(myArr);
        for (int i=0; i<arrWithNoDups.length;i++){
            System.out.println(arrWithNoDups[i]);
        }

    }

    public static int[] removeDupsFromArr(int[] myArr) {
        int[] tempArr = new int[myArr.length];
        int dupsCounter = 0;
        for (int i = 0; i < myArr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (myArr[i] == myArr[j]) {
                    tempArr[j] = myArr[i];
                    dupsCounter++;
                }
            }

        }
        int noDupsArrIndex = 0;
        int[] arrayAfterDupsRemoved = new int[tempArr.length - dupsCounter];
        for (int i = 0; i < tempArr.length; i++)
            if (tempArr[i] != 0) {
                arrayAfterDupsRemoved[noDupsArrIndex] = tempArr[i];
                noDupsArrIndex++;
            }


    return arrayAfterDupsRemoved;
    }

}
