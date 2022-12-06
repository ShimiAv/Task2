package com.company;
import java.util.Scanner;
import java.util.Random;

public class Ex7 {
    public static void main(String[] args) {
        startGame();
    }
    public static void startGame (){
        Random random = new Random();
        int tries=0;
        int chosenLvl=level();
        final int lvlOneTries = 20;
        final int lvlTwoTries = 15;
        final int lvlThreeTries = 10;
        final int secretLvlTries = random.nextInt(5,25);
        if (chosenLvl==1){
            tries=lvlOneTries;}
        else if (chosenLvl==2){
            tries=lvlTwoTries;}
        else if (chosenLvl==3){
            tries=lvlThreeTries;}
        else if (chosenLvl==4){
            tries=secretLvlTries;}
        String secretNumber = generateSecretPass();
        do {
            String userGuess = userGuess();
            tries=checkGuess(secretNumber,userGuess,tries,chosenLvl);
        }while (tries>0);

    }

    public static int level ()
    {
        Scanner scanner = new Scanner(System.in);
        int chosenLvl;


        System.out.println("Chose the level you want");
        System.out.println("(1) Lvl 1 gives you 20 guesses");
        System.out.println("(2) Lvl 2 gives you 15 guesses");
        System.out.println("(3) Lvl 3 gives you 10 guesses");
        System.out.println("(4) Surprise me level that a random number of guesses between 5-25");
        do {
            chosenLvl = scanner.nextInt();
        }while (chosenLvl>4 || chosenLvl<1);
        return chosenLvl;
    }
    public static String generateSecretPass ()
    {
        int counter = 0;
        Random random = new Random();
        int randomNum = random.nextInt(1,6);
        String secretPass = ""+randomNum;
        do {
            do {
                randomNum = random.nextInt(1, 6);
            } while (secretPass.contains("" + randomNum));
            secretPass= secretPass+randomNum;
            counter++;
        }while (counter<3);
        return secretPass;
    }
    public static String userGuess (){
        String userGuess;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your guess");
            userGuess= scanner.nextLine();
        }while (userGuess.length() != 4);
        return userGuess;
    }
    public static int checkGuess (String secret, String guess, int triesLeft, int level) {
        boolean isThereDuplicates=false;
        int correctPlaceGuess=0;
        int incorrectPlaceGuess=0;
        if (secret.equals(guess)) {
            System.out.println("Congrats you guessed the secret passcode");
            triesLeft = 0;
        }
        else {for (int i = 0; i < secret.length(); i++) {
            if (guess.indexOf(secret.substring(i,i+1))==i) {
                correctPlaceGuess++;
            }if (secret.contains(guess.substring(i,i+1))) {
                incorrectPlaceGuess++;
            }
        }
            char checkDuplicates;
            for (int i = 0; i<guess.length();i++) {
                checkDuplicates=guess.charAt(i);
                for (int j=i+1;j<guess.length()-i;j++) {
                    isThereDuplicates= checkDuplicates == guess.charAt(j);
                    if (isThereDuplicates)
                        break;
                }
                if (isThereDuplicates)
                    break;
            }
            if (isThereDuplicates){
                System.out.println("Attention! Your guess contains duplicates so you got fined with 2 tries!");
                triesLeft-=2;
                if (level!=4)
                    System.out.println("You have: "+ triesLeft+" tries left");}
            else {triesLeft--;
                System.out.println("You got: ("+correctPlaceGuess+") correct guesses at the correct place and: ("+(incorrectPlaceGuess-correctPlaceGuess)+") correct guesses at incorrect place");
                if (level!=4){
                    System.out.println("You got: "+triesLeft+" tries left");}}
            if (triesLeft==0) {
                System.out.println("You out of tries and was unable to guess the secret passcode that was: "+secret);
            }
        }
        return triesLeft;
    }
}

