package finishedScapeRoom.Helpers;

import java.util.Scanner;

public class InputHelper {


    public static Scanner scanner = new Scanner(System.in);


    //TODO aquests metodes millor a una classe a part . Rotllo InputHelper
    public static int inputInt(String request){
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(request);
            try {
                input =  scanner.nextInt();
                isValid = true;
            } catch(NumberFormatException e) {
                System.err.println("Format Error. Please enter a valid integer.");
            } finally {
                scanner.nextLine();
            }
        }
        return input;
    }

    public static double inputDouble(String request){
        double input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(request);
            try {
                input =  scanner.nextDouble();
                isValid = true;
            } catch(NumberFormatException e) {
                System.err.println("Format Error. Please enter a valid double.");
            } finally {
                scanner.nextLine();
            }
        }
        return input;
    }

    public static String inputString(String missatge){
        boolean isValid  = false;
        String userInput = "";
        do {
            try {
                System.out.println(missatge);
                userInput = scanner.nextLine();
                isValid = true;
            } catch (Exception e) {
                System.out.println("Format Error. Introduce a String.");
            }
        } while (!isValid || userInput.length() == 0);
        return userInput;
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
